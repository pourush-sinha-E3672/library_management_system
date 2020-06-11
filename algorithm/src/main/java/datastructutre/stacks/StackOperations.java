package datastructutre.stacks;

import java.util.Stack;

/**
 * Created by pourush.sinha on 17/12/19.
 */
public class StackOperations {

    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;

    public StackOperations(){
     stack = new  Stack<Integer>();
     minStack = new  Stack<Integer>();

    }

    public Integer peek(){
        return stack.peek();
    }

    public void push(Integer val){

        if (minStack.isEmpty()){
            minStack.push(val);
        }else{
            if (minStack.peek() >= val){
                minStack.push(val);
            }
        }

        stack.push(val);
    }

    public Integer pop(){
        if(stack.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        if(minStack.peek() == stack.peek()){
            minStack.pop();
        }
        return stack.pop();
    }

    public Integer getMin(){
        if(stack.isEmpty()){
            throw new RuntimeException("Stack is Empty");
        }
        return minStack.peek();
    }


    public static void main(String[] args) {
        StackOperations stackOperations = new StackOperations();
        stackOperations.push(10);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(20);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(30);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(40);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(40);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(5);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(5);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(5);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(5);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(5);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(5);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.pop();
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());
        stackOperations.push(8);
        System.out.println(stackOperations.minStack);
        System.out.println(stackOperations.peek());

    }


}
