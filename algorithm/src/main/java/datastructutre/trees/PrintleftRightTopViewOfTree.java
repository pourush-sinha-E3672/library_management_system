package datastructutre.trees;

import com.google.common.collect.Maps;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by pourush.sinha on 20/05/19.
 */
public class PrintleftRightTopViewOfTree {

    static int  maxLevel = 0 ;

    void leftView(Node node,int level){

        if(node ==null){
            return;
        }

        if(maxLevel < level){
            System.out.println(node.data);
            maxLevel = level;
        }

        leftView(node.leftNode,level + 1);
        leftView(node.rightNode,level + 1);


    }

    public static void main(String[] args) {

        Node tree = new Node(12);
        tree.leftNode = new Node(10);
        tree.rightNode = new Node(30);
        tree.rightNode.leftNode = new Node(25);
        tree.rightNode.rightNode = new Node(40);
        PrintleftRightTopViewOfTree printleftRightTopViewOfTree = new PrintleftRightTopViewOfTree();
        printleftRightTopViewOfTree.leftView(tree,1);
        System.out.println("tope View ofthe tree");
        printleftRightTopViewOfTree.topView(tree);

    }

    public void topView(Node node){
        if(node ==null){
            return;
        }

        Queue<Pair> queue = new LinkedList<Pair>();
        Map<Integer,Integer> map = Maps.newHashMap();

        queue.add(new Pair(node,0));

        while(queue.size()>0){
            Node node1 =queue.peek().first;
            int next = queue.peek().next;
            queue.remove();

            if(map.get(next)==null){
                System.out.println(node1.data);
                map.put(next,node1.data);
            }

            if (node1.leftNode !=null){
                queue.add(new Pair(node1.getLeftNode(),next-1));

            }

            if (node1.rightNode !=null){
                queue.add(new Pair(node1.getRightNode(),next+1));

            }
        }
    }
}

class Pair{
    Node first;
    int next;
    Pair(Node node, int next){
        this.first = node;
        this.next = next;
    }
}