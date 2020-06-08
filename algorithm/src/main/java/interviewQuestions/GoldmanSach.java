package interviewQuestions;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pourush.sinha on 04/07/19.
 */
public class GoldmanSach {
    public static String  collapseString(String inputString){
        if(StringUtils.isEmpty(inputString)){
            return "";
        }

        if(inputString.length()==1){
            return "1"+inputString;
        }

        int i =1;
        String str ="";
        int count=1;
         while(i<inputString.length()){
             if(inputString.charAt(i-1) == inputString.charAt(i)){
                 count++;
             }else{
                 str= str + count+inputString.charAt(i-1);
                 count=1;
             }
             i++;
         }
         if(inputString.charAt(inputString.length()-1)==inputString.charAt(inputString.length()-2)){
             str=str+count+inputString.charAt(inputString.length()-1);
         }else{
             str=str+"1"+inputString.charAt(inputString.length()-1);
         }

         return str;

    }

    static void printLeast(String arr)
    {
        // min_avail represents the minimum number which is
        // still available for inserting in the output vector.
        // pos_of_I keeps track of the most recent index
        // where 'I' was encountered w.r.t the output vector
        int min_avail = 1, pos_of_I = 0;

        //vector to store the output
        List<Integer> al = new ArrayList<>();

        // cover the base cases
        if (arr.charAt(0) == 'I')
        {
            al.add(1);
            al.add(2);
            min_avail = 3;
            pos_of_I = 1;
        }

        else
        {
            al.add(2);
            al.add(1);
            min_avail = 3;
            pos_of_I = 0;
        }

        // Traverse rest of the input
        for (int i = 1; i < arr.length(); i++)
        {
            if (arr.charAt(i) == 'I')
            {
                al.add(min_avail);
                min_avail++;
                pos_of_I = i + 1;
            }
            else
            {
                al.add(al.get(i));
                for (int j = pos_of_I; j <= i; j++)
                    al.set(j, al.get(j) + 1);

                min_avail++;
            }
        }

        // print the number
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
        System.out.println();
    }

    static int findPossibleSmallestNumberMatchingPattern(String pattern) {
        if(pattern.equals('M')){
            return 21;
        }else if(pattern.equals('N')){
            return 12;
        }else if(pattern ==null || pattern.isEmpty()){
            return -1;
        }

        int maxValue;
        int maxVlaueAt;

        List<Integer> list = new ArrayList<>();

        if(pattern.charAt(0)=='N'){
            list.add(1);
            list.add(2);
            maxValue=3;
            maxVlaueAt=1;
        }else if(pattern.charAt(0)=='M'){
            list.add(2);
            list.add(1);
            maxValue=3;
            maxVlaueAt=0;
        }else{
            return -1;
        }

        for(int i=1;i<pattern.length() ;i++){
            if(!(pattern.charAt(i) == 'M' ||pattern.charAt(i) == 'N')){
                return -1;
            }
            if(pattern.charAt(i) == 'N'){
                list.add(maxValue);
                maxValue++;
                maxVlaueAt=list.size() -1;
            }else{
                list.add(list.get(list.size()-1));
                for(int j=maxVlaueAt;j<=i;j++){
                    list.set(j, list.get(j) + 1);
                }

                maxValue++;
            }
        }
        String str ="";
        for(int k=0;k<list.size();k++){
            str=str+ list.get(k);
        }

        return Integer.parseInt(str);


    }

    public static void main(String[] args) {
        String inputString = "";
        //System.out.println(collapseString(inputString));
       // printLeast("IDID");
        System.out.println(findPossibleSmallestNumberMatchingPattern("MNM"));
    }
}
