package comDSA.company;

import java.util.Scanner;

class TC{
    private DirectedDFS[] all;
    TC(Digraph G){
        all = new DirectedDFS[G.V()];
        for(int s=0;s<G.V();s++){
            all[s] = new DirectedDFS(G,s);
        }
    }
    public void display(){
        for(DirectedDFS i:all){
            for (boolean j:i.marked()){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    boolean reachable(int v, int w){
        return all[v].marked(w);
    }
}
public class TransitiveClosure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Digraph dg = new Digraph(13);
        int E=22;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dg.addEdge(a,b);
            E--;
        }
        TC obj = new TC(dg);
        obj.display();
        System.out.println(obj.reachable(0,1));
        System.out.println(obj.reachable(1,0));
    }
}
