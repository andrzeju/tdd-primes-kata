package pl.com.urbanlab.kentbeck.xunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Created by andrzej on 10.12.16.
 */
public class TestCaseTest extends TestCase {

    public double log;
    private WasRun test;

    @Before
    public void setUp() {
        test = new WasRun("testMethod");
    }

    @Test
    public void testWasRun() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        WasRun test = new WasRun("testMethod");
        assertFalse(test.wasRun);
        test.run();
        assertTrue(test.wasRun);
    }

    @Test
    public void testSetUp() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        assertFalse(test.wasSetUp);
        test.run();
        assertTrue(test.wasSetUp);
    }


    @Test
    public void testTearDown() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        WasRun test = new WasRun("testMethod");
        assertFalse(test.wasTearDown);
        test.run();
        assertTrue(test.wasTearDown);
    }

    @Test
    public void testProperInvocationOrder() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        WasRun test = new WasRun("testMethod");
        assertEquals("", test.log);
        test.run();
        assertEquals("setUp testMethod tearDown", test.log);
    }

    @After
    public void tearDown() {
    }
}