class Test4 {
    public static void main(String[] args) {
        SimpleArrayList<String> s = new SimpleArrayList<String>(100);
        s.leggInn("Test1");
        s.leggInn("Test2");
        s.leggInn("Test3");

        for(String st : s) {
            System.out.println(st);
        }
    }
}
