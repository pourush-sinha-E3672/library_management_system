package datastructutre.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by pourush.sinha on 08/06/19.
 */
public class BinarySerarchRealtedProblem {

    static int searchInitialAndFinalIndex(int[] arr ,int n){

        int l=0;
        int r = arr.length -1;
        Integer initial =null;
        Integer end =null;

        while(l<=r){
            int mid = (l+r)/2;

            if( (arr[mid]==n && mid==0) || arr[mid]==n && arr[mid-1] < n){
                //return mid;
                initial = mid;
                break;
            }else if(arr[mid]>=n){
                r = mid -1;

            }else if(arr[mid]<n){
                l=mid+1;
            }

        }
         l=0;
         r =arr.length -1;

        while(l<=r){
            int mid = (l+r)/2;

            if( (arr[mid]==n && mid==arr.length -1) || (arr[mid]==n && arr[mid+1] > n)){
                end = mid;
                break;
            }else if(arr[mid]>n){
                r = mid -1;
            }else if(arr[mid]<=n){
                l=mid+1;
            }

        }
        System.out.println("initial =" +initial+" end =" +end);
        return (((end - initial )+1) *n);

    }

    public static void main(String[] args) {
        int[] arr = {2,4,4,4,4,6,8,13,20};
        System.out.println(Arrays.toString(arr));
        System.out.println("index = "+ searchInitialAndFinalIndex(arr,4));

        int[] arr1= {2,4,6,8,13,20};
        System.out.println(Arrays.toString(arr1));
        System.out.println("index = "+ searchInitialAndFinalIndex(arr1,4));
        int[]arr2 = {4,4,4,4,4,4,4,4,4};
        System.out.println(Arrays.toString(arr2));
        System.out.println("index = "+ searchInitialAndFinalIndex(arr2,4));

        int[] arr3 = {4};
        System.out.println(Arrays.toString(arr3));
        System.out.println("index = "+ searchInitialAndFinalIndex(arr3,4));

        int[] arr4 = {1,2,2,2,4,4,5,5,6};
        System.out.println(Arrays.toString(arr4));
        System.out.println("index = "+ searchInitialAndFinalIndex(arr4,2));


    }
}
