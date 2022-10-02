package comDSA.company;

import java.util.Scanner;

class Digraph{
    int V;
    int E;
    stack<Integer>[] adj;
    Digraph(int V){
        this.V = V;
        adj = (stack<Integer>[]) new stack[V];
        for(int i=0;i<V;i++){
            adj[i] = new stack<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    void addEdge(int v, int w){
        adj[v].push(w);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public Digraph reverse(){
        Digraph dg = new Digraph(V);
        for(int v=0;v<V;v++){
            for(int w: adj(v)){
                dg.addEdge(w,v);
            }
        }
        return dg;
    }
}

public class DigraphDataType {
    public static void main(String[] args) {
        Digraph dg = new Digraph(13);
        Scanner sc = new Scanner(System.in);
        int E=22;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dg.addEdge(a,b);
            E--;
        }
        Digraph dg1 = dg.reverse();
        for(int w: dg.adj(6)){
            System.out.print(w+" ");
        }
    }
}
