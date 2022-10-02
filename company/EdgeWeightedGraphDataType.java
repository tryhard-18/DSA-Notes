package comDSA.company;

import java.util.PriorityQueue;
import java.util.Scanner;

class EdgeWeightedGraph{
    private int V;
    private int E;
    private stack<Edge>[] adj;
    EdgeWeightedGraph(int V){
        this.V=V;
        adj = (stack<Edge>[]) new stack[V];
        for(int i=0;i<V;i++){
            adj[i] = new stack<Edge>();
        }
    }

    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].push(e);
        adj[w].push(e);
        E++;
    }
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
    public Iterable<Edge> edges(){
        stack<Edge> b = new stack<>();
        for(int v=0;v<V;v++){
            for(Edge e:adj[v]){
                if(e.other(v)>v){
                    b.push(e);
                }
            }
        }
        return b;
    }

//    IN THIS WAY ALSO 'Iterable<Edges> edges() i.e UPPER METHOD' CAN BE WRITTEN.
//    public Iterable<Edge> edges(){
//        stack<Edge> b = new stack<>();
//        for(int v=0;v<V;v++){
//            for(Edge e:adj[v]){
//                if(e.either()==v){
//                    b.push(e);
//                }
//            }
//        }
//        return b;
//    }
}
public class EdgeWeightedGraphDataType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(8);
        int E=16;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            double weight = sc.nextDouble();
            Edge e = new Edge(a,b,weight);
            ewg.addEdge(e);
            E--;
        }
        for(Edge el:ewg.edges()){
            System.out.println(el);
        }
//        System.out.println();
//        for(int i=0;i<ewg.V();i++) {
//            for (Edge el : ewg.adj(i)) {
//                System.out.println(el);
//            }
//            System.out.println();
//        }
    }
}
