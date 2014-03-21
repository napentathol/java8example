package us.sodiumlabs.exampleJ8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alex on 3/20/2014.
 *
 * Demonstrates How things would be built in java six.
 */
public class JavaSix extends AbstractJavaExample{
    private static final Logger LOGGER = Logger.getLogger(JavaSix.class.getName());

    /**
     * Main method so this can be run from the command line.
     *
     * @param args the args passed by the System.
     */
    public static void main(String[] args){
        final JavaSix javaSix = new JavaSix();

        javaSix.test(ERROR_PRONE);
        javaSix.test(DELICATE);
        javaSix.test(BUGGY);
    }

    /**
     * A class to display how things are written in Java 1.6.
     */
    public JavaSix(){
        LOGGER.info("I hope everything works out ok!");
    }

    /**
     * @see {@link us.sodiumlabs.exampleJ8.AbstractJavaExample#test(String,BuggyCloseableResource)}.
     */
    @Override
    public void test(final String msg){
        final BuggyCloseableResource buggyObject = new BuggyCloseableResource();
        try {
            if(ERROR_PRONE.equals(msg)) {
                buggyObject.impossiblyErrorProneMethod();
            } else if(DELICATE.equals(msg)) {
                buggyObject.incrediblyDelicateOperation();
            } else if(BUGGY.equals(msg)){
                buggyObject.surprisinglyPoorlyDesignedMutation();
            }
        } catch (TrialThrowable t) {
            LOGGER.log(Level.WARNING,"The world is ending!", t);
        } catch (TestThrowable t) {
            LOGGER.log(Level.WARNING,"Oh, the humanity!", t);
        } catch (ExperimentalThrowable t) {
            LOGGER.log(Level.WARNING,"Now I have become Garbage Collector, the finalizer of objects.", t);
        } finally { // looks like an anti-pattern to me.
            try {
                buggyObject.close();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Wouldn't it be embarrassing if this failed?", e);
            }
        }
    }
}
