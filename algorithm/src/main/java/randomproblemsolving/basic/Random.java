package randomproblemsolving.basic;

/**
 * Created by pourush.sinha on 07/06/19.
 */
public class Random {

    static int diagonalDifference(int[][] arr) {
        int sum1 =0;
        int sum2 = 0;

        sum1 =getSumfirt(arr,0,0);
        sum2 =getSumSecond(arr,arr.length-1, 0);
        return Math.abs(sum1 - sum2);


    }

    static int getSumfirt(int[][] arr,int i,int j){
        if(i >= arr.length && j >= arr[0].length){
            return 0;
        }
        int val =arr[i][j];
        return val + getSumfirt(arr,++i,++j);
    }

    static int getSumSecond(int[][] arr,int i,int j){
        if(i < 0 || j >= arr[0].length){
            return 0;
        }
        int val =arr[i][j];
        return val + getSumSecond(arr,--i,++j);
    }

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];
        matrix[0][0] =11;
        matrix[0][1] =2;
        matrix[0][2] =4;

        matrix[1][0] =4;
        matrix[1][1] =5;
        matrix[1][2] =6;

        matrix[2][0] =10;
        matrix[2][1] =8;
        matrix[2][2] =-12;

        System.out.println("Sum = "+diagonalDifference(matrix));


    }

}
