package dynamicprograming;

import java.util.ArrayList;

/**
 * Created by pourush.sinha on 06/06/19.
 */
public class Abbreviation {

    static String abbreviation(String a, String b){
        int i =0;
        int j =0;


        while(i< a.length() && j< b.length()){
            char aChar = a.charAt(i);
            char bChar =b.charAt(j);
            if(aChar == bChar || bChar == Character.toUpperCase(aChar)){
                i++;
                j++;
            }else{
                i++;
            }

            if(j ==b.length()){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        String a ="beFgH";
        String b ="EFG";
        System.out.println("Value = "+abbreviation(a,b));
    }
}
