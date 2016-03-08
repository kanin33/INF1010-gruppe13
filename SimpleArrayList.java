import java.util.*;
class SimpleArrayList<E> implements Iterable<E> {
    private E[] array;
    private int counter = 0;

    public SimpleArrayList(int storrelse) {
        this.array = (E[]) new Object[storrelse];
    }

    public void leggInn(E element) {
        if(counter > array.length - 1) {
            return;
        }
        array[counter] = element;
        counter++;
    }

    private class SimpleIterator implements Iterator<E> {
        int counter2 = 0;
        public boolean hasNext() {
            return counter2 < counter;
        }

        public E next() {
            counter2++;
            return array[counter2-1];
        }

        public void remove() {}
    }

    public Iterator<E> iterator() {
        return new SimpleIterator();
    }
}
