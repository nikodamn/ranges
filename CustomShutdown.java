class CustomShutdown extends Thread {

    /**
     * This method overrides default methods for handling CTRL + C interruption.
     */
    @Override
    public void run() {
        System.out.println("Program is exiting...");
    }
}
