package ch.sbb.stack;

public class Stack {

    private int[] element = new int[2];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        this.element[size++] = element;
    }

    public int pop() {
        if (isEmpty())
            throw new Underflow();
        return element[--size];
    }

    public class Underflow extends RuntimeException {
    }
}
