package datastructutre.trees;

import lombok.Data;
import utility.CommonUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pourush.sinha on 17/03/19.
 */
@Data
public class BinarySearchTree {

    /*
    * A Binary Search Tree is sometimes called ordered or sorted binary trees,
    * and it keeps its values in sorted order, so that lookup and other operations
    * can use the principle of binary search
    * */

    int data;
    BinarySearchTree leftChild;
    BinarySearchTree rightChild;

    BinarySearchTree(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }


    public void insertData(int data){

        if (this.data < data && this.leftChild != null){
            this.leftChild.insertData(data);

        }else if(this.data < data ){
            this.leftChild = new BinarySearchTree(data);
        }
        if (this.data > data && this.rightChild != null){
            this.rightChild.insertData(data);

        }else if(this.data > data ){
            this.rightChild = new BinarySearchTree(data);
        }
    }

    public static void breadthFirstSearch(BinarySearchTree node){

        Queue<BinarySearchTree> queue = new LinkedList<BinarySearchTree>();

        queue.add(node);
        while (!queue.isEmpty()){
            BinarySearchTree node1 = queue.remove();
            System.out.print(node1.data+" ");
            if (node1.leftChild != null){
                queue.add(node1.leftChild);
            }
            if (node1.rightChild != null){
                queue.add(node1.rightChild);
            }


        }

    }

    public  int getMaxDepthOfTree(BinarySearchTree node){

        if(node ==null){
            return  0;
        }else {
            int leftHeight = getMaxDepthOfTree(node.getLeftChild());
            int rightHeight = getMaxDepthOfTree(node.getRightChild());

            return (1 + Math.max(leftHeight,rightHeight));
        }
    }


    public static void main(String[] args) {
        BinarySearchTree node = new BinarySearchTree(5);
        node.insertData(2);
        node.insertData(3);
        node.insertData(1);
        node.insertData(10);
        node.insertData(11);
        node.insertData(4);
        node.insertData(6);
        node.insertData(7);
        node.insertData(8);
        node.insertData(9);
        breadthFirstSearch(node);
        System.out.println("\nMax height "+node.getMaxDepthOfTree(node));
        CommonUtils.printTree(node,0);

    }
}
