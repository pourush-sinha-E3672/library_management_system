package utility;

import datastructutre.trees.BinarySearchTree;
import datastructutre.trees.Node;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 22/12/18.
 */
public class CommonUtils<k> {

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr)); }


    public  void printArray(k[] arr) {
        System.out.println(Arrays.toString(arr)); }

    public static void printSpace(int n){
        for(int i=0; i < n;i++){
            System.out.print(" ");
        }
    }
    public static void printTree(BinarySearchTree node, int level){
        if (node==null){
            return;
        }
        printTree(node.getLeftChild(),level +1);
        printSpace(level*6);
        System.out.println(node.getData());
        printTree(node.getRightChild(),level +1);
    }
}
