package comDSA.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

class BSTSymbolTable<Key extends Comparable<Key>, Value>{
    private Node root;
    private class Node {
        Key key;
        Value value;
        int N;
        Node left;
        Node right;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
        public int size(){
            return size(root);
        }
        private int size(Node x){
            if(x==null){
                return 0;
            }
            return x.N;
        }
        public Value get(Key key){
            return get(root, key);
        }
        private Value get(Node x, Key key){
            if(x==null){
                return null;
            }
            int cmp = key.compareTo(x.key);
            if(cmp>0){
                return get(x.right, key);
            }
            else if(cmp<0){
                return get(x.left, key);
            }
            else {
                return x.value;
            }
        }
        public void put(Key key, Value value){
            root = put(root, key, value);
        }
        private Node put(Node x, Key key, Value value){
            if(x==null){
                return new Node(key, value, 1);
            }
            int cmp = key.compareTo(x.key);
            if(cmp<0){
                x.left = put(x.left, key, value);
            }
            else if(cmp>0){
                x.right = put(x.right, key, value);
            }
            else {
                x.value = value;
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }
        public Key min(){
            return min(root).key;
        }
        private Node min(Node x){
            if(x.left==null){
                return x;
            }
            return min(x.left);
        }
        public Key max(){
            return max(root).key;
        }
        private Node max(Node x){
            if(x.right==null){
                return x;
            }
            return max(x.right);
        }
        public Key floor(Key key){
            Node x = floor(root, key);
            if(x==null){
                return null;
            }
            return x.key;
        }
        private Node floor(Node x, Key key){
            if (x==null){
                return null;
            }
            int cmp = key.compareTo(x.key);
            if(cmp==0){
                return x;
            }
            else if(cmp<0){
                return floor(x.left, key);
            }
            Node t = floor(x.right, key);
            if(t!=null){
                return t;
            }
            else {
                return x;
            }
//            return Objects.requireNonNullElse(t, x);   //Just above if else can be replaced by this single statement.
        }
        public Key ceiling(Key key){
//            if(key == null){
//                return null;
//            }
//            return ceiling(root, key).key;
            Node x = ceiling(root,key);
            if(x==null){
                return null;
            }
            return x.key;
        }
        private Node ceiling(Node x, Key key){
            if(x==null){
                return null;
            }
            int cmp = key.compareTo(x.key);
            if(cmp == 0){
                return x;
            }
            if(cmp>0){
                return ceiling(x.right, key);
            }
            Node t = ceiling(x.left, key);
            if(t!=null){
                return t;
            }
            return x;
        }
        public Key select(int k){
            return select(root, k).key;
        }
        private Node select(Node x, int k){
            if(x==null){
                return null;
            }
            int t = size(x.left);
            if(t>k){
                return select(x.left, k);
            }
            else if(t<k){
                return select(x.right, k-t-1);
            }
            else{
                return x;
            }
        }
        public int rank(Key key){
            return rank(root, key);
        }
        private int rank(Node x, Key key){
            if(x==null){
                return 0;
            }
            int cmp = key.compareTo(x.key);
            if(cmp==0){
                return size(x.left);
            }
            else if(cmp>0){
                return 1 + size(x.left) + rank(x.right, key);
            }
            else{
                return rank(x.left, key);
            }
        }
        public void deleteMin(){
            root = deleteMin(root);
        }
        private Node deleteMin(Node x){
            if(x.left==null){
                return x.right;
            }
            x.left = deleteMin(x.left);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }
        public void delete(Key key){
            root = delete(root, key);
        }
        private Node delete(Node x, Key key){
            if(x == null){
                return null;
            }
            int cmp = key.compareTo(x.key);
            if(cmp<0){
                x.left = delete(x.left, key);
            }
            else if(cmp>0){
                x.right = delete(x.right, key);
            }
            else{
                if(x.left == null){
                    return x.right;
                }
                if(x.right == null){
                    return x.left;
                }
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }
        public void keys(){
            keys(root);
        }
        public void keys(Node x){
            if(x==null){
                return;
            }
            keys(x.left);
            System.out.println(x.key);
            keys(x.right);
        }
        public Iterable<Key> keys(Key lo, Key hi){
            Queue<Key> que = new LinkedList<>();
            keys(root, que, lo, hi);
            return que;
        }
        private void keys(Node x, Queue<Key> que, Key lo, Key hi){
            if(x==null){
                return ;
            }
            int cmplo = lo.compareTo(x.key);
            int cmphi = hi.compareTo(x.key);
            if(cmplo<0){
                keys(x.left, que, lo, hi);
            }
            if(cmplo<=0 && cmphi>=0){
                que.add(x.key);
            }
            if(cmphi>0){
                keys(x.right, que, lo, hi);
            }
        }

}
public class SymbolTableUsingBinarySearchTree {
    public static void main(String[] args) {
//        BSTSymbolTable<Integer, ArrayList<String>> obj = new BSTSymbolTable<>();
//        ArrayList<String> str = new ArrayList<>();
//        str.add("Fanatic");
//        str.add("Maverick");
//        obj.put(2,str);
//        obj.put(1, new ArrayList<>());
//        obj.get(1).add("Flash");
//        obj.get(1).add("Kushal");
//        System.out.println(obj.get(1));
//        System.out.println(obj.get(2));

        BSTSymbolTable<Integer,String> obj = new BSTSymbolTable<>();
        obj.put(20,"Kushal");
        obj.put(30,"Flash");
        obj.put(10,"Dominic");
        obj.put(50,"Maverick");
        obj.put(40,"Fanatic");
        obj.keys();
        System.out.println(obj.get(30));
        System.out.println(obj.get(10));
        System.out.println(obj.get(50));
        System.out.println(obj.min());
        System.out.println(obj.max());
        System.out.println(obj.floor(34));
        System.out.println(obj.ceiling(35));
        System.out.println(obj.select(4));
        System.out.println(obj.rank(50));
        obj.delete(30);
        obj.keys();
        System.out.println();
        for(Integer el:obj.keys(20,45)){
            System.out.print(el+" ");
        }
    }
}
