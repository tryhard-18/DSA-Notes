package comDSA.company;

import java.util.Scanner;

class DirectedCycle{
    boolean[] marked;
    boolean[] onStack;
    int[] edgeTo;
    private stack<Integer> cycle;
    DirectedCycle(Digraph G){
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
//        cycle = new stack<>();
        for(int s=0;s<G.V();s++){
            if(!marked[s]){
                dfs(G,s);
            }
//            for(boolean el:marked){
//                System.out.print(el+" ");
//            }
//            System.out.println();
//            for(boolean el:onStack){
//                System.out.print(el+" ");
//            }
//            System.out.println();
        }
    }
    private void dfs(Digraph G, int v){
        onStack[v]=true;
        marked[v]=true;
        for(int w:G.adj(v)) {
            if (hasCycle()) {
                return;
            }
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G,w);
            }
            else if(onStack[w]){
                cycle = new stack<>();
                for(int i=v;i!=w;i=edgeTo[i]){
                    cycle.push(i);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }
    public boolean hasCycle(){
        return cycle!=null;
    }
    public Iterable<Integer> cycle(){
        return cycle;
    }
}

public class FindingADirectedCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Digraph dg = new Digraph(13);
        int E=15;
        while(E!=0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dg.addEdge(a,b);
            E--;
        }
        DirectedCycle dc = new DirectedCycle(dg);
        for(boolean el:dc.marked){
            System.out.print(el+" ");
        }
        System.out.println();
        for(boolean el:dc.onStack){
            System.out.print(el+" ");
        }
        System.out.println();
        for(int el:dc.edgeTo){
            System.out.print(el+" ");
        }
        System.out.println();
//        for (int el:dc.cycle()){
//            System.out.print(el+" ");
//        }
    }
}

//Edges of Graph with no cycle
//0 5
//0 1
//0 6
//2 0
//2 3
//3 5
//5 4
//6 4
//6 9
//7 6
//8 7
//9 10
//9 11
//9 12
//11 12