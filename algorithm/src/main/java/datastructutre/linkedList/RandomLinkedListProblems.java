package datastructutre.linkedList;

/**
 * Created by pourush.sinha on 06/01/19.
 */
public class RandomLinkedListProblems {

    public static Node merge2SortedList(){
        Node node1 = LinkedList.prefilList(8,5).head;
        System.out.print("List one ");
        LinkedList.printList(node1);
        Node node2 = LinkedList.prefilList(10,7).head;
        System.out.print("List two ");
        LinkedList.printList(node2);
        Node tempNode = new Node();
        Node tempHead =tempNode;

        while(true){

            if(node1 == null){
                tempHead.next =node2;
                break;
            }

            if(node2 == null){
                tempHead.next = node1;
                break;
            }

            if(node1.data <= node2.data){
                tempHead.next = node1;
                tempHead = tempHead.next;
                node1 = node1.next;
            }else {
                tempHead.next = node2;
                tempHead = tempHead.next;
                node2 =node2.next;
            }
        }

        System.out.print("Mreged List ");
        LinkedList.printList(tempNode.next);
        return tempNode;



    }

    public static void main(String[] args) {

        merge2SortedList();

    }
}
