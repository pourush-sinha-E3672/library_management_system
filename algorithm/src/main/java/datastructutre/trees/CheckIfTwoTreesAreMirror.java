package datastructutre.trees;

/**
 * Created by pourush.sinha on 16/01/20.
 */
public class CheckIfTwoTreesAreMirror {


    Boolean checkIfTreesAreMirror(Node node1, Node node2){

        if(node1==null && node2 ==null){
            return true;
        }

        if(node1==null || node2 ==null){
            return false;
        }
        return node1.data==node2.data && checkIfTreesAreMirror(node1.leftNode,node2.rightNode)
                && checkIfTreesAreMirror(node1.rightNode,node2.leftNode);


    }

    public static void main(String[] args)
    {
        CheckIfTwoTreesAreMirror tree = new CheckIfTwoTreesAreMirror();
        Node a = new Node(1);
        Node b = new Node(1);
        a.leftNode = new Node(2);
        a.rightNode = new Node(3);
        a.leftNode.leftNode = new Node(4);
        a.leftNode.rightNode = new Node(5);

        b.leftNode = new Node(3);
        b.rightNode = new Node(2);
        b.rightNode.leftNode = new Node(5);
        b.rightNode.rightNode = new Node(4);

        if (tree.checkIfTreesAreMirror(a, b) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
