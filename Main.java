import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static List<Range> allRanges = new ArrayList<>();

    /**
     * Counts how many times passed integer argument is enclosed by ranges.
     * Function iterates on the array list of ranges and uses encloses() methods from Range class.
     * @param enclosedNumber positive integer number
     * @return integer value for how many times passed number was enclosed.
     */
    public static int countEnclosedRanges(int enclosedNumber) {
        int enclosesCount = 0;

        for(int i = 0; i < allRanges.size(); i++) {
            if(allRanges.get(i).encloses(enclosedNumber)) {
                enclosesCount++;
            }
        }

        return enclosesCount;
    }

    /**
     * Generates new objects of Range class and adds them to array list.
     * @param n number of Ranges to generate.
     * @param lowerBoundary minimal possible random value
     * @param upperBoundary maximal possible random value
     */
    public static void generateRanges(int n, int lowerBoundary, int upperBoundary) {
        for(int i = 0; i < n; i++) {
            Range range = new Range(lowerBoundary, upperBoundary);
            allRanges.add(range);
        }
    }

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new CustomShutdown());
        int max = 1000000000;
        int maxN = 1000000;
        int n = maxN;
        int enclosedNumber;

        System.out.print("Enter your N number: ");

        try {
            n = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            throw new IOException("Inserted text is not a number or is bigger than maximum integer value");
        }

        if(n > maxN || n < 0) {
            throw new IOException("Incorrect number! Entered number must be an integer with maximum value: " + maxN);
        }

        System.out.println("Great! You've selected number: " + n);

        generateRanges(n, 0, max);

        while(true) {
            enclosedNumber = ThreadLocalRandom.current().nextInt(0, maxN + 1);
            System.out.format("%d => Enclosed by %d range(s) %n", enclosedNumber, countEnclosedRanges(enclosedNumber));
        }
    }
}
