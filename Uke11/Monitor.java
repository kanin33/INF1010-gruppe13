class Monitor {
    int data = 1;

    public synchronized boolean leggInnVerdi(int verdi) {
        data = data + verdi;
        if(data < 10000) {
            return false;
        }
        return true;
    }

    public synchronized int hentUt() {
        return data;
    }
}
