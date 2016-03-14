import java.util.*;
class Test {
    public static void main(String[] args) {
        Lenkeliste<String> liste = new Lenkeliste<String>();
        liste.leggInn("halo");
        Iterator i = liste.iterator();
        try {
            i.next();
            int[] array = {1};
            System.out.println(array[5]);
        } catch (IllegalStateException e) {
            System.out.println("Illegal state");
        } catch (NoSuchElementException e) {
            System.out.println("No next");
        } catch(IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }
}
