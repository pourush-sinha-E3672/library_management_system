import java.io.*;
import java.util.*;


public class Child {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String str = br.readLine();

        int out_ = string_minimization(str);
        System.out.println(out_);

        wr.close();
        br.close();
    }
    static int string_minimization(String str){
        // Write your code here
        int length = str.length();

        int mid =length/2;
        String firstHalf = str.substring(0,mid);
        String secondHalf = str.substring(mid,str.length());
        System.out.println(str);
        System.out.println(firstHalf+"  "+secondHalf);
        System.out.println(secondHalf+firstHalf);
        int i =secondHalf.length() -1;
        int j =0;
        while(true){
            Character cahrfirst =secondHalf.charAt(i);
            Character cahrLast =firstHalf.charAt(j);
            if (cahrfirst.equals(cahrLast) ){

                while (secondHalf.charAt(i)==secondHalf.charAt(i-1)){
                    i--;

                }
                i--;
                while (firstHalf.charAt(j)==firstHalf.charAt(j+1)){
                    j++;

                }
                j++;


            }else{
                System.out.println(secondHalf.substring(0,i+1)+firstHalf.substring(j,secondHalf.length()));
                return (secondHalf.substring(0,i+1)+firstHalf.substring(j,secondHalf.length())).length();
            }
        }

    }
}