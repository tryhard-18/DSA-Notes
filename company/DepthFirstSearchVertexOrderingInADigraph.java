package comDSA.company;

import java.util.Scanner;

class DepthFirstOrder{
    boolean[] marked;
    queue<Integer> pre;
    queue<Integer> post;
    stack<Integer> reversepost;
    DepthFirstOrder(Digraph G){
        marked =new boolean[G.V()];
        pre = new queue<>();
        post = new queue<>();
        reversepost = new stack<>();
        for(int s=0; s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
            }
        }
    }
    private void dfs(Digraph G, int v){
        marked[v]=true;
        pre.enqueue(v);
        for(int w:G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
        post.enqueue(v);
        reversepost.push(v);
    }
    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public Iterable<Integer> reversepost(){
        return reversepost;
    }
}
public class DepthFirstSearchVertexOrderingInADigraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Digraph dg = new Digraph(8);
        int E=13;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dg.addEdge(a,b);
            E--;
        }
        DepthFirstOrder dfo = new DepthFirstOrder(dg);
        for(int el:dfo.pre()){
            System.out.print(el+" ");
        }
        System.out.println();
        for(int el:dfo.post()){
            System.out.print(el+" ");
        }
        System.out.println();
        for(int el:dfo.reversepost()){
            System.out.print(el+" ");
        }
    }
}
