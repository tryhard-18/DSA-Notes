package comDSA.company;

class LinearProbingHashST<Key, Value>{
    Key[] keys;
    Value[] values;
    int M;
    int N;
    LinearProbingHashST(int capacity){
        this.M = capacity;
        keys = (Key[]) new Object[M];
        values = (Value[])   new Object[M];
    }
//    LinearProbingHashST(){
//        keys = (Key[]) new Object[M];
//        values = (Value[])   new Object[M];
//    }
    private int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void put(Key key, Value value){
        if(N>M/2){
            resize(2*M);
        }
        int i;
        for(i=hash(key); keys[i]!=null; i = (i+1)%M){
            if(keys[i].equals(key)){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }
    public Value get(Key key){
        for(int i = hash(key); keys[i]!=null; i = (i+1)%M){
            if(keys[i].equals(key)){
                return values[i];
            }
        }
        return null;
    }
    public void delete(Key key){
        if(keys[hash(key)]==null){
            return;
        }

//        for(int i=hash(key);keys[i]!=null; i =(i+1)%M){
//            if(keys[i]==null){
//                return;                                   //This code is useless but it was written from before so i don't know what is the use.
//            }
//        }

        int j;
        for(j=hash(key);keys[j]!=null; j =(j+1)%M){
            if(keys[j].equals(key)){
                break;
            }                                               //This code(starting from upper extra space till lower space) is for, if key is not present at all and hash value of the key is matching to a key already present in the table.
        }
        if(keys[j]==null){
            return;
        }

        int i = hash(key);
        while(!keys[i].equals(key)){
            i=(i+1)%M;
        }
        keys[i]=null;
        values[i]=null;
        i = (i+1)%M;
        while(keys[i]!=null){
            Key keyToRedo = keys[i];
            Value valToRedo = values[i];
            keys[i] =null;
            values[i] =null;
            N--;   //The need of this is as the put operation will run after this and put operation increment the value of N by 1.
            put(keyToRedo,valToRedo);
            i = (i+1)%M;
        }
        N--;
        if(N>0 && N==M/8){
            resize(M/2);
        }
    }
    private void resize(int newsize){
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<>(newsize);
        for(int i=0;i<M;i++){
            if(keys[i]!=null){
                t.put(keys[i],values[i]);
            }
        }
        keys = t.keys;
        values = t.values;
        M = t.M;
    }
    public int size(){
        return N;
    }

}
public class SymbolTableUsingHashingWithLinearProbing {
    public static void main(String[] args) {
        LinearProbingHashST<Integer,String> obj = new LinearProbingHashST<>(1);
        obj.put(1,"Kushal");
        obj.put(40,"Flash");
        obj.put(200,"Fanatic");
        obj.put(3,"Maverick");
        System.out.println(obj.get(40));
        obj.delete(400);
        obj.delete(40);
        obj.delete(1);
        System.out.println(obj.get(40));
        System.out.println(obj.size());
    }
}
