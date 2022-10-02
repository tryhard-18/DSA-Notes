package comDSA.company;

import java.util.Scanner;

class DirectedDFS{
    private boolean[] marked;
    DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (Integer el:sources){
            if(!marked[el]){
                dfs(G,el);
            }
        }
    }
    private void dfs(Digraph G,int v){
        marked[v] = true;
        for(int w: G.adj(v))
        if(!marked[w]){
            dfs(G,w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }
    public boolean[] marked(){
        return marked;
    }
}
public class ReachabilityInDigraphs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Digraph dg = new Digraph(13);
        int E=22;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dg.addEdge(a,b);
            E--;
        }
//        DirectedDFS dfs = new DirectedDFS(dg, 2);
//        for(int v=0;v<dg.V();v++){
//            if(dfs.marked(v)){
//                System.out.print(v+" ");
//            }
//        }
        stack<Integer> stk = new stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(6);
        DirectedDFS dfs1 = new DirectedDFS(dg, stk);
        for(int v=0;v<dg.V();v++){
            if(dfs1.marked(v)){
                System.out.print(v+" ");
            }
        }
    }
}
