package comDSA.company;

import javax.swing.*;
import java.util.Scanner;

class LSD{
    public void sort(String[] a){
        int R=256;
        int N = a.length;
        int W = a[0].length();
        String[] aux = new String[N];
        for(int d = W-1;d>=0;d--){
            int[] count = new int[R+1];
            for(int i=0;i<N;i++){
                count[a[i].charAt(d)+1]++;
            }
            for(int r=0;r<R;r++){
                count[r+1] += count[r];
            }
            for(int i=0;i<N;i++){
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for(int i=0;i<N;i++){
                a[i] = aux[i];
            }
        }
    }
}

public class LSDStringSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = new String[3];
        for(int i=0;i<3;i++){
            a[i] = sc.nextLine();
        }
        LSD obj = new LSD();
        obj.sort(a);
        for(String s:a){
            System.out.println(s);
        }
    }
}
