import java.util.*;

class LenkeListe<E> implements Iterable<E> {
    Node forste;
    Node siste;

    private class Node {
        E verdi;
        Node neste;
        Node forrige;
        public Node(E verdi) {
            this.verdi = verdi;
        }
    }

    public LenkeListe() {
        forste = new Node(null);
        siste = new Node(null);
        forste.neste = siste;
        siste.forrige = forste;
    }

    public void settInn(E verdi) {
        Node ny = new Node(verdi);
        siste.forrige.neste = ny;
        ny.forrige = siste.forrige;
        siste.forrige = ny;
        ny.neste = siste;
    }

    public E taUt() {
        if(forste.neste == siste) {
            return null;
        }
        E tmp = forste.neste.verdi;
        forste.neste.neste.forrige = forste;
        forste.neste = forste.neste.neste;
        return tmp;
    }

    private class LenkeIterator implements Iterator<E> {
        Node denne;

        public LenkeIterator() {
            denne = forste;
        }
        public boolean hasNext() {
            return denne.neste != siste;
        }

        public E next() {
            denne = denne.neste;
            return denne.verdi;
        }

        public void remove() {}
    }

    public Iterator<E> iterator() {
        return new LenkeIterator();
    }
}
