package dynamicprograming;

import utility.CommonUtils;

/**
 * Created by pourush.sinha on 22/12/18.
 */


/*
* The cost of a stock on each day is given in an array,
* find the max profit that you can make by buying and selling
* in those days. For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
* the maximum profit can earned by buying on day 0,
* selling on day 3. Again buy on day 4 and sell on day 6.
* If the given array of prices is sorted in decreasing order, t
* hen profit cannot be earned at all.
* */

/*
* If we are allowed to buy and sell only once, then we can use following algorithm.
* Maximum difference between two elements. Here we are allowed to buy and sell multiple
* times. Following is algorithm for this problem.
1. Find the local minima and store it as starting index. If not exists, return.
2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
3. Update the solution (Increment count of buy sell pairs)
4. Repeat the above steps if end is not reached.

*/
public class StockBuySellToMaximizeProfit {
    static int[] arr = {100, 180, 260, 310, 40, 535, 695};
  //recursive solution
    public static int maxProfit(int i){

        if(i == 0) return 0;

        int maxValue = maxProfit(i - 1);

        for(int j = 0 ;j < i; j++){
            maxValue = Math.max(maxValue ,(arr[i-1] - arr[j]));
        }

        return maxValue;





    }

    //nonrecursive Solution

    public static int maxProfitNonRecursive(int[] arr){
        int[] r = new int[arr.length];

        r[0] = 0 ;
        int min_value = arr[0];
        for(int j =1 ;j<arr.length ;j++){

            min_value = Math.min(min_value,arr[j]);
            r[j] = Math.max(r[j - 1],(arr[j] - min_value));

        }
        return r[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println("Stocks day wise");
        CommonUtils.printArray(arr);
        System.out.println("Recursive");
        System.out.println("Max value == "+ maxProfit(arr.length));
        System.out.println("Non recursive");
        System.out.println("Max value =="+maxProfitNonRecursive(arr));

        System.out.println("Max value practice =="+run(arr.length,arr));
    }







    //********************Practice*********************

    public static int run(int i, int[] arr){

        if(i==0){
            return 0;
        }

        int sum = run(i-1,arr);
        for(int j=0; j<i ;j++){
            sum = Math.max(sum , arr[i-1] -arr[j]);
        }
        return sum;
    }
}
