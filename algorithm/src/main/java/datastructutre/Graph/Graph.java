package datastructutre.Graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pourush.sinha on 22/12/19.
 */
public class Graph {

    int vertices;
    List<Integer>[] adjacencyList;

    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        this.adjacencyList[source].add(destination);

        //for undirected graph uncomment the line below
        //this.adjacencyList[destination].insertAtEnd(source);
    }
    public void printGraph()
    {
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++)
        {
            if(adjacencyList[i]!=null){
                System.out.print("|" + i + "| => ");

                List temp = adjacencyList[i];
                for(int j =0 ;j<temp.size() ;j++){
                    System.out.print("[" + temp.get(j) + "] -> ");
                }
                System.out.println("null");
            }
            else{

                System.out.println("|" + i + "| => "+ "null");
            }
        }
    }

}
