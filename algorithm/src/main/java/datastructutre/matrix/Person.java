package datastructutre.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pourush.sinha on 22/04/17.
 */
public class Person {

    public static ArrayList<Integer> printSpiral(final List<ArrayList<Integer>> A){
        System.out.println(A);
        ArrayList<Integer> array = new ArrayList<Integer>();
        int l =0;
        int t =0;
        int r =0;
        int[] numArray = new int[4];

        int b = A.size() - 1;
        int dir=0;

        while (l <= r && t <= b){
            if (dir==0){
                for(int i=l; i<=r; i++){
                    System.out.println(A.get(t).get(i));
                    array.add(A.get(t).get(i));
                }
                dir=1;
                t++;
            }else if (dir==1){
                for(int i=t; i<=b; i++){
                    System.out.println(A.get(i).get(r));
                    array.add(A.get(i).get(r));
                }
                dir=2;
                r--;
            }else if (dir==2){
                for(int i=r; i>=l; i--){
                    System.out.println(A.get(b).get(i));
                    array.add(A.get(i).get(r));
                }
                dir=3;
                b--;
            }else if (dir==3){
                for(int i=b; i>=t; i--){
                    System.out.println(A.get(i).get(b));
                    array.add(A.get(i).get(r));
                }
                dir=0;
                l++;
            }
        }
        return array;
    }

    public void  speak(){
        System.out.println("hi i am person");
    }
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();


        mul(0,0,A.size(),A.get(0).size(),A);

        return result;
    }

    public static void  mul(int i, int j ,int m ,int n,List<ArrayList<Integer>> A){
        int k=j;
        int p=i;
        while(k< m){
            System.out.println(A.get(p).get(k));
            k++;
        }
        k--;
        p=i;
        while(p < n){
            System.out.println(A.get(p).get(k));
            p++;
        }
        p--;
        while(k >= j){
            System.out.println(A.get(p).get(k));
            k--;
        }
        k++;
        while(p >= (i - 1)){
            System.out.println(A.get(p).get(k));
            p--;
        }
        p++;
        mul(i+1,j+1,m-1,n-1 ,A);

    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        ArrayList<Integer> list4 = new ArrayList<Integer>();
        list4.add(10);
        list4.add(11);
        list4.add(12);

        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(list1);
        A.add(list2);
        A.add(list3);
        A.add(list4);

        printSpiral(A);
    }
}




