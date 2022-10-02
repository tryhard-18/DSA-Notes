package comDSA.company;

import java.util.Scanner;

class KosarajuSCC
{
    private boolean[] marked; // reached vertices
    private int[] id; // component identifiers
    private int count; // number of strong components
    public KosarajuSCC(Digraph G)
    {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for (int s: order.reversepost())
            if (!marked[s])
            { dfs(G, s); count++; }
    }
    private void dfs(Digraph G, int v)
    {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }
    public boolean stronglyConnected(int v, int w)
    { return id[v] == id[w]; }
    public int id(int v)
    { return id[v]; }
    public int count()
    { return count; }
}
public class KosarajuAlgorithm {
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
        KosarajuSCC kj = new KosarajuSCC(dg);
        System.out.println(kj.count());
    }
}
