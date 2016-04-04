class Counter implements Runnable {
    private int c = 0;

    public void run() {
        for (int i = 0; i < 20000; i++) {
            increment();
        }
        for (int i = 0; i < 20000; i++) {
            decrement();
        }
    }

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}
