package comDSA.company;

//BELOW CODE IS MADE ON THE CONDITION THAT THE ARRAY INDEX IS STARTING WTTH 1.
class MaxPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;
    MaxPQ(int size){
        pq = (Key[])new Comparable[size+1];
    }
    public void swap(int x, int y){
        Key temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;

    }
    public boolean less(int x , int y){
        return pq[x].compareTo(pq[y])<0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    private void sink(int k){
        while(2*k<=N){
            int j = 2*k;
            if(j<N && less(j,j+1)){
                j++;
            }
            if(!less(k,j)){
                break;
            }
            swap(k,j);
            k = j;
        }
    }
    private void swim(int k){
        while(k>1 && less(k/2,k)){
            swap(k/2,k);
            k= k /2;
        }
    }
    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        swap(1,N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    public void display(){
        for(int i=1;i<=N;i++){
            System.out.print(pq[i]+" ");
        }
        System.out.println();
    }
}

//MY CODE WITH NO ERROR. BASICALLY THIS CODE HAS A DIFFERENT CODE FOR SINK METHOD BUT WORKS LIKE SAME AS ABOVE ONE. BELOW CODE IS ALSO MADE ON THE CONDITION THAT THE ARRAY INDEX IS STARTING WITH 1.
//class PRQ{
//    int[] arr;
//    int N=1;
//    PRQ(int size){
//        arr = new int[size+1];
//    }
//    public static void swap(int[] a, int i, int min){
//        int temp = a[i];
//        a[i] = a[min];
//        a[min] = temp;
//    }
//    void swim(int k){
//        while(arr[k/2]<arr[k] && k>1){
//            swap(arr, k, k/2);
//            k=k/2;
//        }
//    }
//    void insert(int value){
//        arr[N] = value;
//        swim(N);
//        N++;
//    }
//    void sink(int k){
//        while(2*k+1<N) {
//            if (arr[k] > arr[2 * k] && arr[k] > arr[2 * k + 1])
//                break;
//            if(arr[2*k]<arr[2*k+1]){
//                swap(arr, 2*k+1, k);
//                k = 2*k+1;
//            }
//            else{
//                swap(arr, 2*k, k);
//                k = 2*k;
//            }
//        }
//        if(2*k==N-1){
//            if(arr[2*k]>arr[k]){
//                swap(arr,2*k, k);
//            }
//        }
//    }
//    int delMax(){
//        int temp = arr[1];
//        arr[1] = arr[N-1];
//        N--;
//        sink(1);
//        return temp;
//    }
//    void show(){
//        for(int i=1;i<N;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//    }
//}

public class PriorityQueueUsingHeap {
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(40);
        pq.insert(70);
        pq.insert(60);
        pq.insert(10);
        pq.insert(20);
        pq.insert(50);
        pq.insert(30);
        pq.display();
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        pq.display();
        System.out.println(pq.isEmpty());

    }
}
