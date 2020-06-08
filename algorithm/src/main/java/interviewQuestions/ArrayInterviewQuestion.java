package interviewQuestions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by pourush.sinha on 14/06/19.
 */
public class ArrayInterviewQuestion {

    //*********************************************************************************
    // sum of sub array
    //Sum of the  3 elements in an accending array

    static void check3ElementSumInArray(){

        int[] arr = {-1,0 ,1 ,2 ,-1 ,-4};
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            int j =i+1;
            int k = arr.length -1;

            while(j<k){

                if(arr[i]+ arr[j]+arr[k] >0){
                    k--;
                }else if(arr[i]+ arr[j]+arr[k]<0){
                    j++;
                }else{
                    System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    k--;
                    j++;
                }
            }

        }
    }

    static public List<List<Integer>> fourSum() {

        int target=0;
        int[] nums ={1,0 ,-1 ,0 ,-2 ,2};
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums==null|| nums.length<4)
            return result;

        Arrays.sort(nums);

        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        List<Integer> t = new ArrayList<Integer>();
                        System.out.println(nums[i]+","+nums[j]+","+nums[k]+","+nums[l]);
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);

                        k++;
                        l--;

                        while(k<l &&nums[l]==nums[l+1] ){
                            l--;
                        }

                        while(k<l &&nums[k]==nums[k-1]){
                            k++;
                        }
                    }


                }
            }
        }

        return result;
    }

    public static void  threeSumClosest(){
        int[] arr ={-1 ,2 ,1 ,-4};
        Arrays.sort(arr);
        int number =1;
        int min = Integer.MAX_VALUE;
        int closestSum=0;
        for(int i=0;i<arr.length;i++){
            int j = i + 1;
            int k=arr.length - 1;

            while (j<k){
                int val =arr[i]+arr[j]+arr[k];
                if(min > Math.abs(val - number)){
                    min = Math.abs(val - number);
                    closestSum =val;
                }

                if(val > number){
                    k--;
                }else if(val < number){
                    j++;
                }else {
                    System.out.println(val);
                    return;
                }

            }
        }
        System.out.println(closestSum);

    }

    public static void maxArea(){
        int[] arr ={6, 2, 5, 4, 5, 1, 6};

        int left =0;
        int right = arr.length-1;
        int maxArea =Integer.MIN_VALUE;

        while(left < right){
            maxArea = Math.max(maxArea,(right - left) * Math.min(arr[left],arr[right]));

            if(arr[left] <arr[right]){
                left++;
            }else {
                right--;
            }
        }
        System.out.println("MaxArea = "+maxArea);

    }
    public static void solution() {
        int[] A = {-1,-3};
        int smallest =1;
        Arrays.sort(A);
        for(int i=0 ;i<A.length ;i++){
            if(A[i]<=0){
                continue;
            }

            if(A[i]==smallest){
                smallest = smallest +1;
            }
        }
        System.out.println(smallest);
    }
    //************************************************************************************
    //*************************** duplicates**********************************************

    public static void removeDuplicates(){

        int arr[] ={1, 1, 2, 2, 2, 3, 4, 5, 5, 6 };
        int j=1;
        for(int i =1 ;i< arr.length ;i++){
            if(arr[i] != arr[i-1]){
                arr[j] = arr[i];
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
    public static void moveZeros(){
        int arr[] = {0, 1, 0, 3, 12};
        int i = 0;
        int j = 0;

        while(j<arr.length){
            if(arr[j]!=0){
                arr[i] = arr[j];
                i++;
            }
            j++;
        }

        while(i<arr.length){
            arr[i]=0;
            i++;
        }
        System.out.println(Arrays.toString(arr));

    }

    static int findSubsequenceCount()
    {
        String S = "banana";
        String T = "ban";
        int m = T.length();
        int n = S.length();

        // T can't appear as a subsequence in S
        if (m > n)
            return 0;

        // mat[i][j] stores the count of
        // occurrences of T(1..i) in S(1..j).
        int mat[][] = new int[m + 1][n + 1];

        // Initializing first column with
        // all 0s. An emptystring can't have
        // another string as suhsequence
        for (int i = 1; i <= m; i++)
            mat[i][0] = 0;

        // Initializing first row with all 1s.
        // An empty string is subsequence of all.
        for (int j = 0; j <= n; j++)
            mat[0][j] = 1;

        for (int c = 0; c <= m; c++) {
            for (int d = 0; d <= n; d++) {
                System.out.print(mat[c][d] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");

        // Fill mat[][] in bottom up manner
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If last characters don't match,
                // then value is same as the value
                // without last character in S.
                if (T.charAt(i - 1) != S.charAt(j - 1))
                    mat[i][j] = mat[i][j - 1];

                    // Else value is obtained considering two cases.
                    // a) All substrings without last character in S
                    // b) All substrings without last characters in
                    // both.
                else
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
            }
            for (int k = 0; k <= m; k++) {
                for (int o = 0; o <= n; o++) {
                    System.out.print(mat[k][o] + " ");
                }
                System.out.println();
            }
            System.out.println("\n");
        }

        /* uncomment this to print matrix mat
        for (int i = 1; i <= m; i++, cout << endl)
            for (int j = 1; j <= n; j++)
                System.out.println ( mat[i][j] +" "); */
        System.out.println( mat[m][n]);
        return mat[m][n];
    }

    //WeightedJobSchedulingMaximumProfit\
    class Job implements Comparable<Job>{
        int start;
        int end;
        int profit;
        Job(int start,int end,int profit){
            this.start =start;
            this.end =end;
            this.profit =profit;
        }

        @Override
        public int compareTo(Job o) {
           return this.end - o.end;
        }
        @Override
        public String toString(){
            return "{"+start+" "+end+" "+profit+"}";
        }
    }

     void weightedJobSchedulingMaximumProfit(){
        Job[] jobArray =new Job[4];
         jobArray[0] =new Job(3, 10, 20);
         jobArray[1] =new Job(1, 2, 50);
         jobArray[2] =new Job(6, 19, 100);
         jobArray[3] =new Job(2, 100, 200);
        Arrays.sort(jobArray);
        int[] dpSol = new int[jobArray.length];
         dpSol[0]=jobArray[0].profit;
         System.out.println(Arrays.toString(jobArray));
         for(int i=1;i<jobArray.length;i++){
             int max =Integer.MIN_VALUE;
             for(int j=0;j<i;j++){
                 if(jobArray[j].end <= jobArray[i].start){
                     dpSol[i] = Math.max(dpSol[i],jobArray[i].profit+ dpSol[j]);

                 }
             }


         }
         System.out.println(Arrays.toString(dpSol));

         /*int T[] = new int[jobArray.length];
         Arrays.sort(jobArray);

         T[0] = jobArray[0].profit;
         for(int i=1; i < jobArray.length; i++){
             //T[i] = Math.max(jobArray[i].profit, T[i-1]);
             for(int j=i-1; j >=0; j--){
                 if(jobArray[j].end <= jobArray[i].start){
                     T[i] = Math.max(T[i], jobArray[i].profit + T[j]);
                     break;
                 }
             }
         }

         System.out.println(Arrays.toString(T));*/



    }


    public static void main(String[] args) {
         System.out.print("checktryCatch" +checkTryCatch() );
        ////Sum of the  3 elements in an accending array

        check3ElementSumInArray();
        fourSum();
        threeSumClosest();
        removeDuplicates();
        moveZeros();
        maxArea();
        solution();
        findSubsequenceCount();
        findNumberInRightRotatedArray();
        String s="";

        int num = 1234, reversed = 0;
        Map<Character,String> gfg = new HashMap<Character,String>();
        for (String str:gfg.values()) {

        }

        while(num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        System.out.println(reversed);

        ArrayInterviewQuestion arrayInterviewQuestion = new ArrayInterviewQuestion();
        arrayInterviewQuestion.weightedJobSchedulingMaximumProfit();
        System.out.println("****************************************");
        System.out.println(kthMostFrequentChar("aabcd",2));
        int numb = minimumNumber();
        System.out.println(numb);
    }

    private static void findNumberInRightRotatedArray() {
         int num =5;
         int arr[] ={7,8,9,11,12,3,4,5};
         int left =0;
         int right =arr.length - 1;
         int start=0;
         int last = arr.length - 1;


         while (left <= right){
             int mid = (left + right)/2;
             if (arr[mid]==num){
                 System.out.println("position is ="+(mid+1));
                 return;
             }

             if(arr[left] < arr[mid]){
                 if(arr[left] <= num  && num < arr[mid] ){
                     right = mid -1;
                 }else{
                     left =mid + 1;
                 }
             }else{
                 if(arr[mid]<num && num <=arr[right]){
                     left =mid+1;
                 }else{
                     right =mid-1;
                 }
             }

         }

        System.out.println("position is ="+-1);


    }

    public static String checkTryCatch(){
         try{
             return "try";

         }catch (Exception e){

         }finally {
             return "finaly";
         }

    }

    private static String kthMostFrequentChar(String S, int K) {

        Map<Integer, Long> counts = S.chars()
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
         counts.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
         System.out.println(counts);
         Long val1 = counts.get(counts.keySet().toArray()[0]);
         counts.remove(counts.keySet().toArray()[0]);
        for (Integer i:counts.keySet()){
             Long val =counts.get(i);
             if(val1 != val){
                 K--;
             }
            val1=val;
             if(K==1){
                 return Character.toString((char)i.intValue());
             }



            
        }

         return "-1";


    }

    private static int minimumNumber(){
        int number = 12045;
        int n = 10;
        int min = number;
        int temp = number;
        while(temp != 0){
            int tempo = number;
            int currentNumber = 0;
            if(n == 10){
                currentNumber = tempo/10;
                if(currentNumber < min){
                    min = currentNumber;
                }
            }
            else{
                currentNumber = (tempo/n) * 10 + (tempo % (n/10));
                System.out.println("Current Number : " + currentNumber);
                if(currentNumber < min){
                    min = currentNumber;
                }
            }
            System.out.println("Min : " + min + " iteration : " + n + " temp : " + temp);
            n = n * 10;
            temp = temp/10;
        }
        System.out.println("Minimum number - " + min);

        return min;
    }



}
