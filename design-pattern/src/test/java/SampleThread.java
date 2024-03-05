
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;

public class SampleThread extends Thread {
    public int processingCount = 0;

    private Logger LOGGER = LoggerFactory.getLogger(SampleThread.class);

    SampleThread(int processingCount) {
        this.processingCount = processingCount;
        LOGGER.info("Thread Created");
    }

    @Override
    public void run() {
        LOGGER.info("Thread " + this.getName() + " started");
        while (processingCount > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.info("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
            LOGGER.info("Inside Thread " + this.getName() + ", processingCount = " + processingCount);
        }
        LOGGER.info("Thread " + this.getName() + " exiting");
    }


    @Test
    public void givenStartedThread_whenJoinCalled_waitsTillCompletion()
            throws InterruptedException {
        Thread t2 = new SampleThread(1);
        t2.start();
        LOGGER.info("Invoking join");
        t2.join();
        LOGGER.info("Returned from join");
        assertFalse(t2.isAlive());
    }
}


