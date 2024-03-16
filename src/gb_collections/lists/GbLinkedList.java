package gb_collections.lists;


import gb_collections.GbList;

import java.util.Iterator;

public class GbLinkedList<E> implements GbList<E> {
    transient int size;
    transient Node<E> first;
    transient Node<E> last;

    public GbLinkedList(){
        first = new Node<E>(null, null, last);
        last = new Node<E>(first, null, null);
        size = 0;

    }
    public void addFirst(E value) {
        // first
        Node<E> first1 = first;
        first1.setCurElem(value);
        first = new Node<E>(null, null, first1);
        first1.setPrevElem(first);
        size++;
    }
    @Override
    public void add(E value) {
        Node<E> last1 = last;
        Node<E> prevLast = last.getPrevElem();
        last1.setCurElem(value);
        last = new Node<E>(last1, null, null);
        prevLast.setNextElem(last1);
        last1.setNextElem(last);
        size++;
    }


    @Override
    public void add(int index, E value) {
        Node <E> item = first.getNextElem();
        for(int i = 0; i<index; i++){
            item = item.getNextElem();
        }

        Node <E> itemPrev = item.getPrevElem();
        Node <E> newItem = new Node<>(itemPrev, value, item);
        itemPrev.setNextElem(newItem);
        item.setPrevElem(newItem);
        size++;
    }

    @Override
    public E get(int index) {
        int count = 0;
        Node <E> item = first.getNextElem();
        while (count<index){
            item = item.getNextElem();
            count++;
        }
        return item.getCurElem();
    }

    @Override
    public void remove(E value) {
        Node <E> item = first.getNextElem();
        for (int i = 0; i < size; i++){
            item = item.getNextElem();
            if (value == item.getCurElem()){
                Node<E> item1 = item.getPrevElem();
                Node<E> item2 = item.getNextElem();
                item1.setNextElem(item.getNextElem());
                item2.setPrevElem(item.getPrevElem());
                size--;
                return;
            }
        }
    }


    @Override
    public void removeByIndex(int index) {
        int count = 0;
        Node <E> item = first.getNextElem();
        while (count<index-2){
            item = item.getNextElem();
            count++;
        }
        Node <E> item1 = item.getNextElem();
        Node <E> item2 = item1.getNextElem();

        item.setNextElem(item1.getNextElem());
        item2.setPrevElem(item1.getPrevElem());
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter =0;
            @Override
            public boolean hasNext() {
                return counter < size();
            }

            @Override
            public E next() {
                return get(counter++);
            }
        };
    }

    private static class Node<E> {
        private E elem;
        private Node<E> next;
        private Node<E> prev;

        private Node(Node<E> prev, E element, Node<E> next) {
            this.elem = element;
            this.next = next;
            this.prev = prev;
        }
        private E setCurElem(E value){
            return this.elem = value;
        }
        private Node<E> setNextElem(Node<E> value){
            return this.next = value;
        }
        private Node<E> setPrevElem(Node<E> value){
            return this.prev = value;
        }
        private E getCurElem(){
            return this.elem;
        }
        private Node<E> getNextElem(){
            return this.next;
        }
        private Node<E> getPrevElem(){
            return this.prev;
        }
    }
}
