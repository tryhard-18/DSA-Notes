package comDSA.company;

//class MaxPQ1<Key extends Comparable<Key>>{
//    private Key[] pq;
//    private int N;
//    MaxPQ1(int size){
//        pq = (Key[])new Comparable[size+1];
//    }
//    public void swap(int x, int y){
//        Key temp = pq[x];
//        pq[x] = pq[y];
//        pq[y] = temp;
//
//    }
//    public boolean less(int x , int y){
//        return pq[x].compareTo(pq[y])<0;
//    }
//    public boolean isEmpty(){
//        return N==0;
//    }
//    public int size(){
//        return N;
//    }
//    private void sink(int k){
//        while(2*k<=N){
//            int j = 2*k;
//            if(j<N && less(j,j+1)){
//                j++;
//            }
//            if(!less(k,j)){
//                break;
//            }
//            swap(k,j);
//            k = j;
//        }
//    }
//    private void swim(int k){
//        while(k>1 && less(k/2,k)){
//            swap(k/2,k);
//            k= k /2;
//        }
//    }
//    public void insert(Key v){
//        pq[++N] = v;
//        swim(N);
//    }
//    public Key delMax(){
//        Key max = pq[1];
//        swap(1,N--);
//        pq[N+1] = null;
//        sink(1);
//        return max;
//    }
//
//    public void display(){
//        for(int i=1;i<=N;i++){
//            System.out.print(pq[i]+" ");
//        }
//    }
//}
//
////THIS HEAPSORT IS USING PRIORITY QUEUE AS SPACE. TIME COMPLEXITY OF THIS HEAPSORT IS O(nlogn). BELOW HEAPSORT IS MADE ON THE CONDITION THAT THE ARRAY INDEX IS STARTING WTTH 1.
//class sorthp{
//    public static void sort(int[] a){
//        int N = a.length;
//        MaxPQ1<Integer> pq = new MaxPQ1<>(a.length);
//        for(int i=0;i<a.length;i++){
//            pq.insert(a[i]);
//        }
//        while(!pq.isEmpty()){
//            a[--N]=pq.delMax();
//        }
//    }
//}

//THIS HEAPSORT IS NOT USING ANY SPACE. TIME COMPLEXITY OF THIS HEAPSORT IS O(nlogn). BELOW HEAPSORT IS MADE ON THE CONDITION THAT THE ARRAY INDEX IS STARTING WTTH 0.
class hsort {
    public static void swap(int[] a, int i, int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            swim(arr,i);    //THIS HEAPIFY METHOD HAS O(nlogn) TIME COMPLEXITY. THIS LOOP IS HEAPIFY BECAUSE IT IS USED TO HEAPIFYING.
        }
        for(int i=arr.length-1;i>0;i--){
            swap(arr,i,0);     //THIS LOOP ALSO HAS O(nlogn) TIME COMPLEXITY.
            sink(arr,0,i);
        }
    }
    private static void swim(int[] arr,int k) {
        while (arr[(k-1) / 2] < arr[k] && k > 0) {
            swap(arr, k, (k-1) / 2);
            k = (k-1) / 2;
        }
    }
    private static void sink(int[] arr,int k, int i){
        while(2*k+2<i) {
            if (arr[k] > arr[2 * k+1] && arr[k] > arr[2 * k + 2])
                break;
            if(arr[2*k+1]<arr[2*k+2]){
                swap(arr, 2*k+2, k);
                k = 2*k+2;
            }
            else{
                swap(arr, 2*k+1, k);
                k = 2*k+1;
            }
        }
        if(2*k+1==i-1){
            if(arr[2*k+1]>arr[k]){
                swap(arr,2*k+1, k);
            }
        }
    }

//    ANOTHER WAY OF WRITING SINK METHOD.
//    private static void sink(int[] arr, int k, int i){
//        while((2*k+1)<=i-1){
//            int j=(2*k+1);
//            if(j<i-1 && arr[j]<arr[j+1]){
//                j++;
//            }
//            if(arr[j]<arr[k]){
//                break;
//            }
//            swap(arr,j,k);
//            k=j;
//        }
//    }
}

public class sortHeap {
    public static void main(String[] args) {
        int[] a = {30,50,40,10,20,70,80,60};
        hsort.sort(a);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
