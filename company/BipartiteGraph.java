package comDSA.company;

class TwoColor{
    private boolean[] marked;
    private boolean[] color;
    private boolean isbipartite = true;
    TwoColor(Graph G){
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for(int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G, s);
            }
        }
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w]){
                color[w] = !color[v];
                dfs(G,w);
            }
            else if (color[w]==color[v]){
                isbipartite = false;
            }
        }
    }
    public boolean isBipartite(){
        return isbipartite;
    }
}
public class BipartiteGraph {
    public static void main(String[] args) {
        Graph gph = new Graph(5);
        gph.addEdge(0,1);
        gph.addEdge(0,2);
        gph.addEdge(2,3);
        gph.addEdge(1,3);
//        gph.addEdge(0,3);
        TwoColor obj = new TwoColor(gph);
        System.out.println(obj.isBipartite());
    }
}
