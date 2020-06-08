package datastructutre.Graph;

import javafx.util.Pair;
import randomproblemsolving.medium.QueenAttackProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pourush.sinha on 23/12/19.
 */
public class BfsTraversal {


    public static String bfsTraversal(Graph g, int source){
        String str="";

        int vetices =g.vertices;
        Boolean[] visited = new Boolean[vetices];
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source]=true;

        while (!queue.isEmpty()){
          Integer i =  queue.remove();
          str= str+" "+i;
          List<Integer> list =g.adjacencyList[i];

            for(int j =0 ;j<list.size() ;j++){
                if (!visited[(list.get(j))]) {
                    queue.add(list.get(j));
                    visited[(list.get(j))]=true;
                }
            }

        }
        return str;
    }



    public static String bfsTraversalKNearest(Graph g, int source,Integer level){
        String str="";

        int vetices =g.vertices;
        Boolean[] visited = new Boolean[vetices];
        Arrays.fill(visited, false);
        Queue<Pair> queue = new LinkedList<>();
        Pair<Integer,Integer> pair = new Pair<Integer,Integer>(0,source);
        queue.add(pair);
        visited[source]=true;

        while (!queue.isEmpty()){
            Pair<Integer,Integer> pair1 =  queue.remove();
            Integer i =pair1.getValue();
            Integer height =pair1.getKey();
            if(level ==height ){
                System.out.println(i);
            }

            List<Integer> list =g.adjacencyList[i];

            for(int j =0 ;j<list.size() ;j++){
                if (!visited[(list.get(j))]) {
                    queue.add(new Pair<Integer,Integer>(height+1,list.get(j)));
                    visited[(list.get(j))]=true;
                }
            }

        }
        return str;
    }

    public static String dfsTraversal(Graph g, int source) {

        String result = "";
        int num_of_vertices = g.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you push it into stack
        boolean[] visited = new boolean[num_of_vertices];

        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(source);

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {

            //Pop a vertex/node from stack and add it to the result
            int current_node = stack.pop();
            result +=" "+ String.valueOf(current_node);

            //Visit the node
            visited[current_node] = true;

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            List<Integer> temp = null;
            if(g.adjacencyList[current_node] !=null)
                temp = g.adjacencyList[current_node];
            for(int i =0 ;i<temp.size(); i++){
                if (!visited[(temp.get(i))]) {
                    stack.push(temp.get(i));
                    visited[(temp.get(i))]=true;
                }
            }

        }//end of while
        return result;
    }

    public static void main( String args[] ) {
        Graph g= new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        g.printGraph();

        System.out.println("-------------BFS traversl---------------");
        System.out.println(bfsTraversal(g,0));
        System.out.println("----------------------------");
        System.out.println(dfsTraversal(g,0));
        System.out.println("-------------BFS traversl Nth height---------------");
        bfsTraversalKNearest(g,0,2);
    }

}
