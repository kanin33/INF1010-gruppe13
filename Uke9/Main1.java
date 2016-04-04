class Main1 {
    public static void main(String[] args) {
        HelloRun h = new HelloRun("run");
        for(int i=0; i < 4; i++){
            Thread t = new Thread(h);
            t.start();
        }
        for(int i=0; i < 4; i++){
            HelloThread t = new HelloThread(Integer.toString(i));
            t.start();
        }

    }
}
