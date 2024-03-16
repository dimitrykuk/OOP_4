import gb_collections.GbList;
import gb_collections.lists.GbArrayList;
import gb_collections.lists.GbLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        GbList<Integer> list = new GbArrayList<>();
//        list.add(5);
//        list.add(9);
//        list.add(66);
//        list.add(8);
//        list.add(5);
//        list.add(9);
//        list.add(66);
//        list.add(8);
//        list.add(5);
//        list.add(9);
//        list.add(66);
//        list.add(8);
//        System.out.println(list.size());
//        System.out.println(list);
//        list.removeByIndex(1);
//        list.remove(66);
//        System.out.println(list);
//        GbList<String> s = new GbArrayList<>();
//        s.add("asdf");
//        s.add("xcdf");
//        s.add("hjdf");
//        s.add("lkjf");

        GbLinkedList<Integer> list = new GbLinkedList<>();
        list.addFirst(4);
        list.addFirst(10);
        list.addFirst(100);
        list.addFirst(101);
        list.addFirst(121);
        list.addFirst(1245);
        System.out.println(list.size());
        System.out.println();

        list.add(222);

        System.out.println(list.size());
        System.out.println(list.get(6));
        System.out.println();
        list.add(6,111);
        System.out.println(list.get(6));
        System.out.println(list.size());
        System.out.println();

        list.removeByIndex(6);
        System.out.println(list.get(6));
        System.out.println(list.size());
    }
}