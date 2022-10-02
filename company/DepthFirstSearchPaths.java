package comDSA.company;

//IN THIS CODE WE HAVE USED 'stack' CLASS OF ALGORITHM 4TH EDITION NOT OF THIS JAVA LIBRARY i.e 'Stack' class.

class DepthFirstPaths{
    private boolean[] marked;
    int[] edgeTo;
    int s;
    DepthFirstPaths(Graph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }
    private void dfs(Graph G, int V){
        marked[V] = true;
        for(int w : G.adj(V)){
            if(!marked[w]){
                edgeTo[w] = V;
                dfs(G,w);
            }
        }
    }
    public boolean hasPathTo(int V){
        return marked[V];
    }
    public Iterable<Integer> pathTo(int V){
        if(!marked[V]){
            return null;
        }
        stack<Integer> stk = new stack<>();
        for(int i = V; i!=s; i=edgeTo[i]){
            stk.push(i);
        }
        stk.push(s);
        return stk;
    }

}
public class DepthFirstSearchPaths {
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
        DepthFirstPaths dfp = new DepthFirstPaths(gph,0);
        for(int el:dfp.pathTo(4)){
            System.out.print(el+" ");
        }
    }
}
