package interviewQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pourush.sinha on 12/01/20.
 */

/*
* Given two strings str1 and str2. The task is to find the minimum number of characters to be replaced by $ in string str1 such that str1 does not contain string str2 as any substring.

Examples:

Input: str1 = "intellect", str2 = "tell"
Output: 1
4th character of string "str1" can be replaced by $
such that "int$llect" it does not contain "tell"
as a substring.

Input: str1 = "google", str2 = "apple"
Output: 0*/
public class SubSequenceProblem {
    static int getCount(String A, String B)
    {

        int n = A.length(), m = B.length();
        int count = 0, i, j;

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < m; j++)
            {

                if(i + j >= n)
                    break;
                else if (A.charAt(i + j) != B.charAt(j))
                    break;
            }

            if (j == m)
            {
                count++;

            }
        }

        return count;
    }

    static String removeChar(String A, String B)
    {

        int n = A.length(), m = B.length();
        StringBuilder sb = new StringBuilder(A);
        int count = 0, i, j;

        for (i = 0; i < n; i++)
        {
            for (j = 0; j < m; j++)
            {

                if(i + j >= n)
                    break;
                else if (sb.charAt(i + j) != B.charAt(j))
                    break;
            }

            if (j == m)
            {
                sb.deleteCharAt(i);
                return  sb.toString();

            }
        }
        return  sb.toString();

    }

    // Driver Code
    public static void main(String args[])
    {
       /* String str1 = "aaaa";
        String str2 = "aa";*/
        List<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberOfTestCases = null;                // Reading input from STDIN
        try {
            numberOfTestCases = br.readLine();
            Integer i= Integer.parseInt(numberOfTestCases);
            for(int j=0;j<i;j++){
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                int thereshold=Integer.parseInt(br1.readLine());
                String str1=br1.readLine();
                String str2=br1.readLine();
                System.out.println(compute(str1,str2,thereshold));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("Hi, " + name + ".");


        /*int thereshold=1;
        System.out.println(getCount(str1 , str2));
        while (getCount(str1 , str2) >thereshold){
            System.out.println(getCount(str1 , str2));
            str1 = removeChar(str1 , str2);
            System.out.println("After triming "+str1);
        }*/


    }

    static int compute(String str1,String str2,int thereshold){
        int count=0;
        while (getCount(str1 , str2) >thereshold){
            count++;
            //System.out.println(getCount(str1 , str2));
            str1 = removeChar(str1 , str2);
        }
        if(count==0){
            return -1;
        }
        return count;
    }
}
