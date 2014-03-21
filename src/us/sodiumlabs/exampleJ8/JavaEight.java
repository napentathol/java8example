package us.sodiumlabs.exampleJ8;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alex on 3/20/2014.
 *
 * Demonstrates How things might be built in java eight.
 * But really, the only cool features are from java seven.
 */
public class JavaEight extends AbstractJavaExample{
    private static final Logger LOGGER = Logger.getLogger(JavaSix.class.getName());

    /**
     * This lambda expression seems a little weird but if I use the more logical one
     * I get a weird error.
     *
     * The hardest part about being so far ahead of the curve is there are no
     * stackexchanges to tell you what you're doing wrong.
     */
    protected final Supplier<BuggyCloseableResource> buggyResourceFactory = () -> new BuggyCloseableResource();

    /**
     * Main method so this can be run from the command line.
     *
     * @param args the args passed by the System.
     */
    public static void main(String[] args){
        final JavaEight javaEight = new JavaEight();

        javaEight.test(ERROR_PRONE);
        javaEight.test(DELICATE);
        javaEight.test(BUGGY);
    }

    /**
     * A class to display how things are written in Java 1.8 .
     */
    public JavaEight(){
        LOGGER.info("I hope everything works out ok!");
    }

    /**
     * @see {@link us.sodiumlabs.exampleJ8.AbstractJavaExample#test(String)} .
     */
    @Override
    public void test(String msg){
        try (final BuggyCloseableResource buggyObject = buggyResourceFactory.get()){
            switch (msg) {
                case ERROR_PRONE:
                    buggyObject.impossiblyErrorProneMethod();
                    break;
                case DELICATE:
                    buggyObject.incrediblyDelicateOperation();
                    break;
                case BUGGY:
                    buggyObject.surprisinglyPoorlyDesignedMutation();
                    break;
            }
        } catch (TrialThrowable | TestThrowable | ExperimentalThrowable | BuggyResourceCloseException t) {
            LOGGER.log(Level.WARNING, "Danger Will Robinson!", t);
        }  // WOW. Such clean. Many throwables. So closed.
    }
}