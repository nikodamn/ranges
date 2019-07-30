import java.util.concurrent.ThreadLocalRandom;

public class Range
{
    private int lowerBoundary;
    private int upperBoundary;

    /**
     * Constructor for generating random ranges.
     * Based on generated random values, method sets lower and upper boundaries of this Range object.
     * @param min integer for minimal possible random value.
     * @param max integer for maximal possible random value.
     */
    Range(int min, int max) {
        int[] boundaries = ThreadLocalRandom.current().ints(2, min, max + 1).toArray();

        if (boundaries[0] < boundaries[1]) {
            this.lowerBoundary = boundaries[0];
            this.upperBoundary = boundaries[1];
        } else {
            this.lowerBoundary = boundaries[1];
            this.upperBoundary = boundaries[0];
        }
    }

    /**
     * Method for checking if number is between lower and upper boundaries of this range.
     * @param n integer number under test.
     * @return true if number is greater or equal than lower boundary AND
     *              if number is lesser or equal than upper boundary
     *         false if number is lesser than lower boundary OR
     *               if number is greater than upper boundary
     */
    public boolean encloses(int n){
        return (n >= lowerBoundary && n <= upperBoundary);
    }
}
