package dynamicprograming;

/**
 * Created by pourush.sinha on 06/06/19.
 */
public class MaxArray {

    static int maxSum(int[] arr){


        if(arr.length ==1){
            return arr[0];
        }

        if(arr.length ==2){
            return Math.max(arr[0] ,arr[1]);
        }
        int[] dpArr =new int[arr.length];
        dpArr[0]=arr[0];
        dpArr[1]=Math.max(arr[0] ,arr[1]);

        for(int i=2 ;i<arr.length ;i++){
            dpArr[i] = Math.max(Math.max(arr[i] +dpArr[i-2],arr[i]),dpArr[i-1]);
        }

        return dpArr[arr.length -1];
    }

    public static void main(String[] args) {
        int[] arr ={3,7,4,6,5};
       // int[] arr ={-2,1,3,-4,5};
        System.out.println("sum  = "+maxSum(arr));
    }
}
