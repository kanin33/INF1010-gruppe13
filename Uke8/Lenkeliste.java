import java.util.*;

class Lenkeliste<E> implements Iterable<E>{
    private Node forste;
    private int lengde = 0;

    private class Node {
        E verdi;
        Node neste;
        public Node(E verdi) {
            this.verdi = verdi;
        }
    }

    public Lenkeliste() {
        forste = new Node(null);
    }

    public void leggInn(E verdi) {
        Node ny = new Node(verdi);
        ny.neste = forste.neste;
        forste.neste = ny;
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
            if(hasNext()) {
                E verdi = denne.neste.verdi;
                denne = denne.neste;
                return verdi;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public Iterator<E> iterator() {
        return new LenkeIterator();
    }
}
