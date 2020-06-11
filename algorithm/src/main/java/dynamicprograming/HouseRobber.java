package dynamicprograming;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 03/12/18.
 */
public class HouseRobber {

    //Find maximum possible stolen value from houses

    /*
    * There are n houses build in a line, each of which
    * contains some value in it. A thief is going to steal
    * the maximal value of these houses, but he can’t steal
    * in two adjacent houses because owner of the stolen
    * houses will tell his two neighbour left and right side.
    * What is the maximum stolen value.
    * */

    /*
    * Input  : hval[] = {6, 7, 1, 3, 8, 2, 4}
      Output : 19
      Thief will steal 6, 1, 8 and 4 from house.

      Input  : hval[] = {5, 3, 4, 11, 2}
      Output : 16
      Thief will steal 5 and 11*/

    /*
    * dp[i] = max (hval[i] + dp[i-2], dp[i-1])

    hval[i] + dp[i-2] is the case when thief
    decided to rob house i. In that situation
    maximum value will be the current value of
    house + maximum value stolen till last
    robbery at house not adjacent to house
    i which will be house i-2.

    dp[i-1] is the case when thief decided not
    to rob house i. So he will check adjacent
    house for maximum value stolen till now.*/

    static int[] arr = {6, 7, 1, 3, 8, 2, 4};

    public static int robHouse(int n){

        if(n==0){
            return 0;
        }

        if(n==1){
            return arr[0];
        }
        if(n==2){
            return Math.max(arr[0],arr[1]);
        }

        Integer[] dpArray = new Integer[n];

        dpArray[0] = arr[0];
        dpArray[1] = Math.max(arr[0],arr[1]);

        for (int i =2 ;i<n ;i++){
            dpArray[i] = Math.max(arr[i]+ dpArray[i - 2], dpArray[i - 1]);
            System.out.println("\nMax of ((arr["+i+"]="+arr[i]+" + dpArray["+i+" - 2] ="+dpArray[i - 2]+") = "+(arr[i]+ dpArray[i - 2])+" , dpArray["+i+" - 1] ="+dpArray[i - 1]+" >>>>>>>"+Math.max(arr[i]+ dpArray[i - 2], dpArray[i - 1]));
            System.out.println("DP array for "+i+" position "+Arrays.toString(dpArray));
        }

        return dpArray[n - 1];

    }

    public static void main(String[] args) {
        System.out.println("Number of house with amount "+ Arrays.toString(arr));
        int maxAmount = robHouse(arr.length);
        System.out.println("Max Amount that can be stolen "+maxAmount);
    }
}
