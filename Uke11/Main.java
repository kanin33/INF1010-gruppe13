class Main {
    public static void main(String[] args) {
        Monitor m = new Monitor();
        for(int i = 0; i < 3; i++) {
            Traad t = new Traad(m);
            t.start();
        }
        while(Thread.activeCount() > 1) {}
        System.out.println(m.hentUt());
    }
}
