package comDSA.company;

import java.util.Scanner;

class LazyPrimMST{
    private boolean[] marked;
    private queue<Edge> mst;
    private MinPQ<Edge> pq;
    private double weight;
    LazyPrimMST(EdgeWeightedGraph G){
        marked = new boolean[G.V()];
        mst = new queue<>();
        pq = new MinPQ<>(10);
        visit(G,0);
        while(!pq.isEmpty()){
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]){
                continue;
            }
            mst.enqueue(e);
            weight = weight+e.weight();
            if(!marked[v]){
                visit(G,v);
            }
            if(!marked[w]){
                visit(G,w);
            }
        }

    }
    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e:G.adj(v)){
            if(!marked[e.other(v)]){
                pq.insert(e);
            }
        }
    }
    public Iterable<Edge> edges(){
        return mst;
    }
    public double weight(){
        return weight;
    }
}
public class PrimsAlgorithm {
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
        System.out.println();
        LazyPrimMST lp = new LazyPrimMST(ewg);
        for(Edge el:lp.edges()){
            System.out.println(el);
        }
        System.out.println(lp.weight());
    }
}
