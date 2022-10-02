package comDSA.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;



public class check2 {
    private static class stack<Item> implements Iterable<Item>{
        private Node first;

        private class Node{
            private Item item;
            private Node next;
            Node(Item item){
                this.item = item;
            }
        }
        private void push(Item item){
            if(first==null){
                Node temp = new Node(item);
                temp.next = first;
                first = temp;
            }
            else{
                Node temp = new Node(item);
                temp.next = first;
                first = temp;
            }
        }
        private Item pop(){
            if(first==null){
                System.out.println("UnderFlow");
                return null;
            }
            Item data = first.item;
            first = first.next;
            return data;
        }

        @Override
        public Iterator<Item> iterator() {
            return new ListIterator();
        }

        private class ListIterator implements Iterator<Item>{
            private Node current = first;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }
    public static void main(String[] args) {
        stack<Integer> stk = new stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
//        System.out.println(stk.pop());
        for(Integer el:stk){
            System.out.println(el+"");
        }
    }
}


