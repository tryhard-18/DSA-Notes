package comDSA.company;

class CC{
    private boolean[] marked;
    private int[] id;
    private int count;
    CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }
    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v] = count;
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }
    public boolean connected(int v, int w){
        return id[v]==id[w];
    }
    public int id(int v){
        return id[v];
    }
    public int count(){
        return count;
    }
    public class isCycle{
        private boolean[] arr;
        private boolean hascycle;
        isCycle(Graph G){
            arr = new boolean[G.V()];
            for(int s=0;s<G.V();s++){
                if(!arr[s]) {
                    dfs(G, s, s);
                }
            }
        }
        private void dfs(Graph G, int v, int u){
            arr[v] = true;
            for(int w:G.adj(v)){
                if(!arr[w]){
                    dfs(G,w,v);
                }
                else if(w!=u){
                    hascycle=true;
                }
            }
        }
        public boolean hasCycle(){
            return hascycle;
        }
    }


}

public class DepthFirstSearchToFindConnectedComponents {
    public static void main(String[] args) {
        Graph gph = new Graph(6);
//        gph.addEdge(0,5);
//        gph.addEdge(0,1);
//        gph.addEdge(0,2);
//        gph.addEdge(6,4);
//        gph.addEdge(0,6);
//        gph.addEdge(3,4);
//        gph.addEdge(5,4);
//        gph.addEdge(3,5);
//        gph.addEdge(7,8);
//        gph.addEdge(9,12);
//        gph.addEdge(12,11);
//        gph.addEdge(9,10);
//        gph.addEdge(9,11);


        gph.addEdge(1,2);
        gph.addEdge(1,5);
        gph.addEdge(3,4);
        gph.addEdge(3,5);
        gph.addEdge(0,2);
//        gph.addEdge(0,1);
        
        CC cc = new CC(gph);
        int M = cc.count();
        stack<Integer>[] components = (stack<Integer>[]) new stack[M];
        for(int i=0;i<M;i++){
            components[i] = new stack<>();
        }
        for(int v=0;v<gph.V();v++){
            components[cc.id(v)].push(v);
        }
        System.out.println(cc.count()+" components");
        for(int i=0;i<M;i++){
            for (int el:components[i]){
                System.out.print(el+" ");
            }
            System.out.println();
        }
        CC.isCycle obj = cc.new isCycle(gph);
        System.out.println(obj.hasCycle());
    }
}
