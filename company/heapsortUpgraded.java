package comDSA.company;

class hpsortUpgraded{

    public static void swap(int[] a,int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static boolean less(int[] a,int x , int y){
        return a[x]<a[y];
    }
    private static void sink(int[] a, int k, int N){
        while(2*k+1<N){
            int j = 2*k+1;
            if(j<N-1 && less(a, j,j+1)){
                j++;
            }
            if(!less(a,k,j)){
                break;
            }
            swap(a,k,j);
            k = j;
        }
    }

//    TIME COMPLEXITY OF THIS HEAPSORT IS O(nlogn).
    public static void sort(int[] a){

//        BELOW COMMENT CODE WILL NOT WORK HERE BECAUSE IT IS MADE ON THE CONDITION THAT THE ARRAY INDEX IS STARTING WTTH 1.
//        int N= a.length;
//        for (int k = N/2; k >= 1; k--)
//            sink(a, k, N);
//        while (N > 1)
//        {
//            swap(a, 1, N--);
//            sink(a, 1, N);
//        }

//        BELOW CODE IS MADE ON THE CONDITION THAT THE ARRAY INDEX IS STARTING WTTH 0.
        int N= a.length;
        for (int k = N/2-1; k >= 0; k--)
            sink(a, k, N);     //This heapify method has time complexity of O(N).
        for(int i=N-1;i>0;i--){
            swap(a, i, 0);      //THIS LOOP HAS O(nlogn) TIME COMPLEXITY.
            sink(a, 0, i);
        }
    }
}
public class heapsortUpgraded {
    public static void main(String[] args) {
        int[] a = {70,60,50,40,30,20,80};
        hpsortUpgraded.sort(a);
        for(int el:a){
            System.out.print(el+" ");
        }
    }
}

//ANOTHER WAY OF UPGRADED HEAPSORT.
//    static void swap(int[] arr , int x, int y){
//        int temp = arr[x];
//        arr[x] = arr[y];
//        arr[y] = temp;
//    }
//    static void sink(int[] arr, int k, int i){
//        while(2*k+1<=i){
//            int j=2*k+1;
//            if(j<i){
//                if(arr[2*k+1]<arr[2*k+2]) {
//                    j = 2 * k + 2;
//                }
//            }
//            if(arr[j]>arr[k]){
//                swap(arr,j,k);
//            }
//            else{
//                break;
//            }
//            k=j;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {20,40,30,10,80,70,90,50,60};
//        int n = arr.length;
//        for(int i=n/2-1;i>=0;i--){
//            sink(arr, i, n-1);     //This heapify method has time complexity of O(N).
//        }
//        for(int i=n-1;i>0;i--){    //THIS LOOP HAS O(nlogn) TIME COMPLEXITY.
//            swap(arr,0,i);
//            sink(arr,0,i-1);
//        }
//        for(int i=0;i<n;i++){
//            System.out.print(arr[i]+" ");
//        }