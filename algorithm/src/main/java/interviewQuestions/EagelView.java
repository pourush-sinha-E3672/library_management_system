package interviewQuestions;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by pourush.sinha on 13/02/20.
 */
public class EagelView {

    public static String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }

    public static void main(String[] args) {
        System.out.println("soulution"+ Arrays.toString(solution(3,2)));
        //int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int[] arr ={2 ,-2,3,0,4,-7};
        int n = arr.length;
       // System.out.print(findTotalNumberOfSubArrays(arr, n));
        /*//ArrayList<Pair> out = findSubArrays(arr, n);

        // if we did not find any subarray with 0 sum,
        // then subarray does not exists
        if (out.size() == 0)
            System.out.println("No subarray exists");
        else
            print(out);*/

        int[] arr1 = new int[]{2, -2, 3, 0, 4 ,-7};
        System.out.println(getCount(arr, 0, arr.length-1));

        System.out.println(getShifted("as",9,11));
    }


    static Long findTotalNumberOfSubArrays(int[] arr, int n)
    {
        // create an empty map
        Long size = 0L;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        // create an empty vector of pairs to store
        // subarray starting and ending index
        ArrayList<Pair> out = new ArrayList<>();

        // Maintains sum of elements so far
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            // add current element to sum
            sum += arr[i];

            // if sum is 0, we found a subarray starting
            // from index 0 and ending at index i
            if (sum == 0)
                size++;
                //out.add(new Pair(0, i));
            ArrayList<Integer> al = new ArrayList<>();

            // If sum already exists in the map there exists
            // at-least one subarray ending at index i with
            // 0 sum
            if (map.containsKey(sum))
            {
                // map[sum] stores starting index of all subarrays
                al = map.get(sum);
                for (int it = 0; it < al.size(); it++)
                {
                    size++;
                    //out.add(new Pair(al.get(it) + 1, i));
                }
            }
            al.add(i);
            map.put(sum, al);
        }

        return size >1000000000 ? -1 : size;
    }

    // Utility function to print all subarrays with sum 0
    static void print(ArrayList<Pair> out)
    {
        for (int i = 0; i < out.size(); i++)
        {
            Pair p = out.get(i);
            System.out.println("Subarray found from Index "
                    + p.getKey() + " to " + p.getValue());
        }
    }


    static Long findTotalNumberOfSubArrays(int[] A)
    {

        Long size = 0L;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++)
        {
            sum += A[i];
            if (sum == 0)
                size++;
            if(size >1000000000){
                return -1L;
            }



        ArrayList<Integer> al = new ArrayList<>();
        if (map.containsKey(sum))
        {
            al = map.get(sum);
            for (int it = 0; it < al.size(); it++)
            {
                size++;
                if(size >1000000000){
                    return -1L;
                }
            }
        }
        al.add(i);
        map.put(sum, al);
    }

        return size;
}

    public static int getCount(int[] arr, int left, int right){
        if(left ==right){
            if(arr[left]==0){
                return 1;
            }else{
                return 0;
            }

        }
        int mid = (left + right) / 2;
        int sum = checkSum(arr, left, mid,right);
        int leftSum = getCount(arr, left, mid);
        int rightSum = getCount(arr, mid+1, right);

        return sum + leftSum +  rightSum;
    }

    public static int checkSum(int[] arr, int left,int mid,  int right) {
        /*int sum = 0;
        for (int i = left; i <= right; i++) sum += arr[i];
        return sum == 0 ? 1 : 0;*/
        int count=0;
        int leftSum=0;
        int rightSum =0;
        int leftEnd =mid;
        int rightbeg =mid+1;
        while(leftEnd>=left || rightbeg<right){
            if(leftEnd>=left) {
                leftSum = +arr[leftEnd];
            }

            if(rightbeg<right) {
                rightSum = +arr[rightbeg];
            }

            if((leftSum+rightSum)==0){
                count++;
            }
            leftEnd--;
            rightbeg++;

        }
        return count;
    }


    static String leftrotate(String str, int d)
    {
        if(str.length() > d){
            d = d;
        }else{
            d = d % str.length();
        }
        if(d==0){
            return str;
        }
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    // function that rotates s towards right by d
    static String rightrotate(String str, int d)
    {
        if(str.length() > d){
            d = d;
        }else{
            d = d % str.length();
        }
        if(d==0){
            return str;
        }
        return leftrotate(str, str.length() - d);
    }

    public static String getShifted(String s, int leftShift,int rightShift){
        s = leftrotate(s,leftShift);
        s = rightrotate(s,rightShift);
        return s;
    }





}
