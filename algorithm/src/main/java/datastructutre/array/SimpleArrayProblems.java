package datastructutre.array;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 24/07/18.
 */
public class SimpleArrayProblems {
//Print all  integers in  in reverse order as a single line of space-separated integers.
//1 4 3 2  -->   2 3 4 1
    static int[] reverseArray(int[] a) {

        int i=0;
        int n = a.length - 1;
        while(i < n){
            int temp ;
            temp = a[i];
            a[i] = a[n];
            a[n] = temp;
            i++;
            n--;
        }
        return a;

    }

//another approach https://www.hackerrank.com/rest/contests/master/challenges/2d-array/hackers/NKSkr/download_solution
    static int hourglassSum(int[][] arr) {
        Integer output=null;

        for (int row =0 ; row < arr.length ; row ++ ){
            for(int col=0 ; col <arr[row].length ; col ++){
                if (((row + 2) < arr.length) && ((col + 2) < arr[row+1].length)) {
                    Integer sum = sum(row, col, arr);
                    System.out.println(sum);
                    System.out.println("=========================");
                    output =Math.max(sum,output);
                    if(output==null){
                        output = sum;
                    }
                    if (sum > output){
                        output = sum;
                    }
                }





            }
        }
        return output;
    }

    static Integer sum( int i ,int j ,int[][] arr){
        Integer sum = 0;
        int k = j + 1;
        int height =0;
            for(int row =i; row <i + 3 ; row++){
                for(int col=j ; col< j+3 ;col++){
                    if((height % 2)==0) {
                        System.out.print("arr["+row+"]["+col+"] = "+arr[row][col]+" ");
                        sum = sum + arr[row][col];
                    }else{
                        if(col == k) {
                            System.out.print("arr["+row+"]["+col+"] = "+arr[row][col]+" ");
                            sum = sum + arr[row][k];
                        }
                    }
                }
                System.out.println();
                height = height + 1;
            }
     return sum;
    }



    public static void main(String[] args) {

        int arr[][] ={{1, 1 ,1 ,0 ,0 ,0},
                      {0 ,1 ,0 ,0 ,0 ,0},
                      {1 ,1 ,1 ,0 ,0 ,0},
                      {0 ,0 ,2 ,4 ,4 ,0},
                      {0 ,0 ,0 ,2 ,0 ,0},
                      {0 ,0 ,1 ,2 ,4 ,0}};
        int arr2[][] =  {{0 ,-4 ,-6 ,0 ,-7 ,-6},
                         {-1 ,-2 ,-6 ,-8 ,-3 ,-1},
                         {-8 ,-4 ,-2 ,-8 ,-8 ,-6},
                         {-3 ,-1 ,-2 ,-5 ,-7 ,-4},
                         {-3 ,-5 ,-3 ,-6 ,-6 ,-6},
                         {-3 ,-6 ,0 ,-8 ,-6 ,-7}};
        print2D(arr2);
        int sum =hourglassSum(arr2);
        System.out.println("max =="+sum+" length=="+arr.length+" height =="+arr[0].length);
        /*System.out.println(1 % 2);
        int[] a = {1,2,3,4};
        System.out.println("before "+ Arrays.toString(a));
        a =reverseArray(a);
        System.out.println("after "+Arrays.toString(a));*/


    }

    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat) {

            // Loop through all columns of current row
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }


    }
}
