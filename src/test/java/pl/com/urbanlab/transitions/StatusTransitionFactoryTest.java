package pl.com.urbanlab.transitions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andrzej on 03.01.17.
 */
public class StatusTransitionFactoryTest {

    private StatusTransitionFactory stf;

    @Before
    public void setUp() {
        stf = new StatusTransitionFactory();
    }

    @Test
    public void testCreateTask() throws Exception {
        assertTrue(stf.getTransition(Status.NONE, Status.NEW) instanceof CreateTransition);
    }

    @Test
    public void testNewTransitions() throws Exception {
        assertTrue(stf.getTransition(Status.NEW, Status.STARTED) instanceof StartedTranstion);
        assertTrue(stf.getTransition(Status.NEW, Status.FINISHED) instanceof NewFinishedTranstion);
    }

    @Test
    public void testStartedTransitions() throws Exception {
        assertTrue(stf.getTransition(Status.STARTED, Status.PAUSED) instanceof PausedStartedTranstion);
        assertTrue(stf.getTransition(Status.STARTED, Status.FINISHED) instanceof FinishedStartedTranstion);
    }

    @Test
    public void testFinishedTransitions() throws Exception {
        assertTrue(stf.getTransition(Status.FINISHED, Status.REOPEN) instanceof ReopenedTranstion);
        assertTrue(stf.getTransition(Status.FINISHED, Status.PAUSED) instanceof PausedFinishedTranstion);
    }

//    @Test(expected = Exception.class)
//    public void testNotAllowedTransition() throws Exception {
//        assertTrue(stf.getTransition(Status.FINISHED, Status.FINISHED) instanceof PausedStartedTranstion);
//    }

}