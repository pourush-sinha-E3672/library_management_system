package datastructutre.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pourush.sinha on 27/12/19.
 */
public class DetectCycle {

    public static Boolean detectCycle(Graph g){
        int vertices = g.vertices;
        boolean[] visited = new boolean[vertices];

        boolean[] cycleStack = new boolean[vertices];

        for(int i =0 ;i<vertices ;i++){
            if(cycle(g,i,visited,cycleStack)){
                return true;
            }
        }
        return false;
    }

    private static boolean cycle(Graph g, int i, boolean[] visited, boolean[] cycleStack) {
        if(cycleStack[i]==true){
            return true;
        }
        if(visited[i]==true){
            return false;
        }
        visited[i] =true;
        cycleStack[i] =true;

        List<Integer> temp = g.adjacencyList[i];

        for(int j=0;j<temp.size() ;j++){
            if(cycle(g,temp.get(j),visited,cycleStack)){
                return true;
            }
        }
        cycleStack[i] =false;




        return false;


    }

    public static void main(String args[]) {
       /* Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));*/

        List<Integer> arr  = new ArrayList<Integer>();

        arr.add(1);
        arr.add(5);
        arr.add(7);
       // arr.add(10);
        System.out.println(findMinumunDivisor(arr,8));
    }


    static int findMinumunDivisor(List<Integer> arr,int threshold){
        int i =1;
        int j =threshold;
        int mid =0;
        while(i<j) {
              mid = (i + j) / 2;
            int val = getVal(arr,mid);
            if (val ==threshold){
                return mid;
            }else if( val >threshold){
                i = mid +1;
            }else {
                j = mid-1;
            }


        }


        return mid;
    }

    static int getVal(List<Integer> arr,int val){
        int sum =0;
        for (int  a :arr) {
            double val1 = (double) a / val;
            sum = (int) (sum +Math.ceil(val1));

        }
        return sum;
    }


}
