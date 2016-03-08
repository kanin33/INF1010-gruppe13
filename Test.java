import java.util.Iterator;
class Test {
    public static void main(String[] args) {
        LenkeListe<String> l = new LenkeListe<String>();
        l.settInn("TEst");
        l.settInn("TEst2");

        for(String s : l) {
            System.out.println(s);
        }

    }
}
