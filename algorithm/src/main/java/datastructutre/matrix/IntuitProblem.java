package datastructutre.matrix;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pourush.sinha on 24/05/19.
 */
class newName{
    String name="";
}
public class IntuitProblem {

    int n=4;
    int m=4;


    public static int getNumber(int n , int m){
        int count =0;
        for(int i=1; i<=n ;i++){
            for(int j=1 ;j<=m;j++){
                if(j % i ==0){
                    count++;
                }
            }

        }

        return count;
    }

    Boolean findNumber(String[][] matrix ,String abc,String word , int x ,int y ,Boolean[][] visited){
        if(visited[x][y] == true){
            return false;
        }
        if (matrix.length -1 < x || x < 0){
            return  false;
        }


        if (matrix[0].length -1 < y|| y < 0){
            return  false;
        }
        abc=abc + matrix[x][y];
        visited[x][y] =true;
        if (abc==word){
            return true;
        }

       return  findNumber(matrix,abc,word ,x+1,y,visited)
               ||findNumber(matrix,abc,word ,x-1,y,visited)
               ||findNumber(matrix,abc,word ,x,y+1,visited)
               ||findNumber(matrix,abc,word ,x,y-1,visited)
                ||findNumber(matrix,abc,word ,x+1,y-1,visited)
                ||findNumber(matrix,abc,word ,x-1,y+1,visited);
    }

    public static void main(String[] args) {
        System.out.print("number = "+(5/2));
        new HashMap<>();

       /* Scanner sc = new Scanner(System.in);
        List<List<Integer>> matrix = Lists.newArrayList();
        

       String abc = "WELCOME";


        int row, column ,testcases;
        testcases =Integer.parseInt(sc.nextLine());

        for(int i =0 ;i<testcases ;i++){
            String[] input = new String[2];
            input = sc.nextLine().split(" ");
            List<Integer> list = Lists.newArrayList();
            list.add(0,Integer.parseInt(input[0]));
            list.add(1,Integer.parseInt(input[1]));
            matrix.add(list);
        }

        for (List<Integer> i :matrix) {
            System.out.println(getNumber(i.get(0),i.get(1)));

        }

        sc.close();*/

       String[][] matirx = {{"T","I","Z"},
               {"I","U","N"},
               {"W","O","T"}};
        IntuitProblem intuitProblem = new IntuitProblem();
        Boolean[][] visited = {{false,false,false},
                {false,false,false},
                {false,false,false}};

        System.out.print(intuitProblem.findNumber(matirx,"","INTUIT" ,0 ,1,visited));
    }
}
