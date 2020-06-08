package interviewQuestions;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 09/06/19.
 */
public class ImplementSplitwise {

    // Number of persons (or vertices in the graph)
    static final int N = 3;

    // A utility function that returns
    // index of minimum value in arr[]
    static int getMin(int arr[])
    {
        int minInd = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    // A utility function that returns
    // index of maximum value in arr[]
    static int getMax(int arr[])
    {
        int maxInd = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[maxInd])
                maxInd = i;
        return maxInd;
    }

    // A utility function to return minimum of 2 values
    static int minOf2(int x, int y)
    {
        return (x < y) ? x: y;
    }

    // amount[p] indicates the net amount
    // to be credited/debited to/from person 'p'
    // If amount[p] is positive, then
    // i'th person will amount[i]
    // If amount[p] is negative, then
    // i'th person will give -amount[i]
    static void minCashFlowRec(int amount[])
    {
        // Find the indexes of minimum and
        // maximum values in amount[]
        // amount[mxCredit] indicates the maximum amount
        // to be given (or credited) to any person .
        // And amount[mxDebit] indicates the maximum amount
        // to be taken(or debited) from any person.
        // So if there is a positive value in amount[],
        // then there must be a negative value
        int mxCredit = getMax(amount), mxDebit = getMin(amount);

        // If both amounts are 0, then
        // all amounts are settled
        if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        // Find the minimum of two amounts
        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        // If minimum is the maximum amount to be
        System.out.println("Person " + mxDebit + " pays " + min
                + " to " + "Person " + mxCredit);

        // Recur for the amount array.
        // Note that it is guaranteed that
        // the recursion would terminate
        // as either amount[mxCredit]  or
        // amount[mxDebit] becomes 0
        minCashFlowRec(amount);
    }

    // Given a set of persons as graph[]
    // where graph[i][j] indicates
    // the amount that person i needs to
    // pay person j, this function
    // finds and prints the minimum
    // cash flow to settle all debts.
    static void minCashFlowGEEKS(int graph[][])
    {
        // Create an array amount[],
        // initialize all value in it as 0.
        int amount[]=new int[graph.length];

        // Calculate the net amount to
        // be paid to person 'p', and
        // stores it in amount[p]. The
        // value of amount[p] can be
        // calculated by subtracting
        // debts of 'p' from credits of 'p'
        for (int p = 0; p < graph.length; p++)
            for (int i = 0; i < graph.length; i++)
                amount[p] += (graph[i][p] - graph[p][i]);

        minCashFlowRec(amount);
    }

    static void minCashFlow(int[][] arr){

        int[] balanceAmountEachPerson = new int[arr.length];

        for(int i=0 ;i<arr.length ;i++){
            for(int p=0;p<arr.length;p++){
                balanceAmountEachPerson[i] += (arr[p][i] - arr[i][p]);
            }
        }
        System.out.println("balance Amount = "+ Arrays.toString(balanceAmountEachPerson));

        minCashFlowReqs(balanceAmountEachPerson);
        
        


    }

    private static void minCashFlowReqs(int[] balanceAmountEachPerson) {

        int maxCrditPerson = getMaxCredit(balanceAmountEachPerson);
        int minCrditPerson = getMinCredit(balanceAmountEachPerson);
        if(balanceAmountEachPerson[maxCrditPerson]==0 || balanceAmountEachPerson[minCrditPerson] ==0){
            return;
        }
        if(balanceAmountEachPerson[maxCrditPerson]>= Math.abs(balanceAmountEachPerson[minCrditPerson])){
            System.out.println("Person " + minCrditPerson + " pays " + Math.abs(balanceAmountEachPerson[minCrditPerson])
                    + " to " + "Person " + maxCrditPerson);
            int amount = balanceAmountEachPerson[maxCrditPerson] -  Math.abs(balanceAmountEachPerson[minCrditPerson]);
            balanceAmountEachPerson[maxCrditPerson] =amount;
            balanceAmountEachPerson[minCrditPerson] =0;
        }else{
            System.out.println("Person " + minCrditPerson + " pays " + balanceAmountEachPerson[maxCrditPerson]
                    + " to " + "Person " + maxCrditPerson);
            int amount =Math.abs(balanceAmountEachPerson[minCrditPerson]) - balanceAmountEachPerson[maxCrditPerson];
            balanceAmountEachPerson[maxCrditPerson] =0;
            balanceAmountEachPerson[minCrditPerson] = -amount;
        }
        minCashFlowReqs(balanceAmountEachPerson);
    }

    static int getMaxCredit(int[] arr){
        int maxCredit =0;
        
        for(int i =1;i<arr.length;i++){
            if(arr[maxCredit] < arr[i]){
                maxCredit = i;
            }
        }
        return maxCredit;
    }

    static int getMinCredit(int[] arr){
        int minCredit =0;

        for(int i =1;i<arr.length;i++){
            if(arr[minCredit] > arr[i]){
                minCredit = i;
            }
        }
        return minCredit;
    }


    public static void main(String[] args) {
        int[][] lenaDena = {{0, 1000, 1000, 1000},
                            {1000, 3000, 0, 2000},
                            {500, 5000, 0, 0},
                            {0, 0, 0, 0}};
        minCashFlow(lenaDena);
        System.out.println("-------------------------");
        minCashFlowGEEKS(lenaDena);
        
    }
}
