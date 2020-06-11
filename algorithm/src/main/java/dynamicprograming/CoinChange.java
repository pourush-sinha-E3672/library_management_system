package dynamicprograming;

import utility.CommonUtils;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 23/12/18.
 */

/*
* Check out the resources on the page's right side to learn more about dynamic programming.
* The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book
* Cracking the Coding Interview.

Given a number of dollars and an array of denominations of coins, determine how many ways you
can make change. For example, making change n=12 for  dollars from coin denominations
coins =[1,2,5,10] , there are  ways to make change:

*/
public class CoinChange {
//explanaton https://www.youtube.com/watch?v=jaNZ83Q3QGc
    public static int count( int Coins[], int m, int n )
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int table[]=new int[n+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int coin: Coins) {
            //System.out.println("i ===" + i + "=====");
            for (int j = coin; j <= n; j++) {
               // System.out.println("j =="+S[i]);
                //System.out.println("table["+j+"]="+table[j]+" += table["+j+" - S["+i+"]="+S[i]+"]="+table[j - S[i]]+"");
                //System.out.println("table["+j+"] = +    table["+(j - S[i])+"] ");

                table[j] += table[j - coin];
                System.out.print("table array//////////////////////////////////////////// == ");
                CommonUtils.printArray(table);

            }
        }

        return table[n];
    }

    static int ways(int n, int[] coins) {
        int[] coinsComabinationTable =new int[n + 1];
        coinsComabinationTable[0] = 1;

        for(int coin : coins){
            for(int i =coin ;i<=n ;i++){
                coinsComabinationTable[i] += coinsComabinationTable[i - coin];

            }
            CommonUtils.printArray(coinsComabinationTable);
            System.out.println();
        }
        return coinsComabinationTable[n];



    }

    public static void main(String[] args) {
        //int arr[] = {1,2,3 };
        int arr[] ={2,5,10};
        int n = 12;
        /*int n = 250;
        int[] arr = {41,34,46,9,37,32,42,21,7,13,1,24,3,43,2,23,8,45,19,30,29,18,35,11};*/

        int m = arr.length;

        System.out.println("tiatal number of ways====="+ways(n,arr));
        /*int[] coins ={1,2,5,10};
        int[] r = new int[coins.length];
        int numberOfWays =0;

        for(int i=0 ;i <coins.length ; i++){
            int balance=0;
            if (12 % coins[i] ==0){
                numberOfWays =+1;
            }else{
                balance =  12 / coins[i];
                r[i] = balance;
            }

        }
        System.out.println(12  % 6);*/
    }
}
