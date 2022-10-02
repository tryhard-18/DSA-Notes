package comDSA.company;

class RedBlackBST<Key extends Comparable<Key>, Value>{
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        Node left;
        Node right;
        Key key;
        Value value;
        int N;
        boolean color;
        private Node(Key key, Value value, int N, boolean color){
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
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
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }
    private boolean isRed(Node x){
        if(x==null){
            return false;
        }
        return x.color==RED;
    }
    private void flipColors(Node x){
        x.left.color = BLACK;
        x.right.color = BLACK;
        x.color = RED;
    }
    public void put(Key key, Value value){
        root = put(root, key, value);
        root.color = BLACK;
    }
    private Node put(Node x, Key key, Value value){
        if(x == null){
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x.left = put(x.left, key, value);
        }
        else if(cmp>0){
            x.right = put(x.right, key, value);
        }
        else{
            x.value = value;
        }
        if (isRed(x.right) && !isRed(x.left)){
            x = rotateLeft(x);
        }
        if(isRed(x.left) && isRed(x.left.left)){
            x = rotateRight(x);
        }
        if(isRed(x.left) && isRed(x.right)){
            flipColors(x);
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    public void keys(){
        keys(root);
    }
    private void keys(Node x){
        if(x==null){
            return;
        }
        keys(x.left);
        System.out.println(x.key);
        keys(x.right);
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
}
public class SymbolTableUsingRedBlackTrees {
    public static void main(String[] args) {
        RedBlackBST<Integer, String> obj = new RedBlackBST<>();
        obj.put(4,"Kushal");
        obj.put(2,"Kushal");
        obj.put(5,"Kushal");
        obj.put(1,"Kushal");
        obj.put(3,"Kushal");
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println();
        obj.keys();
    }
}
