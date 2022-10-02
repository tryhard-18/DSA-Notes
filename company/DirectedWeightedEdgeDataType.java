package comDSA.company;

class DirectedEdge{
    private int v;
    private int w;
    private double weight;
    DirectedEdge(int v, int w, double weight){
        this.v=v;
        this.w=w;
        this.weight=weight;
    }
    public double weight(){
        return weight;
    }
    public int from(){
        return v;
    }
    public int to(){
        return w;
    }
    public String toString(){
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
public class DirectedWeightedEdgeDataType {
    public static void main(String[] args) {

    }
}
