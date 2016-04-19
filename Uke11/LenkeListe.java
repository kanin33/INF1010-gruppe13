import java.util.*;

class LenkeListe<E extends Comparable> implements Iterable<E>{
    public Node forste;
    private int lengde = 0;

    class Node implements GrNode {
        E verdi;
        Node neste;
        public Node(E verdi) {
            this.verdi = verdi;
        }

        public GrNode hentNeste() {
            return (GrNode) this.neste;
        }

        public void settNeste(GrNode gn) {
            neste = (Node) gn;
        }

        public int compareTo(GrNode n) {
            return verdi.compareTo(((Node) n).verdi);
        }
    }

    public LenkeListe() {
        forste = new Node(null);
    }

    public void leggInn(E verdi) {
        Node ny = new Node(verdi);
        ny.settNeste(forste.hentNeste());
        forste.settNeste(ny);
    }

    private class LenkeIterator implements Iterator<E> {
        Node denne;

        public LenkeIterator() {
            denne = forste;
        }

        public boolean hasNext() {
            return denne.neste != null;
        }

        public void remove() {
            throw new IllegalStateException();
        }

        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            E verdi = denne.neste.verdi;
            denne = denne.neste;
            return verdi;
        }
    }

    public Iterator<E> iterator() {
        return new LenkeIterator();
    }

    public void merge(LenkeListe l) {
        Node denne = forste;
        Node denAndre = l.forste;
        Node tmp;
        Node tmp2;
        while(denne.hentNeste() != null && 
              denAndre.hentNeste() != null) {
            if(denne.hentNeste().compareTo(
                        denAndre.hentNeste()) > 0) {
                tmp = (Node) denne.hentNeste();
                denne.settNeste(denAndre.hentNeste());
                tmp2 = (Node) denAndre.hentNeste().hentNeste();
                denAndre.hentNeste().settNeste(tmp);
                denAndre.settNeste(tmp2);
            } else {
                denne = (Node) denne.hentNeste();
            }
        }
        if(denne.hentNeste() == null) {
            denne.settNeste(denAndre.hentNeste());
        }
    }
}
