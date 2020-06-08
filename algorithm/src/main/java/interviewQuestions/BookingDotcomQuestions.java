package interviewQuestions;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by pourush.sinha on 14/05/19.
 */
public class BookingDotcomQuestions {
    /*Given three integers that represent edge length,identify if they could form a traingle or not
    * A triangle could be formed if for any two edges ,the sum of their lengths is greater then the length of the remaning
    * edge
    * For edge length  that could form triangle ,identify if the triangle is equilateral.
    * A traningle is called equilateral if all the edges have equal lenght.
    *
    * */

    static int triangle(int a, int b ,int c){
        if ((a + b) <= c || (a + c) <= b || (c + b) <= a){
            return 0;
        }else if (a ==b &&  a==c){
            return 1;
        }else{
            return 2;
        }


    }

    /*
    *
    * Given a list of numbers, e.g.:

25626
25757
24367
24267
16
100
2
7277


Output a delta encoding for the sequence. In a delta encoding, the first element is r
eproduced as is. Each subsequent element is represented as the numeric difference from
 the element before it. E.g. for the sequence above, the delta encoding would be:

25626
131
-1390
-100
-24251
84
-98
7275

However, if a difference value does not fit in a single signed byte, i.e. -127 \le x \le 127, then,
instead of the difference, we would like to use an escape token, printing it.

This will denote that the value following the escape token is a full four-byte difference value,
rather than a one-byte different value.

For this exercise, we’ll declare -128 as the escape token.


*/
    public static List<Integer> delta_encode(List<Integer> numbers){
        List<Integer> encodedList = Lists.newArrayList();
        encodedList.add(numbers.get(0));
        for(int i=1;i<numbers.size();i++){
            int diff = numbers.get(i) - numbers.get(i - 1);
            if (diff <= -127 || diff >= 127){
                encodedList.add(-128);
            }
            encodedList.add(diff);

        }
        return encodedList;
    }

    public static void main(String[] args) {
        System.out.println("triangle out put "+triangle(3,5,4));
        List<Integer> normalList = Lists.newArrayList();
        normalList.add(25626);
        normalList.add(25757);
        normalList.add(24367);
        normalList.add(16);
        normalList.add(100);
        normalList.add(2);
        normalList.add(7277);





        System.out.println("input list" + Arrays.toString(normalList.toArray()));
        List<Integer> encodedList =delta_encode(normalList);
        System.out.println("Encoded list" + Arrays.toString(encodedList.toArray()));

        List<Integer> inputOutput1= new  ArrayList<Integer>();
        inputOutput1.add(2);
        inputOutput1.add(4);

        List<Integer> inputOutput2= new  ArrayList<Integer>();
        inputOutput2.add(1);
        inputOutput2.add(3);

        List<Integer> inputOutput3= new  ArrayList<Integer>();
        inputOutput3.add(5);
        inputOutput3.add(7);

        List<Integer> inputOutput4= new  ArrayList<Integer>();
        inputOutput4.add(4);
        inputOutput4.add(6);

        List<Integer> inputOutput5= new  ArrayList<Integer>();
        inputOutput5.add(9);
        inputOutput5.add(11);

        List<Integer> inputOutput6= new  ArrayList<Integer>();
        inputOutput6.add(12);
        inputOutput6.add(13);
        List<Integer> inputOutput7= new  ArrayList<Integer>();
        inputOutput7.add(8);
        inputOutput7.add(10);
        List<List<Integer>> listOfInputOutpUt = Lists.newArrayList();
        listOfInputOutpUt.add(inputOutput1);
        listOfInputOutpUt.add(inputOutput2);
        listOfInputOutpUt.add(inputOutput3);
        listOfInputOutpUt.add(inputOutput4);
        listOfInputOutpUt.add(inputOutput5);
        listOfInputOutpUt.add(inputOutput6);
        System.out.println("Number of agents require = "+ new BookingDotcomQuestions().howManyAgentsToAdd(2,listOfInputOutpUt));

        //
        List<List<Integer>> samples =Lists.newArrayList();
        List<Integer> row1 = Lists.newArrayList();
        row1.add(0);
        row1.add(1);
        row1.add(1);
        row1.add(0);
        row1.add(1);
        samples.add(row1);
        List<Integer> row2 = Lists.newArrayList();
        row2.add(1);
        row2.add(1);
        row2.add(0);
        row2.add(1);
        row2.add(0);
        samples.add(row2);
        List<Integer> row3 = Lists.newArrayList();
        row3.add(0);
        row3.add(1);
        row3.add(1);
        row3.add(1);
        row3.add(0);
        samples.add(row3);
        List<Integer> row4 = Lists.newArrayList();
        row4.add(1);
        row4.add(1);
        row4.add(1);
        row4.add(1);
        row4.add(0);
        samples.add(row4);
        List<Integer> row5 = Lists.newArrayList();
        row5.add(1);
        row5.add(1);
        row5.add(1);
        row5.add(1);
        row5.add(1);
        samples.add(row5);
        List<Integer> row6 = Lists.newArrayList();
        row6.add(0);
        row6.add(0);
        row6.add(0);
        row6.add(0);
        row6.add(0);
        samples.add(row6);
        printMaxSubSquare(samples);

    }


    public  int howManyAgentsToAdd(int noOfCurrentAgents ,List<List<Integer>> callsTimes){
        List<TimeObject> timeObjectList = Lists.newArrayList();
        for (List<Integer> times: callsTimes) {
            timeObjectList.add(new TimeObject(times.get(0),times.get(1)));
        }
        Collections.sort(timeObjectList, (o1, o2) -> o1.start - o2.end);
        int numberRequired=0;
        for(int i =1 ;i <timeObjectList.size(); i++){
            if(timeObjectList.get(i).start <= timeObjectList.get(i- 1).end){
                numberRequired++;
            }
        }

        System.out.println(timeObjectList);

        if (numberRequired < noOfCurrentAgents){
            return 0;
        }else {
            return numberRequired - noOfCurrentAgents;
        }

    }

    class TimeObject{
        Integer start;
        Integer end;

        TimeObject(Integer start,Integer end){
            this.start =start;
            this.end =end;
        }

        @Override
        public String toString() {
            return "Start ="+this.start+" end="+this.end;
        }
    }

    public static String findNumber(List<Integer> arr, int k) {
        // Write your code here
        Boolean b = false;
        for (Integer i : arr) {
            if (i == k) {
                b = true;
                return "YES";
            }

        }
        if (b) {
            return "NO";
        }
        return "NO";
    }
    /*Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

    For example, consider the below binary matrix.
    maximum-size-square-sub-matrix-with-all-1s*/

    static void printMaxSubSquare(List<List<Integer>> samples){
        int row = samples.size();
        int col = samples.get(0).size();
        int[][] copyArray = new int[row][col];
        int max = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                copyArray[x][y] = samples.get(x).get(y);
                if (x > 0 && y > 0 && copyArray[x][y] == 1) {
                    copyArray[x][y] = Math.min(Math.min(copyArray[x][y - 1], copyArray[x - 1][y]), copyArray[x - 1][y - 1]) + 1;
                }
                if (max < copyArray[x][y]) {
                    max = copyArray[x][y];
                }
            }
        }
        System.out.println("max size="+max);
    }


}
