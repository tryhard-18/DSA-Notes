package comDSA.company;

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchST<Key extends Comparable<Key>, Value>{
    Key[] keys;
    Value[] values;
    int N;
    BinarySearchST(int capacity){
        keys = (Key[])new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value value){
        int index = rank(key);
        if(index<N && keys[index].compareTo(key)==0){
            values[index] = value;
            return;
        }
        for(int j=N;j>index;j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[index] = key;
        values[index] = value;
        N++;
    }

    public Value get(Key key){
        if(isEmpty()){
            return null;
        }
        int index = rank(key);
        if(index<N && keys[index].compareTo(key)==0){
            return values[index];
        }
        return null;
    }

    private int rank(Key key){
        int lo = 0;
        int hi = N-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(keys[mid].compareTo(key)>0){
                hi = mid-1;
            }
            else if(keys[mid].compareTo(key)<0){
                lo = mid+1;
            }
            else return mid;
        }
        return lo;
    }

    public void delete(Key key){
        int index = rank(key);
        if(index==N || keys[index].compareTo(key)!=0){
            System.out.println("Key is not present");
            return;
        }
        for(int i=index;i<N-1;i++){
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        keys[N-1] = null;
        values[N-1] = null;
        N--;

//        ANOTHER METHOD OF DELETE.
//        int index = rank(key);
//        if(index<N && keys[index]==key){
//            for(int i=index;i<N-1;i++){
//                keys[i] = keys[i+1];
//                values[i] = values[i+1];
//            }
//            keys[N-1] = null;
//            values[N-1] = null;
//            N--;
//            return;
//        }
//        System.out.println("Key is not present");
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> que = new LinkedList<>();
        for(int i = rank(lo); i<rank(hi); i++){
            que.add(keys[i]);
        }
        if(contains(hi)){
            que.add(keys[rank(hi)]);
        }
        return que;
    }

    public Iterable<Key> keys(){
        Queue<Key> que = new LinkedList<>();
        for(int i=0;i<N;i++){
            que.add(keys[i]);
        }
        return que;
    }

    public boolean contains(Key key){
        int index = rank(key);
        return (index<N && keys[index].compareTo(key)==0);
    }

    public Key floor(Key key){
        int index = rank(key);
        if(index<N && keys[index].compareTo(key)==0){
            return keys[index];
        }
        else if(index>0){
            return keys[index-1];
        }
        return null;
    }

    public Key ceiling(Key key){
        int index = rank(key);
        if(index<N) {
            return keys[index];
        }
        return null;
    }

    public Key select(int k){
        return keys[k];
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N-1];
    }
}

public class SymbolTableUsingBinarySearch {
    public static void main(String[] args) {
        BinarySearchST<Integer, String> obj = new BinarySearchST<>(4);
        obj.put(10,"Kushal");
        obj.put(30,"Flash");
        obj.put(40,"Maverick");
        obj.put(20,"Dominic");
        for(Integer el: obj.keys(10,45)){
            System.out.print(el+":"+ obj.get(el)+"  ");
        }
        System.out.println();
        for(Integer el: obj.keys()){
            System.out.print(el+":"+ obj.get(el)+"  ");
        }
        System.out.println();
        System.out.println(obj.size());
        System.out.println(obj.select(2));
        System.out.println(obj.ceiling(45));
        System.out.println(obj.floor(45));
        obj.delete(30);
        for(Integer el: obj.keys()){
            System.out.print(el+":"+ obj.get(el)+"  ");
        }
    }
}
