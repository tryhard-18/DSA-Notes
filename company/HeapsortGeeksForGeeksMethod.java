package comDSA.company;

class Hpsort{
    private static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    private static void heapify(int[] a, int n, int i){
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<n && a[l]>a[largest]){
            largest = l;
        }
        if(r<n && a[r]>a[largest]){
            largest = r;
        }
        if(i!=largest){
            swap(a,largest,i);
            heapify(a,n,largest);
        }
    }

    public static void sort(int[] a){
        int n = a.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(a,n,i);
        }
        for(int i=n-1;i>0;i--){
            swap(a,i,0);
            heapify(a,i,0);
        }
    }
}
public class HeapsortGeeksForGeeksMethod {
    public static void main(String[] args) {
        int[] a = {20,40,30,10,80,70,90,60,50};
        Hpsort.sort(a);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
