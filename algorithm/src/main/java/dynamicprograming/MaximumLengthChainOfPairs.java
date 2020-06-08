package dynamicprograming;

import utility.CommonUtils;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 25/12/18.
 */
public class MaximumLengthChainOfPairs implements Comparable<MaximumLengthChainOfPairs>  {

    static CommonUtils<MaximumLengthChainOfPairs> chainOfPairsCommonUtils =new CommonUtils<MaximumLengthChainOfPairs>();

    int a;
    int b;


    static int findLongaistChainLength(MaximumLengthChainOfPairs[] maximumLengthChainOfPairss){

        Arrays.sort(maximumLengthChainOfPairss);
        chainOfPairsCommonUtils.printArray(maximumLengthChainOfPairss);
        int[] dp = new int[maximumLengthChainOfPairss.length];

        dp[0] =1;

        for(int i = 1; i<maximumLengthChainOfPairss.length ;i++){
            System.out.println("******************"+i+"*************");
            dp[i] = dp[i - 1];
            for(int j =i-1 ;j>=0;j--){
                if(maximumLengthChainOfPairss[j].b < maximumLengthChainOfPairss[i].a){
                    dp[i] = (Math.max(dp[i] ,dp[j] +1 ));
                    //Expalnation
                    //dp[0]=1     dp[1]=2    dp[2]=2    dp[3]=3    dp[4]=4    dp[5]=4    dp[6]=5    dp[7]=6
                    //[100,101]  [200,301]  [300,302]  [400,401]  [500,601]  [600,602]  [700,701]  [800,801]
                    // in case of i = 6 and j = 3
                    //j.b=401 < i.a 600 satisfy the if case

                    // but dp[6] is already ahead due to calcualtion of dp[5]
                    //So dp[6] will not change as (Math.max(dp[6] =5 ,(dp[3]=3 +1) =4 )) =5;
                    //it will only change when i = 6 and j= 5
                    //dp[6] = dp[6 - 1 =5]  =4;
                    //if check satifies
                    //dp[6] = (Math.max(dp[6] =4 ,(dp[5]=4 +1) =5 )) =5
                }
            }
            CommonUtils.printArray(dp);
        }
       return dp[maximumLengthChainOfPairss.length -1];
    }


    public int compareTo(MaximumLengthChainOfPairs o) {
        if( this.a > o.a )
            return 1;
        else
            return  -1;

    }
    @Override
    public String toString(){
        return "["+this.a+","+this.b+"]\n";
    }

    public static void main(String[] args) {
        MaximumLengthChainOfPairs[] maximumLengthChainOfPairss = new MaximumLengthChainOfPairs[5];
        MaximumLengthChainOfPairs maximumLengthChainOfPairs1 =new MaximumLengthChainOfPairs();
        MaximumLengthChainOfPairs maximumLengthChainOfPairs2 =new MaximumLengthChainOfPairs();
        MaximumLengthChainOfPairs maximumLengthChainOfPairs3 =new MaximumLengthChainOfPairs();
        MaximumLengthChainOfPairs maximumLengthChainOfPairs4 =new MaximumLengthChainOfPairs();
        MaximumLengthChainOfPairs maximumLengthChainOfPairs5 =new MaximumLengthChainOfPairs();

        maximumLengthChainOfPairs1.a = 10;
        maximumLengthChainOfPairs1.b = 200;
        maximumLengthChainOfPairss[0] = maximumLengthChainOfPairs1;

        maximumLengthChainOfPairs2.a = 1;
        maximumLengthChainOfPairs2.b = 2;
        maximumLengthChainOfPairss[1] = maximumLengthChainOfPairs2;

        maximumLengthChainOfPairs3.a = 80;
        maximumLengthChainOfPairs3.b = 90;
        maximumLengthChainOfPairss[2] = maximumLengthChainOfPairs3;

        maximumLengthChainOfPairs4.a = 5;
        maximumLengthChainOfPairs4.b = 6;
        maximumLengthChainOfPairss[3] = maximumLengthChainOfPairs4;

        maximumLengthChainOfPairs5.a = 45;
        maximumLengthChainOfPairs5.b = 55;
        maximumLengthChainOfPairss[4] = maximumLengthChainOfPairs5;
        System.out.println("Brfore");
        chainOfPairsCommonUtils.printArray(maximumLengthChainOfPairss);
        System.out.println("after");
        System.out.println("max number of chain"+findLongaistChainLength(maximumLengthChainOfPairss));

    }
}
