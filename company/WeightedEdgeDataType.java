package comDSA.company;

class Edge implements Comparable<Edge>{
    private int v;
    private int w;
    private double weight;
    Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return weight;
    }
    public int either(){
        return v;
    }
    public int other(int vertex){
        if(this.v == vertex){
            return w;
        }
        return v;
    }
    @Override
    public int compareTo(Edge e){
        if(this.weight>e.weight){
            return 1;
        }
        else if(this.weight<e.weight){
            return -1;
        }
        return 0;
    }
    @Override
    public String toString(){
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
public class WeightedEdgeDataType {
    public static void main(String[] args) {

    }
}
