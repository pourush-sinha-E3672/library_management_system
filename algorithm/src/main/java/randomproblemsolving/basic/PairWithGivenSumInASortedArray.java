package randomproblemsolving.basic;


import com.google.common.collect.Lists;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Created by pourush.sinha on 15/12/18.
 */
public class PairWithGivenSumInASortedArray {
    /*
    * You are given an array A of size N. You need to find all pairs in the array that sum
    * to a number K. If no such pair exists then output will be -1. The elements of the array
    * are distinct and are in sorted order.
       Note: (a,b) and (b,a) are considered same. Also, an element cannot pair with itself,
       i.e., (a,a) is invalid.

    Input:
    The first line of input is T denoting the number of testcase. T testcases follow. Each testcase
     contains three lines of input. The first line is the size of array N. The second line contains N
     elements separated by spaces. The third line contains the sum K.

    Output:
    For each testcase, print all the pairs such that there sum is equal to K.

    Constraints:
      1 <= T <= 100
      0 <= Ai <=107
      2 <= N <= 107
      0 <= K <= 107

    Examples:
     Input:
      2
      7
      1 2 3 4 5 6 7
      98
      7
      1 2 3 4 5 6 7
      8
     Output:
      -1
      1 7 8
      2 6 8
      3 5 8

   Explanation:
    Testcase1: We cannot find any pair that sums to 98
    Testcase2: We find 3 such pairs that sum to 8 (1,7) (2,6) (3,5)
    */

    public static void printNumberOfPairs(int[] arr ,int value){
        List<Integer> arr1 = Lists.newArrayList();
         Boolean check = false;

        for (int i = 0; i<arr.length ; i++){
            int val = value  - arr[i];
            if(arr1.contains(arr[i])){
                System.out.println(arr[i] +"  "+ val );
                check =true;
            }
            arr1.add(val);

        }

        if (!check){
            System.out.println(-1);
        }

    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String numberOfTestCaseString = inputReader.nextLine();

        Integer numberOfTestCase = Integer.parseInt(numberOfTestCaseString);

        for (int i = 0 ; i < numberOfTestCase ; i++){
            for (int j = 0 ; j < 3 ; j++){
                Integer sizeOfTheArray = Integer.parseInt(inputReader.nextLine());
                int[] array = convert(inputReader.nextLine());
                int sum = Integer.parseInt(inputReader.nextLine());
                printNumberOfPairs(array ,sum);
            }

        }




    }

    static int[] convert(String x){
        String[] val = x.split(" ");
        int[] arr = new int[val.length];
        for (int i = 0; i < val.length; ++i){
            arr[i] = Integer.parseInt(val[i]);
        }
        return arr;
    }
}
