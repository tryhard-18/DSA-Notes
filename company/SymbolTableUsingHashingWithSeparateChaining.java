package comDSA.company;

class SeparateChainingHashST<Key, Value>{
    private int M;
    private int N;
    private SequentialSearchST<Key, Value>[] st;
    public SeparateChainingHashST(){
        this(997);
    }
    public SeparateChainingHashST(int M){
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[this.M];
        for(int i=0;i<M;i++){
            st[i] = new SequentialSearchST<>();
        }
    }
    public int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(Key key, Value value){
        st[hash(key)].put(key, value);
    }
    public Value get(Key key){
        return st[hash(key)].get(key);
    }
}
public class SymbolTableUsingHashingWithSeparateChaining {
    public static void main(String[] args) {
        SeparateChainingHashST<Integer, String> obj = new SeparateChainingHashST<>();
        obj.put(2,"Kushal");
        obj.put(1,"Flash");
        obj.put(3,"Dominic");
        obj.put(127,"Maverick");
        obj.put(128,"Fanatic");
        System.out.println(obj.get(1));
        System.out.println(obj.get(127));
        System.out.println(obj.get(128));   //Why this is giving null? Above keys from 128 are giving null. Why?
    }
}
