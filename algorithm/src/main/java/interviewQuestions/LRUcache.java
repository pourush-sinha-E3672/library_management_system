package interviewQuestions;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pourush.sinha on 31/12/19.
 */
public class LRUcache {

    private final int capacity;
    private Map<String,DoublyLinkedList> map ;
    private DoublyLinkedList head =null;
    private DoublyLinkedList tail=null;
    private int currentCapacity=0;


    public LRUcache(int capacity){
        map = new HashMap<String,DoublyLinkedList>();
        this.capacity =capacity;
    }

    private void insertFront(DoublyLinkedList node){
        node.prev=null;
        node.next =null;
        if(head!=null){
            head.prev=node;
            node.next = head;
            head =node;
        }

        if (head==null){
            head = node;

        }

        if(tail==null){
            tail=node;
        }




    }

    public Integer getKey(String key){

        if(map.containsKey(key)){
            DoublyLinkedList node = map.get(key);
            deleteNode(node);
            insertFront(node);
            return node.data;
        }
        return null;
    }


    public void setData(String key,int data){
        if (map.containsKey(key)){
           DoublyLinkedList node = map.get(key);
           deleteNode(node);
           node.prev=null;
           node.next = null;
           insertFront(node);
           map.put(key,node);

        }else{
            currentCapacity++;
            if(currentCapacity > capacity){
                int numberOfnodes = currentCapacity - capacity;
                deleteNodes(numberOfnodes);
            }
            DoublyLinkedList node = new DoublyLinkedList(key,data);

            map.put(key,node);
            insertFront(node);
        }

    }

    private void deleteNodes(int numberOfnodes) {
        while(numberOfnodes>0){
            map.remove(tail.key);
            tail= tail.prev;
            numberOfnodes--;
        }

        tail.next=null;
    }


    private void deleteNode(DoublyLinkedList node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }


    public void printList(){

        DoublyLinkedList node =head;

        System.out.print("List : ");

        while (node != null){
            System.out.print(node.data+"->");
            node=node.getNext();
        }

        System.out.print("NULL\n");

    }


    public static void main(String[] args) {
        LRUcache lrUcache = new LRUcache(5);
        System.out.println("adding pou1");
        lrUcache.setData("pou1",1);
        lrUcache.printList();
        System.out.println("adding pou2");
        lrUcache.setData("pou2",2);
        lrUcache.printList();
        System.out.println("adding pou3");
        lrUcache.setData("pou3",3);
        lrUcache.printList();
        System.out.println("adding pou4");
        lrUcache.setData("pou4",4);
        lrUcache.printList();
        System.out.println("adding pou5");
        lrUcache.setData("pou5",5);
        lrUcache.printList();
        System.out.println("Again  adding pou4");
        lrUcache.setData("pou4",4);
        lrUcache.printList();
        System.out.println("getting pou3");
        lrUcache.getKey("pou3");
        lrUcache.printList();
        System.out.println("adding pou6");
        lrUcache.setData("pou6",6);
        lrUcache.printList();



    }
}

@Data
class DoublyLinkedList{
    int data;
    String key;
    DoublyLinkedList prev = null;
    DoublyLinkedList next = null;

    public DoublyLinkedList(String key, int data){
        this.data=data;
        this.key = key;
    }


}
