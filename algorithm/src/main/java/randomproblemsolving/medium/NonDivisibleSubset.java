package randomproblemsolving.medium;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by pourush.sinha on 29/12/18.
 */

/*
* Given a set of distinct integers, print the size of a maximal
* subset of  where the sum of any  numbers in  is not evenly divisible by .

For example, the array  and . One of the arrays that can be created is .
Another is . After testing all permutations, the maximum length solution array has  elements.

Function Description

Complete the nonDivisibleSubset function in the editor below. It should return an integer
representing the length of the longest subset of  meeting the criteria.

nonDivisibleSubset has the following parameter(s):

S: an array of integers
k: an intege
This initially appears difficult to solve in reasonable time complexity. After further thought,
 I think this can be done on O(n) with a few considerations. This is supposed to be an "easy" problem,
  so I'll provide some algorithm guidance here.

For any number K, the sum of 2 values (A & B) is evenly divisible by K if the sum of the remainders of
A/K + B/K is K. (There is also a special case where both A & B are evenly divisible, giving a sum of 0.)
https://www.youtube.com/watch?v=puX4Nf6itV4
*/
public class NonDivisibleSubset {

    private static int getNonDivisibleLongestSubset(int K, int[] arr){
        int f[] = new int[K];
        Arrays.fill(f, 0);

        // Fill frequency array with values modulo K
        for (int i = 0; i < arr.length; i++)
            f[arr[i] % K]++;

        // Initialize result by minimum of 1 or
        // count of numbers giving remainder 0
        //Initialize  the res to minumof 1 for f[0]... for less 1 f[0] should be 0
        //this is done because numbers with remainder 0 can be  with any number to make it non divvisible by k
        //[3,8,2]
        //[6,8,2]
        //[9,8,2]
        //all are same for k =3

        int res = Math.min(f[0], 1);

        // if K is even, then update f[K/2]
        //because K/2 is even the other half will be itself  K/2 only
        if (K % 2 == 0)
            f[K/2] = Math.min(f[K/2], 1);



        // Choose maximum of count of numbers
        // giving remainder i or K-i
        // travers till k/2 because other half will be travers [K-i]
        //Math.max(f[0], f[3])
        //Math.max(f[1], f[2])<<<<//both are same
        //Math.max(f[2], f[1])<<<<//both are same hence descarding this one
        for (int i = 1; i <= K/2; i++)
            res += Math.max(f[i], f[K-i]);

        return res;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        int[] S ={1,7,2,4};
        int k =3;
        /*int[] S ={19,10,12,10,24,25,22};
        int k =4;*/
        System.out.println("get teh subset "+getNonDivisibleLongestSubset(k,S));
    }

}
