package utility;

/**
 * Created by pourush.sinha on 30/05/19.
 */
public class MainClass {
    static long repeatedString(String s, long n) {

        int numberOfAs=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                numberOfAs++;
            }

        }
        if (numberOfAs==0){
            return 0;
        }

        long numberOfAsInString = (n/s.length()) * numberOfAs;
        long  leftString = n % s.length();

        for(int i =0 ;i<leftString ;i++){
            if(s.charAt(i)=='a'){
                numberOfAsInString++;
            }
        }

        return    numberOfAsInString;

    }

    static int[] rotLeft(int[] a, int d) {
        int shifts;
        if(a.length > d){
            shifts = d;
        }else{
            shifts = d % a.length;
        }
        if(shifts==0){
            return a;
        }

        int[] arr =new int[shifts];
        for(int i=0; i< shifts ;i++){
            arr[i] = a[i];
        }

        for(int i=shifts ,j=0 ;i<a.length;i++,j++){
            a[j] = a[i];
        }

        for(int i=(a.length - shifts),j=0 ;i<a.length;i++,j++){
            a[i] = arr[j];
        }
        return a;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        CommonUtils.printArray(rotLeft(arr,4));
    }

}
