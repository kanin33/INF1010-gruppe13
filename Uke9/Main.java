import java.util.Random;
class Main {
    public static void main(String[] args) {
        int antTraader = 4;
        Monitor m = new Monitor(antTraader);
        int antTall = 10;
        double[] array = new double[antTall];
        Random r = new Random();
        for(int i = 0; i < antTall; i++) {
            array[i] = r.nextDouble();
        }
        for(int i = 0; i < antTraader; i++) {
            (new MaxTraad(m, i*antTall/4, (i+1)*antTall/4 - 1, array)).start();
        }
        System.out.println(m.hentVerdi());
    }
}
