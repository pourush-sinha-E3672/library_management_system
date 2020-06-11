package interviewQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pourush.sinha on 21/01/20.
 */
public class KredexInterview {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
*/
        //BufferedReader

        // String name = br.readLine();                // Reading input from STDIN
        // System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        // Scanner s = new Scanner(System.in);
        // String name = s.nextLine();                 // Reading input from STDIN
        /// System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        List<Integer> list =new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberOfTestCases =null;
        try{
            numberOfTestCases = br.readLine();
            Integer i =Integer.parseInt(numberOfTestCases);
            for(int j =0;j<i;j++){
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                int thereshold = Integer.parseInt(br1.readLine());
                String str1 =br1.readLine();
                String str2 =br1.readLine();
                list.add(compute(str1,str2,thereshold));

            }
        }catch(IOException e){
            e.printStackTrace();
        }

        for(Integer a:list){
            System.out.println(a);
        }
        // Write your code here

    }

    static int getCount(String A,String B){
        int n= A.length(), m= B.length();
        int count =0,i,j;
        for(i=0;i<n;i++){
            for(j=0; j<m ;j++){
                if(i+j>=n)
                    break;
                else if(A.charAt(i+j) !=B.charAt(j))
                    break;
            }
            if(j==m){
                count++;
            }
        }
        return count;
    }

    static String removeChar(String A,String B){
        int n= A.length(), m= B.length();
        StringBuilder sb = new StringBuilder(A);
        int count =0,i,j;
        for(i=0;i<n;i++){
            for(j=0; j<m ;j++){
                if(i+j>=n)
                    break;
                else if(A.charAt(i+j) !=B.charAt(j))
                    break;
            }
            if(j==m){
                sb.deleteCharAt(i);
                return sb.toString();
            }
        }
        return null;
    }
    static int compute(String str1,String str2,int thereshold){
        int count=0;
        while(getCount(str1,str2)>thereshold)
        {
            count++;
            str1=removeChar(str1,str2);
            if(str1==null){
                return -1;
            }

        }
        if(count==0){
            return -1;
        }

        return count;
    }
}


