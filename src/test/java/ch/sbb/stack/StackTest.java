package ch.sbb.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StackTest {

    private Stack stack;

    @Before
    public void setup() {
        stack = new Stack();
    }

    @Test
    public void newStack_isEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void afterOnePush_IsNotEmpty() {
        stack.push(0);
        assertFalse(stack.isEmpty());
    }

    @Test(expected = Stack.Underflow.class)
    public void willThrowUnderflow_WhenEmptyStackIsPopped() {
        stack.pop();
    }

    @Test
    public void afterOnePushAndOnePop_WillBeEmpty() {
        stack.push(0);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void afterTwoPushesAndOnePop_WillNotBeEmpty() {
        stack.push(0);
        stack.push(0);
        stack.pop();
        assertFalse(stack.isEmpty());
    }

    @Test
    public void afterPushingX_WillPopX() {
        stack.push(99);
        assertEquals(99, stack.pop());
        stack.push(88);
        assertEquals(88, stack.pop());
    }

    @Test
    public void afterPushXandY_WillPopYThenX() {
        stack.push(99);
        stack.push(88);
        assertEquals(88, stack.pop());
        assertEquals(99, stack.pop());
    }
}
