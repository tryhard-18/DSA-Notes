package comDSA.company;

import java.util.Iterator;

class queue<Item> implements Iterable<Item>{
    Node first;
    Node last;
    int N;
    private class Node{
        Node next;
        Item item;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node temp = last;
        last = new Node();
        last.item = item;
        last.next = null;
        N++;
        if(first == null){
            first = last;
        }
        if(temp!=null){
            temp.next = last;
        }
    }

    public Item dequeue(){
        if(first == null){
            System.out.println("Queue is UnderFlow");
            return null;
        }
        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        N--;
        return item;
    }


    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<Item>{
        Node current = first;
        @Override
        public Item next() {
            Item item = current.item;
            current= current.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public void remove() {

        }
    }
}

public class QueueImplementationUsingLinkedList {
    public static void main(String[] args) {
        queue<Integer> que = new queue<>();
        que.dequeue();
        que.enqueue(10);
        que.enqueue(20);
        que.enqueue(30);
        que.enqueue(40);
        for(Integer el: que){
            System.out.print(el+" ");
        }
        System.out.println();
        System.out.println(que.dequeue());
        System.out.println(que.size());
        System.out.println(que.isEmpty());
        System.out.println(que.dequeue());
        System.out.println(que.dequeue());
        System.out.println(que.dequeue());
        que.dequeue();
        System.out.println(que.isEmpty());
    }
}
