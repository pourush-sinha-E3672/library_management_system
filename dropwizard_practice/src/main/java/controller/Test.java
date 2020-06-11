package controller;

import java.util.concurrent.TimeUnit;

/**
 * Created by pourush.sinha on 26/09/19.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            /*double check = 0.0;
            int var = (int) check;
            System.out.print(var);
            TimeUnit.SECONDS.sleep(1);*/
            int n=1;
            for(int j=0;j<n;j++) {
                Long i = 0L;
                Person p = new Person(i++);
                String s="";
                s= s+i;
            }
            n++;
        }

    }
}

class Person{
    Long i;
    Person(Long i){ this.i =i; }


}
