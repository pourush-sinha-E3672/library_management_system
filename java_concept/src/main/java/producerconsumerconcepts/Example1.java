package producerconsumerconcepts;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by pourush.sinha on 04/09/18.
 */
public class Example1 {

    public static void main(String args[]){

        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread1 = new Thread(new Consumer(sharedQueue,1));
        Thread consThread2 = new Thread(new Consumer(sharedQueue,2));
        Thread consThread3 = new Thread(new Consumer(sharedQueue,3));
        Thread consThread4 = new Thread(new Consumer(sharedQueue,4));
        Thread consThread5 = new Thread(new Consumer(sharedQueue,5));



        //Starting producer and Consumer thread
        prodThread.start();
        consThread1.start();
        consThread2.start();
        consThread3.start();
        consThread4.start();
        consThread5.start();
    }


}




class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }


    public void run() {
        int i =0;
        for(;;){
            try {
                i++;
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
                if ((i % 1000) == 0) Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
        }
    }

}

//Consumer Class in Java
class Consumer implements Runnable{

    private final BlockingQueue sharedQueue;
    private  int i;

    public Consumer (BlockingQueue sharedQueue,int i) {
        this.sharedQueue = sharedQueue;
        this.i = i;
    }


    public void run() {
        while(true){
            try {
                System.out.println("Consumer "+i+" wokeup");
                System.out.println("Consumer "+i+" consumed: "+ sharedQueue.take());
                System.out.println("Consumer "+i+" sleeping");
                Thread.sleep(200);
            } catch (InterruptedException ex) {

            }
        }
    }


}


