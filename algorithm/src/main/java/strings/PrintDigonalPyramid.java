package strings;

/**
 * Created by pourush.sinha on 07/06/19.
 */
public class PrintDigonalPyramid {

    static void staircase(int n){
        String str="";
        String str1="";
        for(int i=0;i<n;i++){
            str = str+"*";
            str1 = str1 + " ";
        }
        for(int i =0;i<n;i++){
            System.out.println(str1.substring(i,n-1) + str.substring(0,i+1));
        }
    }


    public static void main(String[] args) {
        staircase(18);
    }



}
