package comDSA.company;

import java.util.Queue;
import java.util.Stack;

class BreathFirstPaths{
    boolean[] marked;
    int[] edgeTo;
    int s;
    BreathFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }
    private void bfs(Graph G, int s){
        queue<Integer> que = new queue<>();
        marked[s] = true;
        que.enqueue(s);
        while(!que.isEmpty()){
            int v = que.dequeue();
            for(int w:G.adj(v)){
                if(!marked[w]){
                    marked[w]=true;
                    edgeTo[w]=v;
                    que.enqueue(w);
                }
            }
        }
    }
    public boolean hasPathTo(int v){
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v){
        if(!marked[v]){
            return null;
        }
        stack<Integer> stk = new stack<>();
        for(int i=v; i!=s; i=edgeTo[i]){
            stk.push(i);
        }
        stk.push(s);
        return stk;
    }
}


public class BreathFirstSearchPaths {
    public static void main(String[] args) {
        Graph gph = new Graph(6);
        gph.addEdge(0,5);
        gph.addEdge(2,4);
        gph.addEdge(2,3);
        gph.addEdge(1,2);
        gph.addEdge(0,1);
        gph.addEdge(3,4);
        gph.addEdge(3,5);
        gph.addEdge(0,2);
        BreathFirstPaths bfp = new BreathFirstPaths(gph,0);
        for(int el:bfp.pathTo(4)){
            System.out.print(el+" ");
        }
    }
}
