package comDSA.company;

//IN THIS CODE WE HAVE USED 'stack' CLASS OF ALGORITHM 4TH EDITION NOT OF THIS JAVA LIBRARY i.e 'Stack' class.

import java.util.Iterator;
import java.util.Scanner;

class Graph{
    private int V;
    private int E;
    private stack<Integer>[] stk;
    Graph(int V){
        this.V = V;
        stk = (stack<Integer>[]) new stack[V];
        for(int i=0;i<V;i++){
            stk[i] = new stack<Integer>();
        }
    }
    public void addEdge(int v, int w){
        stk[v].push(w);
        stk[w].push(v);
        E++;
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public Iterable<Integer> adj(int V){
        return stk[V];
    }
}

class DepthFirstSearch{
    private boolean[] marked;
    private int count;
    DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

//    dfs METHOD USING IMPLICIT stack. RECURSION USES stack ITSELF.
    private void dfs(Graph G, int V){
        marked[V] = true;
        count++;
        for(int w : G.adj(V)){
            if(!marked[w]){
                System.out.print(w+" ");
                dfs(G,w);
            }
        }
    }

//    dfs METHOD USING EXPLICIT stack.
//    private void dfs(Graph G, int s){
//        stack<Integer> stk = new stack<>();
//        marked[s]=true;
//        stk.push(s);
//        while(!stk.isEmpty()){
//            int v = stk.pop();
//            System.out.print(v+" ");
//            for(int w:G.adj(v)){
//                if(!marked[w]) {
//                    stk.push(w);
//                    marked[w] = true;
//                }
//            }
//        }
//    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
}
public class graphAndDepthFirstSearch {
    public static void main(String[] args) {
        Graph gph = new Graph(6);

//        gph.addEdge(0,1);
//        gph.addEdge(0,2);
//        gph.addEdge(1,3);
//        gph.addEdge(1,2);
//        gph.addEdge(2,3);
//        gph.addEdge(2,4);
//        gph.addEdge(4,5);
//        gph.addEdge(3,5);
        gph.addEdge(0,5);
        gph.addEdge(2,4);
        gph.addEdge(2,3);
        gph.addEdge(1,2);
        gph.addEdge(0,1);
        gph.addEdge(3,4);
        gph.addEdge(3,5);
        gph.addEdge(0,2);
        for(int w:gph.adj(0)){
            System.out.println(w+" ");
        }
        DepthFirstSearch srh = new DepthFirstSearch(gph,0);
        System.out.println();
        System.out.println(srh.marked(0));
        System.out.println(srh.marked(1));
        System.out.println(srh.marked(2));
        System.out.println(srh.marked(3));
        System.out.println(srh.marked(4));
        System.out.println(srh.marked(5));
        System.out.println(srh.count());
    }
}
