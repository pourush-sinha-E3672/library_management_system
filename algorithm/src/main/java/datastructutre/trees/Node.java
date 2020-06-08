package datastructutre.trees;

import com.google.common.collect.Lists;
import com.sun.tools.javac.util.ArrayUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import utility.CommonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by pourush.sinha on 16/03/19.
 */
@Data
public class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data){
        this.data = data;
        this.leftNode= null;
        this.rightNode = null;

    }


    /*
    * Depth-First Search (DFS)
      DFS explores a path all the way to a leaf before backtracking and exploring another path.
      Let’s take a look at an example with this type of traversal.
    */

    /*
    * Pre-order
    This is exactly what we did in the above example.
    Print the value of the node.
    Go to the left child and print it. This is if, and only if, it has a left child.
    Go to the right child and print it. This is if, and only if, it has a right child.

                                  1
                      2                     5

              3             4         6                   7

    */
    //recursive
    public void preOrder(){
        System.out.print(this.data+" ");
        if (this.leftNode != null){
            this.leftNode.preOrder();
        }
        if (this.rightNode != null){
            this.rightNode.preOrder();
        }
    }
    //Non recursive

    public static void preOrder(Node node){
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);

        while (!stack.empty()){
            Node node1 = stack.peek();
            stack.pop();
            System.out.print(node1.data+" ");
            if(node1.getRightNode() != null){
                stack.push(node1.getRightNode());
            }
            if(node1.getLeftNode() != null){
                stack.push(node1.getLeftNode());
            }

        }

    }

    /*InOrder
    * The left first, the middle second, and the right last.
    * Go to the left child and print it. This is if, and only if, it has a left child.
      Print the node’s value
      Go to the right child and print it. This is if, and only if, it has a right child.
    * */
    //Recusive
     public void inOrder(){
         if (this.leftNode != null){
             this.leftNode.inOrder();
         }
         System.out.print(this.data+" ");
         if (this.rightNode != null){
             this.rightNode.inOrder();
         }
     }

     //Non recursive
    public static void inOrder(Node node){
         Node curr = node;
         Stack<Node> stack = new Stack<Node>();

         while (curr != null || !stack.empty()){
             while(curr != null){
                 stack.push(curr);
                 curr = curr.leftNode;
             }

             curr  = stack.pop();
             System.out.print(curr.data+" ");

             curr = curr.getRightNode();
         }
    }
     /*PostOrder
     * The left first, the right second, and the middle last.
     *
     * Go to the left child and print it. This is if, and only if, it has a left child.
       Go to the right child and print it. This is if, and only if, it has a right child.
       Print the node’s value
*/
     //Recusive
     public void postOrder(){
         if (this.leftNode != null){
             this.leftNode.postOrder();
         }

         if (this.rightNode != null){
             this.rightNode.postOrder();
         }
         System.out.print(this.data+" ");
     }

     //Non recursive
    /*
    *
                                  1
                      2                     5

              3             4         6                   7
*/
    public static void postOrder(Node node){
        List<Integer> list = new ArrayList<Integer>();
        Stack<Node> S = new Stack<Node>();

            // Check for empty tree
            S.push(node);
            Node prev = null;
            while (!S.isEmpty())
            {
                Node current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
                if (prev == null || prev.leftNode == current ||
                        prev.rightNode == current)
                {
                    if (current.leftNode != null)
                        S.push(current.leftNode);
                    else if (current.rightNode != null)
                        S.push(current.rightNode);
                    else
                    {
                        S.pop();
                        list.add(current.data);
                    }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
                }
                else if (current.leftNode == prev)
                {
                    if (current.rightNode != null)
                        S.push(current.rightNode);
                    else
                    {
                        S.pop();
                        list.add(current.data);
                    }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
                }
                else if (current.rightNode == prev)
                {
                    S.pop();
                    list.add(current.data);
                }

                prev = current;
            }

        System.out.println(Arrays.toString(list.toArray()));
    }

    //BFS
    public static void breadthFirstSearch(Node node){

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(node);
        while (!queue.isEmpty()){
            Node node1 = queue.remove();
            System.out.print(node1.data+" ");
            if (node1.leftNode != null){
                queue.add(node1.leftNode);
            }
            if (node1.rightNode != null){
                queue.add(node1.rightNode);
            }


        }



    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node2.setLeftNode(node3);
        node2.setRightNode(node4);
        node1.setLeftNode(node2);
        node5.setRightNode(node7);
        node5.setLeftNode(node6);
        node1.setRightNode(node5);
        System.out.println("PreOrder");
        node1.preOrder();
        System.out.println("\n Non recursive PreOrder");
        preOrder(node1);
        System.out.println("\nInOrder");
        node1.inOrder();
        System.out.println("\nNon recursive InOrder");
        inOrder(node1);
        System.out.println("\nPostOrder");
        node1.postOrder();
        System.out.println("\nNon recursive PostOrder");
        node1.postOrder(node1);
        System.out.println("\nBFS");
        breadthFirstSearch(node1);

    }
}
