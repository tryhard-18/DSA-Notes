package comDSA.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SequentialSearchST<Key,Value>{
    Node first;
    int N;
    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value delete(Key key){
//        MY METHOD
//        Node i = first;
//        Node j = i;
//        while(i!=null){
//            if(i.key!=key){
//                j=i;
//                i = i.next;
//            }
//            else{
//                j.next = i.next;
//                Value k = i.value;
//                if(i==first){
//                    first = first.next;
//                }
//                i=null;
//                j=null;
//                N--;
//                return k;
//            }
//        }
//        N--;
//        return null;

//        GITHUB METHOD
        if(first == null){
            return null;
        }
        else if (first.key == key){
            Value k = first.value;
            first = first.next;
            N--;
            return k;
        }
        else{
            for(Node i= first; i!=null; i = i.next){
                if(i.next!=null && i.next.key==key){
                    Value k = i.next.value;
                    i.next = i.next.next;
                    N--;
                    return k;
                }
            }
        }
        return null;
    }

    public int size(){
        return N;
    }

    public Iterable<Key> keys(){
        Queue<Key> keys = new LinkedList<>();
        for(Node i = first; i!=null; i=i.next){
            keys.add(i.key);
        }
        return keys;
    }

    public void put(Key key, Value value){
        for(Node i = first; i!=null; i= i.next){
            if(i.key == key){
                i.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        N++;
    }

    public Value get(Key key){
        if (first == null){
            return null;
        }
        for(Node i = first; i!=null; i = i.next){
            if(i.key == key){
                return i.value;
            }
        }
        return null;
    }

}
public class SymbolTableUsingSequentialSearchUsingLinkedList {
    public static void main(String[] args) {
        SequentialSearchST<Integer, String> obj= new SequentialSearchST<>();
        System.out.println(obj.get(1));
        obj.put(1,"Kushal");
        obj.put(2,"Flash");
        obj.put(3,"Dominic");
        obj.put(4,"Maverick");
        obj.put(5,"Fanatic");
        System.out.println(obj.get(6));
        System.out.println(obj.delete(5));
        System.out.println(obj.get(3));
        System.out.println(obj.size());
        for(Integer el: obj.keys()){
            System.out.print(el+" ");
        }
        System.out.println();
        for(Integer el: obj.keys()){
            System.out.print(obj.get(el)+" ");
        }

    }
}
