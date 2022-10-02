package comDSA.company;

import java.util.Scanner;

class AscyclicSP{
    DirectedEdge[] edgeTo;
    double[] distTo;
    AscyclicSP(Digraph g,EdgeWeightedDigraph G, int s){
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for(int v=0;v<G.V();v++){
            distTo[v]=Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
        TopologicalSort top = new TopologicalSort(g);
        for(int v: top.order()){
            relax(G,v);
        }
    }
    private void relax(EdgeWeightedDigraph G, int v){
        for(DirectedEdge e:G.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w] = distTo[v]+e.weight();
                edgeTo[w]=e;
            }
        }
    }
    public double distTo(int v){
        return distTo[v];
    }
    public boolean hasPathTo(int v){
        return distTo[v]!=Double.POSITIVE_INFINITY;
    }
    public Iterable<DirectedEdge> pathTo(int v){
        stack<DirectedEdge> path = new stack<>();
        if(!hasPathTo(v)){
            return null;
        }
        for(DirectedEdge e= edgeTo[v]; e!=null; e = edgeTo[e.from()]){
            path.push(e);
        }
        return path;
    }
}
public class ShortestPathsInEdgeWeightedDAG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EdgeWeightedDigraph ewdg = new EdgeWeightedDigraph(8);
        Digraph dg = new Digraph(8);
        int E=13;
        int K=13;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            double weight = sc.nextDouble();
            DirectedEdge e = new DirectedEdge(a,b,weight);
            ewdg.addEdge(e);
            E--;
        }
        while(K!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dg.addEdge(a,b);
            K--;
        }
        AscyclicSP obj = new AscyclicSP(dg,ewdg,0);
        for(int v=0;v<ewdg.V();v++){
            if(obj.pathTo(v)!=null) {
                for (DirectedEdge e : obj.pathTo(v)) {
                    System.out.println(e);
                }
            }
            System.out.println();
        }
    }
}

//Digraph vertices
//5 4
//4 7
//5 7
//5 1
//4 0
//0 2
//3 7
//1 3
//7 2
//6 2
//3 6
//6 0
//6 4