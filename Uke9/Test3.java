class Test3 {
    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
        while(Thread.activeCount() > 1) {}
        System.out.println(c.value());
    }
}
