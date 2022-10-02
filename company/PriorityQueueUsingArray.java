package comDSA.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Mxpq{
    int N;
    int[] arr;
    Mxpq(){
        arr = new int[10];
    }

//    USING BELOW INSERT AND DELETE FUNCTION WE GET UNORDERED PRIORITY QUEUE.
//    void insert(int value){
//        arr[N] = value;
//        N++;
//    }
//    int DelMax(){
//        int max= arr[N-1];
//        int index=-1;
//        for(int i=N-2;i>=0;i--){
//            if(max<arr[i]){
//                max = arr[i];
//                index=i;
//            }
//        }
//        swap(arr, index, N-1);
//        N--;
//        return max;
//    }

//    USING BELOW INSERT AND DELETE FUNCTION WE GET ORDERED PRIORITY QUEUE.
    void insert(int value){
        int i;
        for(i=N;i>0;i--){
            if(value<arr[i-1]){
                arr[i] = arr[i-1];
            }
            else{
                break;
            }
        }
        arr[i] = value;
        N++;
    }
    int DelMax(){
        return arr[--N];
    }

    public static void swap(int[] a, int i, int min){
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }
    void show(){
        for(int i=0;i<N;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class PriorityQueueUsingArray {
    public static void main(String[] args) {
        int[] a = {40,50,60,10,20,70,30};
        Mxpq obj = new Mxpq();
        obj.insert(40);
        obj.insert(50);
        obj.insert(60);
        obj.insert(10);
        obj.insert(20);
        obj.insert(70);
        obj.insert(30);
        System.out.println(obj.DelMax());
        System.out.println(obj.DelMax());
        System.out.println(obj.DelMax());
        obj.show();










    }
}
