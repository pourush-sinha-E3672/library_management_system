package dynamicprograming;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 02/12/18.
 */
public class CuttingRodProblem {
    /*
    * Given a rod of length n inches and an array of prices that contains prices of all pieces of
    * size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling
    * the pieces. For example, if length of the rod is 8 and the values of different pieces are given
    * as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)*/

    /*length   | 1   2   3   4   5   6   7   8
--------------------------------------------
      price    | 1   5   8   9  10  17  17  20*/

    private static int[] arr ={1, 5, 8, 9, 10, 17, 17, 20};


    // recursicve solution O 2^n
    public static int recursicve(int n){
        int max_value =Integer.MIN_VALUE;
        if (n == 0) return 0;
        for(int i=0 ;i < n ;i++){
             int temp = recursicve(i) + arr[(n -1) - i];
             if (max_value < temp){
                 max_value = temp;
             }
        }
        return max_value;

    }

    //DP soloution

    public static int cutRod(int n){
        int dpArray[] =new int[n+1];
        dpArray[0] = 0;
        for (int i = 1 ; i <= n ; i++){
            int max_value =-1;
            System.out.println("rod of length  = "+i);
            for(int j = 0 ; j<i ; j++){
                System.out.println("rod length = "+(j + 1)+"  and optimal solution of rod length ="+(i - j - 1));
                System.out.println("      iteration j = "+j+" max_value "+max_value+" arr["+j+"] ="+arr[j]+" + (dpArray["+i+" - "+j+" - 1])dpArray["+(i - j - 1)+"]="+dpArray[i - j - 1]+"===="+(arr[j] + dpArray[i - j - 1]));
                max_value =Math.max(max_value , arr[j] + dpArray[i - j - 1]);
                System.out.println("final max value = "+max_value);
            }
            dpArray[i] = max_value;
            System.out.println(Arrays.toString(dpArray));
        }
        return dpArray[n];
    }

    public static void main(String[] args) {
        int length =8;
        System.out.println("Length of the rod "+length);
        System.out.println("Soulution with recursive call");
        //System.out.println(recursicve(length));
        System.out.println("Soulution with DP call");
        System.out.println(cutRod(length));
    }


    /*iteration i = 1
      iteration j = 0 max_value -2147483648 arr[0] (val[1 - 0 -1])val[0]=0
final max value = 1
[0, 1, 0, 0, 0, 0, 0, 0, 0]
iteration i = 2
      iteration j = 0 max_value -2147483648 arr[0] (val[2 - 0 -1])val[1]=1
final max value = 2
      iteration j = 1 max_value 2 arr[1] (val[2 - 1 -1])val[0]=0
final max value = 5
[0, 1, 5, 0, 0, 0, 0, 0, 0]
iteration i = 3
      iteration j = 0 max_value -2147483648 arr[0] (val[3 - 0 -1])val[2]=5
final max value = 6
      iteration j = 1 max_value 6 arr[1] (val[3 - 1 -1])val[1]=1
final max value = 6
      iteration j = 2 max_value 6 arr[2] (val[3 - 2 -1])val[0]=0
final max value = 8
[0, 1, 5, 8, 0, 0, 0, 0, 0]
iteration i = 4
      iteration j = 0 max_value -2147483648 arr[0] (val[4 - 0 -1])val[3]=8
final max value = 9
      iteration j = 1 max_value 9 arr[1] (val[4 - 1 -1])val[2]=5
final max value = 10
      iteration j = 2 max_value 10 arr[2] (val[4 - 2 -1])val[1]=1
final max value = 10
      iteration j = 3 max_value 10 arr[3] (val[4 - 3 -1])val[0]=0
final max value = 10
[0, 1, 5, 8, 10, 0, 0, 0, 0]
iteration i = 5
      iteration j = 0 max_value -2147483648 arr[0] (val[5 - 0 -1])val[4]=10
final max value = 11
      iteration j = 1 max_value 11 arr[1] (val[5 - 1 -1])val[3]=8
final max value = 13
      iteration j = 2 max_value 13 arr[2] (val[5 - 2 -1])val[2]=5
final max value = 13
      iteration j = 3 max_value 13 arr[3] (val[5 - 3 -1])val[1]=1
final max value = 13
      iteration j = 4 max_value 13 arr[4] (val[5 - 4 -1])val[0]=0
final max value = 13
[0, 1, 5, 8, 10, 13, 0, 0, 0]
iteration i = 6
      iteration j = 0 max_value -2147483648 arr[0] (val[6 - 0 -1])val[5]=13
final max value = 14
      iteration j = 1 max_value 14 arr[1] (val[6 - 1 -1])val[4]=10
final max value = 15
      iteration j = 2 max_value 15 arr[2] (val[6 - 2 -1])val[3]=8
final max value = 16
      iteration j = 3 max_value 16 arr[3] (val[6 - 3 -1])val[2]=5
final max value = 16
      iteration j = 4 max_value 16 arr[4] (val[6 - 4 -1])val[1]=1
final max value = 16
      iteration j = 5 max_value 16 arr[5] (val[6 - 5 -1])val[0]=0
final max value = 17
[0, 1, 5, 8, 10, 13, 17, 0, 0]
iteration i = 7
      iteration j = 0 max_value -2147483648 arr[0] (val[7 - 0 -1])val[6]=17
final max value = 18
      iteration j = 1 max_value 18 arr[1] (val[7 - 1 -1])val[5]=13
final max value = 18
      iteration j = 2 max_value 18 arr[2] (val[7 - 2 -1])val[4]=10
final max value = 18
      iteration j = 3 max_value 18 arr[3] (val[7 - 3 -1])val[3]=8
final max value = 18
      iteration j = 4 max_value 18 arr[4] (val[7 - 4 -1])val[2]=5
final max value = 18
      iteration j = 5 max_value 18 arr[5] (val[7 - 5 -1])val[1]=1
final max value = 18
      iteration j = 6 max_value 18 arr[6] (val[7 - 6 -1])val[0]=0
final max value = 18
[0, 1, 5, 8, 10, 13, 17, 18, 0]
iteration i = 8
      iteration j = 0 max_value -2147483648 arr[0] (val[8 - 0 -1])val[7]=18
final max value = 19
      iteration j = 1 max_value 19 arr[1] (val[8 - 1 -1])val[6]=17
final max value = 22
      iteration j = 2 max_value 22 arr[2] (val[8 - 2 -1])val[5]=13
final max value = 22
      iteration j = 3 max_value 22 arr[3] (val[8 - 3 -1])val[4]=10
final max value = 22
      iteration j = 4 max_value 22 arr[4] (val[8 - 4 -1])val[3]=8
final max value = 22
      iteration j = 5 max_value 22 arr[5] (val[8 - 5 -1])val[2]=5
final max value = 22
      iteration j = 6 max_value 22 arr[6] (val[8 - 6 -1])val[1]=1
final max value = 22
      iteration j = 7 max_value 22 arr[7] (val[8 - 7 -1])val[0]=0
final max value = 22
[0, 1, 5, 8, 10, 13, 17, 18, 22]
22
*/
}
