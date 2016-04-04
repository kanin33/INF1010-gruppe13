class Test2 {
    public static void main(String[] args) {
        Counter cnt = new Counter();
        (new Thread(cnt)).start();
        (new Thread(cnt)).start();
        while(Thread.activeCount() > 1) {};
        System.out.println(cnt.value());
    }
}
