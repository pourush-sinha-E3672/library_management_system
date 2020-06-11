package datastructutre.linkedList;

/**
 * Created by pourush.sinha on 02/01/19.
 */
public class LinkedList {

    Node head; // head of linked list

    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);

        /* 3. Make next of new Node as head */
        new_node.next = head;

        /* 4. Move the head to point to new Node */
        head = new_node;
    }


    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }



    public static void printList(Node node)
    {
        Node tnode = node;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("NULL");
    }

    public static LinkedList prefilList(Integer lsitLengt){
        LinkedList llist = new LinkedList();

        for (int i=lsitLengt; i>0; --i)
        {
            llist.push(i*5);
        }


        return llist;



    }

    public static LinkedList prefilList(Integer lsitLengt ,int multiple){
        LinkedList llist = new LinkedList();

        for (int i=lsitLengt; i>0; --i)
        {
            llist.push(i * multiple);
        }


        return llist;



    }
}
