package comDSA.company;

import java.util.Scanner;

public class TopologicalSort {
    private Iterable<Integer> order;
    TopologicalSort(Digraph G){
        DirectedCycle dc = new DirectedCycle(G);
        if(!dc.hasCycle()){
            DepthFirstOrder dfo = new DepthFirstOrder(G);
            order = dfo.reversepost();
        }
    }
    public Iterable<Integer> order(){
        return order;
    }
    public boolean isDAG(){
        return order==null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Digraph dg = new Digraph(8);
        int E=13;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dg.addEdge(a,b);
            E--;
        }
        TopologicalSort ts = new TopologicalSort(dg);
        if(!ts.isDAG()){
            for(int el:ts.order()){
                System.out.print(el+" ");
            }
        }
    }
}
