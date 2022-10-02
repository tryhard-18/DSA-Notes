package comDSA.company;

import java.util.Iterator;

class stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node{
        Node next;
        Item item;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }

    public Item peek(){
        return first.item;
    }
    public void push(Item item){
        Node temp = new Node();
        temp.item = item;
        temp.next = first;
        first = temp;
        N++;
    }
    public Item pop(){
        if(first == null){
            System.out.println("Stack is Underflow");
            return null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    class ListIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null ;
        }

        @Override
        public void remove() { }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
public class StackImplementationUsingLinkedList {
    public static void main(String[] args) {
        stack<Integer> stk = new stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        for(Integer i:stk){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(stk.pop());
        System.out.println(stk.isEmpty());
        System.out.println();
        System.out.println(stk.size());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.isEmpty());
        System.out.println();
        System.out.println(stk.size());
        stk.pop();
        System.out.println();
        stk.push(10);
        System.out.println(stk.peek());
    }
}



