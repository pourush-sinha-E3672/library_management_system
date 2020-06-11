package dynamicprograming;

/**
 * Created by pourush.sinha on 30/11/18.
 */
public class ClimbingStairs {
  /*
  You can climb 1 or 2 stairs with one step. How many diffrent waysyou can climb n stairs
  * */


   public static int numberOfWaysYouCanClimb(int n){
       int arr[] =new int[n];
       if (n == 1){
           return 1;
       }

       if (n == 2){
           return 2;
       }

       arr[0] = 1;
       arr[1] = 2;


       for(int i=2; i<n ;i++){
           arr[i] = arr[i-1] + arr[i - 2];
       }


       return arr[n-1];
   }

    public static void main(String[] args) {
       int n =45;
        System.out.println("number of stairs "+n);
        int ways = numberOfWaysYouCanClimb(n);
        System.out.println("number of ways "+ways);
    }
}
