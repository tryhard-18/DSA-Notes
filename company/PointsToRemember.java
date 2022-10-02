package comDSA.company;

import java.util.*;

public class PointsToRemember {
    public static void main(String[] args) {


//        ArrayList<Integer>[] arr = new ArrayList[5];
//        for(int i=0;i<5;i++){
//            arr[i] = new ArrayList<>();
//        }   //Without for loop below lines will give null pointer exception.
//        arr[0].add(1);
//        arr[0].add(2);
//        arr[0].add(3);
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        String[] str = new String[5];
//        str[1] = "Kushal Khattar";
//        System.out.println(str[0]);



//        int t = sc.nextInt();
//        sc.nextLine();    //You have to use this so that below sc.nextLine() doesn't take enter as input.
//        String s = sc.nextLine();
//        System.out.println(s);


//        Eager version of Prim algorithm and Dijkstra algorithm are the applications of IndexPriorityQueue.

//        TreeMap<Integer, String> map = new TreeMap<>();
//        map.put(2,"Kushal");
//        map.put(1,"Flash");
//        map.put(400,"Maverick");
//        map.put(4,"Fanatic");
//        map.put(3,"Dominic");
//        System.out.println(map);
//        HashMap<Integer, String> map1 = new HashMap<>();      //TreeMap prints the keys in sorted order while HashMap in random order. TreeMap uses RedBlackBST while HashMap uses Hashing.
//        map1.put(2,"Kushal");
//        map1.put(1,"Flash");
//        map1.put(400,"Maverick");
//        map1.put(4,"Fanatic");
//        map1.put(3,"Dominic");
//        System.out.println(map1);


//        BFS will not work on weighted graph(both directed and undirected).


//        PriorityQueue of system java is by default Minimum priority queue and it is implemented using heap.
//        Example:
//        int[] arr = {6,5,3,2,8,10,9};
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i=0;i<arr.length;i++){
//            pq.add(arr[i]);
//        }
//        System.out.println(pq);

//        If we have to convert priorityQueue of system java to maximum priority queue then we can use any of the 3 methods.
//        Example:
//    1)    USING COMPARATOR
//        int[] arr = {6,5,3,2,8,10,9};
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        for(int i=0;i<arr.length;i++){
//            pq.add(arr[i]);
//        }
//        System.out.println(pq);
//     2)   USING LAMBDA
//        int[] arr = {6,5,3,2,8,10,9};
//        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
//        for(int i=0;i<arr.length;i++){
//            pq.add(arr[i]);
//        }
//        System.out.println(pq);
//      3)  USING Comparator.reverseOrder() which returns a Comparator that imposes the reverse of the natural ordering.
//        int[] arr = {6,5,3,2,8,10,9};
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for(int i=0;i<arr.length;i++){
//            pq.add(arr[i]);
//        }
//        System.out.println(pq);


//        int[] arr = {4,2,4,1,3,4,25};
//        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());  //By default the ordering of TreeSet is in increasing order. But using this way the ordering can be made to decreasing order.
//        for(int i=0;i< arr.length;i++){
//            set.add(arr[i]);
//        }
//        System.out.println(set);


//        In Level Order Traversal of tree queue is used. In this we use BFS technique.

//        In Pre In Post Order of tree stack is used. In this we use DFS technique.


//        In TreeMap the pairs are ordered according to key value in increasing order.
//        In HashMap the pairs are ordered in random order.
//        In LinkedHashMap the pairs are ordered in which they are inserted.
    }
}
