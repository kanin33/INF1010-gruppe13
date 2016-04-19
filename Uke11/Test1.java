class Test1 {
    public static void main(String[] args) {
        LenkeListe<String> l1 = new LenkeListe<String>();
        LenkeListe<String> l2 = new LenkeListe<String>();
        l1.leggInn("w");
        l1.leggInn("b");
        l1.leggInn("a");
        l2.leggInn("v");
        l2.leggInn("c");
        l2.leggInn("a");
        l2.merge(l1);
        for(String s : l2) {
            System.out.println(s);
        }

        System.out.println("nylinje");
        String[] stringTest = {"a", "afjeb", "h", "q", "b"};
        LenkeListe<String> resultat = mergeSort(stringTest, 0, stringTest.length - 1);
        for(String s: resultat) {
            System.out.println(s);
        }

    }

    public static LenkeListe<String> mergeSort(
            String[] ordListe, int start, int slutt) {
        if(slutt - start == 0) {
            LenkeListe<String> l = new LenkeListe<String>();
            l.leggInn(ordListe[start]);
            return l;
        }

        //System.out.printf("start: %d, slutt: %d, midten: %d", start, slutt, slutt/2);
        LenkeListe<String> l1 = mergeSort(ordListe, start, (slutt+start)/2);
        LenkeListe<String> l2 = mergeSort(ordListe, (slutt+start)/2+1, slutt);
        l1.merge(l2);
        return l1;
    }
}

