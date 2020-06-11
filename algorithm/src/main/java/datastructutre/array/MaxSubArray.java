package datastructutre.array;

/**
 * Created by pourush.sinha on 20/05/19.
 */
public class MaxSubArray {

    int maxCrossingSubArray(int[] arr ,int l ,int m ,int h){

        int sum=0;
        int lmax =Integer.MIN_VALUE;

        for(int i=m;i>=l;i--){
            sum = sum + arr[i];
            if(sum >lmax){
                lmax = sum;
            }
        }
        sum=0;
        int rmax =Integer.MIN_VALUE;
        for(int i=m;i<=h;i++){
            sum = sum + arr[i];
            if(sum >rmax){
                rmax = sum;
            }
        }
         return  lmax + rmax;
    }


    int maxSubArray(int[] arr ,int start ,int last){

        if(start ==last){
            return arr[start];
        }


        int mid = (start + last) / 2;
        return Math.max(Math.max(maxSubArray(arr,start,mid),maxSubArray(arr,mid+1,last)),maxCrossingSubArray(arr,start,mid,last));


    }


}
