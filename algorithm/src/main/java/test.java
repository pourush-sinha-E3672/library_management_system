import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pourush.sinha on 01/12/19.
 */
public class test {

    public static  int solution(int[] A) {
        // write your code in Java SE 8

        // write your code in Java SE 8

        Arrays.sort(A);

            if(A[A.length -1] < 0){
            return 1;
        }

        for(int i=1;i<A.length;i++){
            if(A[i-1]<0){
                continue;
            }else{
                if(((A[i] - A[i - 1]) ==0 )|| ((A[i] - A[i-1]) == 1 )){
                    continue;
                }else{
                    return A[i-1]+1;
                }
            }
        }

        return A[A.length -1] + 1;
    }
    public static int soultion2(String s){
        Map<Character,Integer> map = new HashMap<>();
        map.put('B',0);
        map.put('A',0);
        map.put('L',0);
        map.put('O',0);
        map.put('N',0);
        for (Character c : s.toCharArray()) {

            if(c.equals('B')){
                int val = map.get('B');
                map.put('B',val+1);

            }else if(c.equals('A')){
                int val = map.get('A');
                map.put('A',val+1);
            }
            else if(c.equals('L')){
                int val = map.get('L');
                map.put('L',val+1);
            }else if(c.equals('O')){
                int val = map.get('O');
                map.put('O',val+1);
            }else if(c.equals('N')){
                int val = map.get('N');
                map.put('N',val+1);
            }

        }
        int min =Integer.MAX_VALUE;
        for (Character c: map.keySet()) {

            if(c.equals('B')){
                int val = map.get('B');
               if(min > val){
                   min=val;
               }

            }else if(c.equals('A')){
                int val = map.get('A');
                if(min > val){
                    min=val;
                }
            }
            else if(c.equals('L')){
                int val = map.get('L');
                val = val/2;
                if(min > val){
                    min=val;
                }
            }else if(c.equals('O')){
                int val = map.get('O');
                val = val/2;
                if(min > val){
                    min=val;
                }
            }else if(c.equals('N')){
                int val = map.get('N');
                if(min > val){
                    min=val;
                }
            }
        }
        return min;
    }

    public static String solution3(int N, String S, String T){
        int totalNumberOfHits = 0;
        int totalNumberOfSunk = 0;
        String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] hitArray = T.split(" ");
        int[][] matrix = new int[N][N];
        for(int i=N ;i<N ;i++){
            for(int j=N ;j<N ;j++){
                matrix[i][j] =0;
            }
        }
        for (String hit: hitArray) {
            int indexi = Integer.parseInt(hit.substring(0,hit.length()-1))-1;
            int indexj = str.indexOf(hit.charAt(hit.length() -1));
            matrix[indexi][indexj] = 1;

        }

        String[] shipsArray = S.split(",");
        for (String ships : shipsArray) {
            String[] shipsCoordinate = ships.split(" ");
            int ival =Integer.parseInt((shipsCoordinate[0].substring(0,shipsCoordinate[0].length() -1))) -1;
            int jval =str.indexOf(shipsCoordinate[0].charAt(shipsCoordinate[0].length() -1));

            int nval =Integer.parseInt((shipsCoordinate[1].substring(0,shipsCoordinate[1].length() -1))) -1;
            int kval =str.indexOf(shipsCoordinate[1].charAt(shipsCoordinate[1].length() -1));
            int numberOfHits = 0;
            Boolean sunk=true;

            for(int i =ival ; i<=nval; i++){
                for(int j =jval ; j<=kval; j++){
                 if(matrix[i][j]==1){
                     numberOfHits++;
                 }else{
                     sunk=false;
                 }
                }

            }

            if(numberOfHits >0 && sunk){
                totalNumberOfSunk++;
            }else{
                totalNumberOfHits =numberOfHits;
            }

        }
      return totalNumberOfSunk+","+totalNumberOfHits;

    }

    public static  ArrayList<Integer> plusOne(List<Integer> A) {
        Integer sum =0;
        for(Integer i : A){
            sum = sum*10 + i;
        }
        System.out.println(sum);
        sum = sum + 1;
        ArrayList<Integer> intr = new ArrayList<Integer>();
        while (sum>0){
            intr.add(sum%10);
            sum = sum /10;
        }
        Collections.reverse(intr);
        return intr;
    }


    public static void main(String[] args) {
        int[] A ={1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5};

        //System.out.print(solution(A));
        ArrayList<Integer> j = new ArrayList<>();
        j.add(0);
        List<Integer> str = plusOne(j);

        System.out.print(solution3(3,"1A 1B,2C 2C","1B"));

        boolean[] arr ={false,false,false,false};
        System.out.println(Arrays.toString(arr));
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static <T> List<T> convertArrayToList(T array[])
    {

        // Create the List by passing the Array
        // as parameter in the constructor
        List<T> list = Arrays.asList(array);

        // Return the converted List
        return list;
    }
    public static void change(boolean[] arr){
        arr[2]=true;
    }
}
