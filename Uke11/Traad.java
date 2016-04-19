class Traad extends Thread {
    private Monitor m;
    private int verdi;

    public Traad(Monitor m) {
        this.m = m;
        verdi = 0;
    }

    @Override
    public void run() {
        int tmp = m.hentUt();
        for(int i = 0; i < 1000; i++) {
            verdi++;
        }
        while(!m.leggInnVerdi(verdi)) {
            tmp = m.hentUt();
            for(int i = 0; i < 1000; i++) {
                verdi++;
            }
        }
    }
}
