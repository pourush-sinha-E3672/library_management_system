package datastructutre.array;

import java.util.Arrays;

/**
 * Created by pourush.sinha on 08/06/19.
 */
public class Sorts {

    static int partion(int i,int j,int[] arr){
        int pivot = arr[j];
        int pivotIndex =j;

        while (i<j){
             while(arr[i] <= pivot && i < j){
                 i++;
             }

             while(arr[j] > pivot && i < j){
                 j--;
             }
            int temp =arr[i];
            arr[i] =arr[j];
            arr[j] =temp;
        }
        int temp = arr[j];
        arr[j] = arr[pivotIndex];
        arr[pivotIndex] =temp;
        return j;
    }


    static void quickSort(int i,int j,int[] arr){
        int partotion =partion(i,j,arr);
        if( !(partotion>=j)) {
            quickSort(partotion + 1, j, arr);
        }
        if(!(partotion<=i)) {
            quickSort(i, partotion - 1, arr);
        }
    }

    public static void main(String[] args) {
        //int[] arr ={2,6,9,1,3,11};
        int[] arr ={2};
        System.out.println(Arrays.toString(arr));
        quickSort(0,arr.length -1,arr);
        System.out.println(Arrays.toString(arr));
    }
}
