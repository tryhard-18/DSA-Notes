package comDSA.company;

import java.util.Iterator;
import java.util.Stack;

class stackUA<Item> implements Iterable<Item>{
    Item[] a =(Item[]) new Object[1];
    int N;

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void resize(int cap){
        Item[] temp =(Item[]) new Object[cap];
        for(int i=0;i<N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if(N == a.length){
            resize(2*a.length);
        }
        a[N] = item;
        N++;
    }

    public Item pop(){
        if(N<=0){
            System.out.println("Stack is Underflow");
            return null;
        }
        if(N == a.length/4 && N>0){
            resize(a.length/2);
        }
        return a[--N];
    }

    @Override
    public Iterator<Item> iterator() {
//        return new ReverseArrayIterator();
        return new Iterator<Item>() {
            int i = N;
            @Override
            public boolean hasNext(){
                return i>0;
            }
            @Override
            public Item next(){
                return a[--i];
            }
        };
    }

//    class ReverseArrayIterator implements Iterator<Item>{
//        int i = N;
//        @Override
//        public void remove() { }
//
//        @Override
//        public Item next() {
//            return a[--i];
//        }
//
//        @Override
//        public boolean hasNext() {
//            return i>0;
//        }
//    }
}

public class StackImplementationUsingArray {
    public static void main(String[] args) {
        stackUA<String> stk = new stackUA<>();
        stackUA<Integer> stk1 = new stackUA<>();
        stk1.push(10);
        stk1.push(20);
        stk1.push(30);
        stk.push("Flash");
        stk.push("Dominic");
        stk.push("Maverick");
        stk.push("Fanatic");
        for(String str:stk){
            System.out.print(str+" ");
        }
        System.out.println();
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.isEmpty());
        System.out.println(stk.size());
        System.out.println(stk.pop());
        stk.pop();
        System.out.println(stk.isEmpty());
        for(Integer el:stk1){
            System.out.print(el+" ");
        }
    }

}
