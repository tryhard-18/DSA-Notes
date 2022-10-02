package comDSA.company;

import java.util.Scanner;

class MinPQ<Key extends Comparable<Key>>{
    private Key[] pq;
    private int N;
    MinPQ(int size){
        pq = (Key[])new Comparable[size+1];
    }
    public void swap(int x, int y){
        Key temp = pq[x];
        pq[x] = pq[y];
        pq[y] = temp;

    }
    public boolean less(int x , int y){
        return pq[x].compareTo(pq[y])>0;
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
    public Key delMin(){
        Key min = pq[1];
        swap(1,N--);
        pq[N+1] = null;
        sink(1);
        return min;
    }

    public void display(){
        for(int i=1;i<=N;i++){
            System.out.print(pq[i]+" ");
        }
        System.out.println();
    }
}

public class MinPriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinPQ<Integer> pq = new MinPQ<>(10);
        pq.insert(40);
        pq.insert(70);
        pq.insert(60);
        pq.insert(10);
        pq.insert(20);
        pq.insert(50);
        pq.insert(30);
        pq.display();
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        System.out.println(pq.delMin());
        pq.display();
        System.out.println(pq.isEmpty());
    }
}
