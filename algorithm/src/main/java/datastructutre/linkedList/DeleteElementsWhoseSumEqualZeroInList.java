package datastructutre.linkedList;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by pourush.sinha on 26/01/19.
 */
public class DeleteElementsWhoseSumEqualZeroInList extends LinkedList {

    public static Node deleteElementsWhoseSumEqualZeroInList(Node head){

        Node start = head;
        Node end;

        while(start != null){
            end = start;
            int sum = 0;
            Boolean modified =false;

            while (end != null){
                sum = sum + end.data;
                if (sum == 0){
                    start = end;
                    modified = true;
                    break;
                }
                end = end.next;
            }

            if(!modified){
                System.out.println(start.data);
            }else{

            }
            start = start.next;

        }
        return start;
    }


    /*public static Node deleteElementsWhoseSumEqualZeroInList(Node head){

        Node start = head;
        Node end = head;
        int sum = 0;


        while(start != null && end != null){
            sum += end.data;

            if(sum == 0){
                start = end.next;
                end = start;
            }else {
                end = end.next;
            }

        }
        return start;
    }*/

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        //6, -6, 8, 4, -12, 9, 8, -8
        linkedList.push(-8);
        linkedList.push(8);
        linkedList.push(9);
        linkedList.push(-12);
        linkedList.push(4);
        linkedList.push(8);
        linkedList.push(-6);
        linkedList.push(6);

        linkedList.printList();
        Node node =deleteElementsWhoseSumEqualZeroInList(linkedList.head);
       // printList(node);

    }
}
