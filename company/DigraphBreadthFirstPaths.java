package comDSA.company;

import java.util.Scanner;

class DBFS{
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    DBFS(Digraph G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }
    private void bfs(Digraph G, int s){
        queue<Integer> que = new queue<>();
        marked[s] = true;
        que.enqueue(s);
        while(!que.isEmpty()){
            int v = que.dequeue();
            for(int w:G.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
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
        for(int i=v; i!=s; i = edgeTo[i]){
            stk.push(i);
        }
        stk.push(s);
        return stk;
    }
}
public class DigraphBreadthFirstPaths {
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
        DBFS obj = new DBFS(dg,7);
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
