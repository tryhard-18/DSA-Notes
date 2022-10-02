package comDSA.company;

import java.util.Scanner;

public class DegreesOfSeparation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SymbolGraph sg = new SymbolGraph(18);
        Graph gph = sg.G();
        String source = sc.nextLine();
        BreathFirstPaths bfp = new BreathFirstPaths(gph, sg.index(source));
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            String str = sc.nextLine();
            if(sg.contains(str)) {
                int k = sg.index(str);
                if (bfp.hasPathTo(k)) {
                    for (int el : bfp.pathTo(k)) {
                        System.out.println(" "+ sg.name(el));
                    }
                }
                else {
                    System.out.println("Key Not Connected");
                }
            }
            else{
                System.out.println("Key not in database");
            }
            t--;
        }
    }
}
