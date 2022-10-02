package comDSA.company;

import java.util.Scanner;

class EdgeWeightedDigraph{
    private int V;
    private int E;
    private stack<DirectedEdge>[] adj;
    EdgeWeightedDigraph(int V){
        this.V= V;
        adj = (stack<DirectedEdge>[]) new stack[V];
        for(int i=0;i<V;i++){
            adj[i] = new stack<>();
        }
    }
    public void addEdge(DirectedEdge e){
        adj[e.from()].push(e);
        E++;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }
    public Iterable<DirectedEdge> edges(){
        stack<DirectedEdge> stk = new stack<>();
        for(int i=0;i<V;i++){
            for(DirectedEdge el:adj[i]){
                stk.push(el);
            }
        }
        return stk;
    }

}
public class EdgeWeightedDigraphDataType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EdgeWeightedDigraph ewdg = new EdgeWeightedDigraph(8);
        int E=15;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            double weight = sc.nextDouble();
            DirectedEdge e = new DirectedEdge(a,b,weight);
            ewdg.addEdge(e);
            E--;
        }
        System.out.println();
        for(int i=0;i<ewdg.V();i++) {
            for (DirectedEdge el : ewdg.adj(i)) {
                System.out.println(el);
            }
            System.out.println();
        }
    }
}
