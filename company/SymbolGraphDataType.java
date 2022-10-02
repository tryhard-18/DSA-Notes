package comDSA.company;

import java.util.Scanner;

class SymbolGraph{
    Scanner sc = new Scanner(System.in);
    BinarySearchST<String, Integer> st;
    String[] keys;
    Graph gph;
    SymbolGraph(int t){
        st = new BinarySearchST<>(10);
        gph = new Graph(10);
        while(t>0){
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for(int i=0;i<arr.length;i++) {
                if (!st.contains(arr[i])) {
                    st.put(arr[i], st.size());
                }
            }
            int v = st.get(arr[0]);
            for(int i=1;i<arr.length;i++){
                gph.addEdge(v,st.get(arr[i]));
            }
            t--;
        }
        keys = new String[st.size()];
        for(String el:st.keys()){
            keys[st.get(el)] = el;
        }
    }
    public boolean contains(String s){
        return st.contains(s);
    }
    public int index(String s){
        return st.get(s);
    }
    public String name(int v){
        return keys[v];
    }
    public Graph G(){
        return gph;
    }
}

public class SymbolGraphDataType {
    public static void main(String[] args) {
        SymbolGraph sg = new SymbolGraph(18);
        Graph gph = sg.G();
        for(int w:gph.adj(2)){
            System.out.println(w+" "+sg.name(w)+" ");
        }
    }
}
