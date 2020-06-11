package datastructutre.linkedList;


/**
 * Created by pourush.sinha on 03/06/19.
 */
class DoublyLinkedListNode{
     public DoublyLinkedListNode(int data){
         this.data =data;
     }
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
}

public class InsertSortedLinkedList {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode dataNode = new DoublyLinkedListNode(data);
        if (head==null){
            head = dataNode;
            return head;
        }
        if(head.data > data){
            dataNode.next =head;
            head.prev=dataNode;
            head =dataNode;
            return head;
        }
        DoublyLinkedListNode prev =head;
        DoublyLinkedListNode next =head;
        while(next != null && next.data <= data){
            prev = next;
            next =next.next;
        }
        if(next==null){
            prev.next =dataNode;
            dataNode.prev =prev;
            return head;
        }
        prev.next =dataNode;
        dataNode.prev =prev;
        dataNode.next =next;
        next.prev =dataNode;

        return head;





    }

    public static DoublyLinkedListNode reverseThelinkedList(DoublyLinkedListNode head){

        if(head==null){
            return null;
        }

        DoublyLinkedListNode prev =head;
        DoublyLinkedListNode next =head.next;
        prev.next=null;
        while(next !=null){
            prev.prev = next;
            next = next.next;
            prev.prev.next =prev;
            prev =prev.prev;
        }

        head =prev;


        return head;
    }

    public static void main(String[] args) {

        DoublyLinkedListNode doublyLinkedListNode;
        doublyLinkedListNode=sortedInsert(null,1);
        doublyLinkedListNode=sortedInsert(doublyLinkedListNode,3);
        doublyLinkedListNode=sortedInsert(doublyLinkedListNode,1);
        doublyLinkedListNode=sortedInsert(doublyLinkedListNode,2);
        doublyLinkedListNode=sortedInsert(doublyLinkedListNode,3);
        doublyLinkedListNode=sortedInsert(doublyLinkedListNode,4);

        DoublyLinkedListNode head =doublyLinkedListNode;

        while (head !=null){
            System.out.println(head.data);
            head =head.next;
        }

         head = reverseThelinkedList(doublyLinkedListNode);

        while (head !=null){
            System.out.println(head.data);
            head =head.next;
        }


    }

}


