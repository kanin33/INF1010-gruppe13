class Monitor {
    private double forelopigMax = 0;
    private int antTraader;
    private int antFerdigeTraader = 0;

    public Monitor(int antTraader) {
        this.antTraader = antTraader;
    }

    public synchronized void oppdaterMax(double nyMax) {
        if(nyMax > forelopigMax) {
            forelopigMax = nyMax;
        }
        antFerdigeTraader++;
        if(antTraader == antFerdigeTraader) {
            notify();
        }
    }

    public synchronized double hentVerdi() {
        if(antTraader != antFerdigeTraader) {
            try{
                throw new InterruptedException();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return forelopigMax;
    }
}
