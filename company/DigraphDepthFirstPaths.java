package comDSA.company;

import java.util.Scanner;

class DDFS{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    DDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }
    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w:G.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
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
        for(int i=v; i!=s; i = edgeTo[i]){
            stk.push(i);
        }
        stk.push(s);
        return stk;
    }
}
public class DigraphDepthFirstPaths {
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
        DDFS obj = new DDFS(dg,7);
        try {
            for (int el : obj.pathTo(1)) {
                System.out.print(el + " ");
            }
        }
        catch (Exception e){
            System.out.println("No Connection");
        }
    }
}
