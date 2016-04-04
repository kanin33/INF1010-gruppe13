class MaxTraad extends Thread {
    Monitor monitor;
    double[] array;
    int start, slutt;

    public MaxTraad(Monitor m, int start, int slutt, double[] array) {
        monitor = m;
        this.start = start;
        this.slutt = slutt;
        this.array = array;
    }

    public void run() {
        double max = maxarray(array, start, slutt);
        monitor.oppdaterMax(max);
    }

    public double maxarray(double[] numbers, int start, int slutt) {
        if(slutt - start <= 0) {
            return numbers[start];
        }
        int midten = start + (slutt - start)/2;
        return Math.max(maxarray(numbers, start, midten),
                        maxarray(numbers, midten+1, slutt));
    }
}
