class HelloThread extends Thread {
    String tekst;
    public HelloThread(String tekst) {
        this.tekst = tekst;
    }
    public void run() {
        System.out.println(tekst);
        try{
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("hallo");
    }
}
