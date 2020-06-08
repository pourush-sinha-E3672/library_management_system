package interviewQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by pourush.sinha on 27/08/19.
 */
public class StackInterviewQuestions {


    public  static void  nearestMaxNumber(int[] arr){

      Map<Character,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for(int i=1 ;i<arr.length ;i++){
            if(stack.peek() > arr[i]){
                stack.push(arr[i]);
            }else{
                while(!stack.isEmpty()  ){
                    if(stack.peek()> arr[i]) {
                        stack.push(arr[i]);
                        break;
                    }
                    System.out.print(arr[i]+" ");
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] result = new int[arr.length];
        int resultIndex = 0;
        Stack<Integer> stack = new Stack<>();
        // iterate for rest of the elements
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }
            else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr ={4, 5, 2, 25};
        //nearestMaxNumber(arr);
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
    }
}
