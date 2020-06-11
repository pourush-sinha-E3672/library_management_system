package datastructutre.linkedList;

/**
 * Created by pourush.sinha on 02/01/19.
 */
public class PrintMiddleOfThelinkedList {


    public static void printTheMiddleOfAGivenLinkedList(){
        System.out.println("Print middle of the below linked list");
        LinkedList linkedList = LinkedList.prefilList(11);
        linkedList.printList();
        Node head =linkedList.head;
        Node head2x = linkedList.head;
        while(head != null &&(head2x !=null && head2x.next !=null) ){
            head =head.next;
            head2x = head2x.next.next;
        }
        System.out.println("middle of linked list is "+head.data);

    }

    public static void main(String[] args) {
        printTheMiddleOfAGivenLinkedList();
    }
}
