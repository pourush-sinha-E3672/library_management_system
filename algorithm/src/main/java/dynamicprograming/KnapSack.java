package dynamicprograming;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by pourush.sinha on 10/06/19.
 */
public class KnapSack {

    static int getMaxProfit(int[] weights ,int[] values,int capacityOfSack){
        int[][] R = new int[values.length+1][capacityOfSack+1];
        for(int i=1;i<=values.length ;i++){
            for(int j=1;j<= capacityOfSack;++j){
                if(j - weights[i-1] >= 0 && values[i-1] + R[i-1][j - weights[i-1]] > R[i-1][j] ){
                   R[i][j] =   values[i-1] + R[i-1][j - weights[i-1]];
                }else{
                    R[i][j] =R[i-1][j];
                }
            }
        }

        for(int i=0;i<values.length+1;i++){
            for(int j=0;j<capacityOfSack+1 ;j++){
                System.out.print(R[i][j]+" ");
            }
            System.out.println();
        }

        int totalProfilt = R[values.length][capacityOfSack];;
        int capacity = capacityOfSack;
        for(int i = weights.length -1;i >= 0 ;i--){
            if(totalProfilt !=R[i][capacity]){
                System.out.println(weights[i]);
                capacity -=weights[i];
                totalProfilt -=values[i];
            }
        }
        new CopyOnWriteArrayList();


        return R[values.length][capacityOfSack];

    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  W = 50;

        System.out.println("max profit = "+getMaxProfit(wt,val,W));
    }
}
