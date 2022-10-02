package comDSA.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


class Stopwatch{
    double start;
    double end;
    Stopwatch(){
        start = System.currentTimeMillis();
    }

    public double elaspedTimer(){
        end = System.currentTimeMillis();
        return ((end-start)/1000.0);
    }
}

class SelectionSort{
    public static void swap(int[] a, int i, int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
    public static void sort(int[] a){
        for(int i=0;i<a.length-1;i++){
            int min = i;
            for(int j=i+1;j<a.length;j++){
                if(a[min]>a[j]){
                    min = j;
                }
            }
            swap(a, i, min);
        }

//        Below code for selection sort is probably wrong. Don't know from where i got this.
//        for(int i=0;i<a.length-1;i++){
//            for(int j=i+1;j<a.length;j++){
//                int min = i;
//                if(a[min]>a[j]){
//                    min = j;
//                }
//                swap(a,i,min);
//            }
//        }
    }

//    GENERALISED CODE.
//    public static void swap(Comparable[] a, int i, int min){
//        Comparable temp = a[i];
//        a[i] = a[min];
//        a[min] = temp;
//    }
//    public static void sort(Comparable[] a){
//        for(int i=0;i<a.length-1;i++){
//            for(int j=i+1;j<a.length;j++){
//                int min = i;
//                if(a[min].compareTo(a[j])>0){
//                    min = j;
//                }
//                swap(a,i,min);
//            }
//        }
//    }
}

class InsertionSort{
    public static void swap(int[] a, int i, int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    public static void sort(int[] a){
        for(int i=1;i<a.length;i++){
            for(int j=i;j>0 && a[j-1]>a[j];j--){
                swap(a,j,j-1);
            }
        }
    }

//    BELOW INSERTION SORT CODE IS THE FASTER VERSION.
//    public static void sortWithoutExchanges(int[] a){
//        for(int i=1;i<a.length;i++){
//            int aux = a[i];
//            int j;
//            for(j=i; j>0 && aux<a[j-1]; j--){
//                a[j] = a[j-1];
//            }
//            a[j] = aux;
//        }
//    }
}

class ShellSort{
    public static void swap(int[] a, int i, int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
    //Worst Case Time Complexity with this increment gap sequence in N^2.
    public static void sort(int[] a){
        int N = a.length;
        for(int gap = N/2; gap>=1; gap = gap/2){
            for(int j=gap; j<N; j++){
                for(int i = j-gap; i>=0; i=i-gap){
                    if(a[i]>a[i+gap]){
                        swap(a,i,i+gap);
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }
}

//TOP-DOWN MERGESORT.
class MergeSort {
    public static void merge(int[] a, int lb, int mid, int ub) {
        int nl = mid-lb+1;
        int nr = ub - mid;
        int[] L = new int[nl];
        int[] R = new int[nr];
        for(int i=0;i<nl;i++){
            L[i] = a[lb+i];
        }
        for(int j=0;j<nr;j++){
            R[j] = a[mid+1+j];
        }
        int i=0,j=0,k=lb;
        while(i<nl && j<nr){
            if(L[i]<=R[j]){
                a[k] = L[i];
                i++;
                k++;
            }
            else{
                a[k] = R[j];
                j++;
                k++;
            }
        }
        if(i>=nl) {
            while (j < nr) {
                a[k] = R[j];
                j++;
                k++;
            }
        }
        else {
            while (i < nl) {
                a[k] = L[i];
                i++;
                k++;
            }
        }
    }

    public static void sort(int[] a, int lb, int ub){
        int mid=0;
        if(lb<ub) {
            mid = (lb + ub) / 2;
            sort(a, lb, mid);
            sort(a, mid + 1, ub);
            merge(a, lb, mid, ub);
        }
    }
}

//ANOTHER METHOD FOR TOP-DOWN MERGESORT. THIS METHOD IS FASTER THAN UPPER TOP-DOWN METHOD AND IN THIS COST OF CREATING A NEW ARRAY IS LESS AND THUS WE CAN SAVE SIGNIFICANT AMOUNT OF SPACE.
//class MergeSort {
//    private static int[] aux;
//
//    public static void sort(int[] arr) {
//        aux = new int[arr.length];
//        sort(arr, 0, arr.length - 1);
//    }
//
//    private static void sort(int[] arr, int lo, int hi) {
//        if (hi <= lo) {
//            return;
//        }
//        int mid = lo + (hi - lo) / 2;
//        sort(arr, lo, mid);
//        sort(arr, mid + 1, hi);
//        merge(arr, lo, mid, hi);
//    }
//
//    private static void merge(int[] arr, int lo, int mid, int hi) {
//        int i = lo;
//        int j = mid + 1;
//        for (int k = lo; k <= hi; k++) {
//            aux[k] = arr[k];
//        }
//        for (int k = lo; k <= hi; k++) {
//            if (i > mid) {
//                arr[k] = aux[j++];
//            } else if (j > hi) {
//                arr[k] = aux[i++];
//            }
//            else if (aux[i] > aux[j]) {
//                arr[k] = aux[j++];
//            } else {
//                arr[k] = aux[i++];
//            }
//        }
//    }
//}

//    BOTTOM-UP MERGESORT.
//    class msort{
//        static int[] aux ;
//        public static void sort(int[] arr){
//            aux = new int[arr.length];
//            for(int sz = 1; sz<arr.length; sz = sz+sz){
//                for(int i=0;i<arr.length-sz;i=i+sz+sz){
//                    merge(arr,i,i+sz-1,Math.min(i+sz+sz-1, arr.length-1));
//                }
//            }
//        }
//        public static void merge(int[] arr, int lo, int mid, int hi){
//            for(int i=lo;i<=hi;i++){
//                aux[i] = arr[i];
//            }
//            int i=lo;
//            int j=mid+1;
//            for(int k=lo;k<=hi;k++){
//                if(i>mid){
//                    arr[k]=aux[j];
//                    j++;
//                }
//                else if(j>hi){
//                    arr[k] = aux[i];
//                    i++;
//                }
//                else if(aux[i]>aux[j]){
//                    arr[k] = aux[j];
//                    j++;
//                }
//                else{
//                    arr[k] = aux[i];
//                    i++;
//                }
//            }
//        }
//    }


class QuickSort{
    public static void swap(int[] a, int i, int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
    public static int partition(int[] a, int lb, int ub){

//        This code for quickSort has high time complexity compare to below code becoz in quicksort the way the code is written matters a lot.
        int start = lb;
        int end= ub;
        int pivot = a[lb];
        while(start<end){
            while (a[start]<=pivot){
                start++;
                if(start == ub)
                    break;
            }
            while (a[end]>pivot){
                end--;
                if(end == lb)
                    break;
            }
            if(start<end){
                swap(a,start,end);
            }
        }
        swap(a,lb,end);
        return end;

//        int i = lb;
//        int j = ub+1;
//        int v = a[lb];
//        while(true){
//            while(a[++i]<v)
//                if(i==ub)
//                    break;
//            while(v<a[--j])
//                if(j==lb)
//                    break;
//            if(i>=j)
//                break;
//            swap(a,i,j);
//        }
//        swap(a,lb,j);
//        return j;

    }

    public static void sort(int[] a, int lb, int ub){
        if(lb<ub){
            int loc = partition(a,lb,ub);
            sort(a,lb,loc-1);
            sort(a, loc+1, ub);
        }
    }
}

//QUICKSORT WITH 3-WAY PARTITIONING.
//class qksort{
//    public static void swap(int[] a, int i, int min){
//        int temp = a[i];
//        a[i] = a[min];
//        a[min] = temp;
//    }
//    public static void sort(int[] arr){
//        sort(arr, 0, arr.length-1);
//    }
//    public static void sort(int[] a, int lb, int ub){
//        if(ub<=lb){
//            return;
//        }
//        int lt = lb;
//        int gt = ub;
//        int pivot = a[lb];
//        int i= lb+1;
//        while(i<=gt){
//            if(a[i]<pivot)
//                swap(a, lt++, i++);
//            else if (a[i]>pivot){
//                swap(a, gt--, i);
//            }
//            else
//                i++;
//        }
//        sort(a,lb,lt-1);
//        sort(a,gt+1, ub);
//    }
//}

public class TypesOfSorting {
    public static void main(String[] args) {
        Random rnd = ThreadLocalRandom.current();
        int N=10000000;
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i] = rnd.nextInt(2000);
        }


//        int[] b = Arrays.copyOf(a,N);
//        int[] c = Arrays.copyOf(a,N);
        int[] d = Arrays.copyOf(a,N);
        int[] e = Arrays.copyOf(a,N);


//        String[] b = {"Kushal","Flash","dominic", "Flask"};
//        SelectionSort.sort(b);
//        for(int i=0;i<b.length;i++){
//            System.out.print(b[i]+" ");
//        }

//        Stopwatch sstimer = new Stopwatch();
//        SelectionSort.sort(a);
//        double sstime = sstimer.elaspedTimer();
//        System.out.println(sstime);
//
//        Stopwatch istimer = new Stopwatch();
//        InsertionSort.sort(b);
//        double istime = istimer.elaspedTimer();
//        System.out.println(istime);
//
//        Stopwatch shellstimer = new Stopwatch();
//        ShellSort.sort(c);
//        double shellstime = shellstimer.elaspedTimer();
//        System.out.println(shellstime);
//
        Stopwatch mstimer = new Stopwatch();
//        MergeSort.sort(d);
        MergeSort.sort(d, 0, a.length-1);
        double mstime = mstimer.elaspedTimer();
        System.out.println(mstime);

        Stopwatch qstimer = new Stopwatch();
        QuickSort.sort(e,0,a.length-1);
        double qstime = qstimer.elaspedTimer();
        System.out.println(qstime);








    }
}
