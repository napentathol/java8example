package us.sodiumlabs.exampleJ8;

import java.util.logging.Logger;

/**
 * Created by Alex on 3/20/2014.
 *
 * Yo, cool example time.
 */
public abstract class AbstractJavaExample {
    private static final Logger LOGGER = Logger.getLogger(JavaSix.class.getName());

    protected static final String ERROR_PRONE = "error prone";

    protected static final String DELICATE = "delicate";

    protected static final String BUGGY = "buggy";

    /**
     * An example closeable resource that always seems to fail. No idea why.
     */
    protected class BuggyCloseableResource implements AutoCloseable{

        /**
         * Creates a new BuggyCloseableResource
         */
        public BuggyCloseableResource(){
            LOGGER.info("Opening a buggy resource!");
        }

        /**
         * An impossibly error prone method.
         *
         * TODO: look into why this always fails.
         *
         * @throws TestThrowable always.
         */
        public void impossiblyErrorProneMethod() throws TestThrowable {
            throw new TestThrowable("Time to die!");
        }

        /**
         * An incredibly delicate operation.
         *
         * TODO: look into why this always fails.
         *
         * @throws TrialThrowable always.
         */
        public void incrediblyDelicateOperation() throws TrialThrowable {
            throw new TrialThrowable("The agony, oh the agony!");
        }

        /**
         * A surprisingly poorly designed mutation.
         *
         * TODO: look into why this always fails.
         *
         * @throws ExperimentalThrowable always.
         */
        public void surprisinglyPoorlyDesignedMutation() throws ExperimentalThrowable{
            throw new ExperimentalThrowable("My only regret is that I have but one finalize() to give!");
        }

        /**
         * Closes this buggy resource.
         *
         * @throws BuggyResourceCloseException almost never.
         */
        public void close() throws BuggyResourceCloseException {
            LOGGER.info("Closing a buggy resource!");
            if(almostNeverTrue()){
                throw new BuggyResourceCloseException();
            }
        }

        private boolean almostNeverTrue(){
            return false;
        }
    }

    /**
     * An example Throwable.
     */
    protected class TestThrowable extends Throwable{
        /**
         * Instantiates this example Throwable.
         *
         * @param msg a short message explaining what happened.
         */
        public TestThrowable(String msg){
            super(msg);
        }
    }

    /**
     * An example Throwable.
     */
    protected class TrialThrowable extends Throwable{
        /**
         * Instantiates this example Throwable.
         *
         * @param msg a short message explaining what happened.
         */
        public TrialThrowable(String msg){
            super(msg);
        }
    }

    /**
     * An example Throwable.
     */
    protected class ExperimentalThrowable extends Throwable{
        /**
         * Instantiates this example Throwable.
         *
         * @param msg a short message explaining what happened.
         */
        public ExperimentalThrowable(String msg){
            super(msg);
        }
    }

    protected class BuggyResourceCloseException extends Exception {}

    /**
     * Test the buggy class.
     *
     * @param msg a short message detailing which piece of the code to test.
     */
    public abstract void test(final String msg);
}
