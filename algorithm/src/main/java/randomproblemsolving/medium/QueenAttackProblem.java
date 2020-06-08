package randomproblemsolving.medium;

/**
 * Created by pourush.sinha on 06/01/19.
 */

/*
* You will be given a square chess board with one queen and a number of obstacles placed on it.
* Determine how many squares the queen can attack.

A queen is standing on an  chessboard. The chess board's rows are numbered from  to , going from
bottom to top. Its columns are numbered from  to , going from left to right. Each square is
referenced by a tuple, , describing the row, , and column, , where the square is located.

The queen is standing at position . In a single move, she can attack any square in any of the
eight directions (left, right, up, down, and the four diagonals). In the diagram below, the green
circles denote all the cells the queen can attack from :

image
https://s3.amazonaws.com/hr-challenge-images/0/1485426500-a4039ebb00-chess1.png

There are obstacles on the chessboard, each preventing the queen from attacking any square beyond it on that path. For example, an obstacle at location  in the diagram above prevents the queen from attacking cells , , and :

image

Given the queen's position and the locations of all the obstacles, find and print the number of squares the queen can attack from her position at . In the board above, there are  such squares.

Function Description

Complete the queensAttack function in the editor below. It should return an integer that describes the number of squares the queen can attack.

queensAttack has the following parameters:
- n: an integer, the number of rows and columns in the board
- k: an integer, the number of obstacles on the board
- r_q: integer, the row number of the queen's position
- c_q: integer, the column number of the queen's position
- obstacles: a two dimensional array of integers where each element is an array of  integers, the row and column of an obstacle
                       x
                       |
           xminusy     |   xy
                       |
       y------------------------------------y
                       |
        minusxminusy   |   yminusxy
                       |
                       x




 */
public class QueenAttackProblem {

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
          int dxy,dxminusy,dminusxminusy,dyminusxy ,r1,r2,c1,c2 =0;
          //lower half
          r1 = r_q -1;
          ////uper half
          r2 = n -r_q;
          //right half
          c1 = n  - c_q;
          //left half
          c2 = c_q -1;

          //xx cordinat
          dxy = Math.min(n - r_q , n - c_q);
          dminusxminusy = Math.min(r_q -1 ,c_q -1);
          dxminusy = Math.min(n - r_q ,c_q -1);
          dyminusxy = Math.min(n - c_q ,r_q -1);

          for(int i = 0; i<k ;i++){

              int x_cordinate_obstacle = obstacles[i][0];
              int y_cordinate_obstacle = obstacles[i][1];

              //For x cordiante +ve
              if(y_cordinate_obstacle == c_q && x_cordinate_obstacle > r_q ){
                  r2 = Math.min(r2, (x_cordinate_obstacle - r_q) -1); // -1 because distance shoud be calulated from r_q +1
              }

              //For x cordinate -ve
              if(y_cordinate_obstacle == c_q && x_cordinate_obstacle < r_q ){
                  r1 = Math.min(r1, (r_q - x_cordinate_obstacle) -1); // -1 because distance shoud be calulated from r_q +1
              }

              if(x_cordinate_obstacle == r_q && y_cordinate_obstacle > c_q ){
                  c1 = Math.min(c1, (y_cordinate_obstacle - c_q) -1); // -1 because distance shoud be calulated from r_q +1
              }

              //For x cordinate -ve
              if(x_cordinate_obstacle == r_q && y_cordinate_obstacle < c_q ){
                  c2 = Math.min(c2, (c_q - y_cordinate_obstacle) -1); // -1 because distance shoud be calulated from r_q +1
              }

              //For  dxy cordinate

              if(x_cordinate_obstacle > r_q && y_cordinate_obstacle > c_q && (x_cordinate_obstacle - r_q == y_cordinate_obstacle - c_q)){
                  dxy = Math.min(dxy ,(x_cordinate_obstacle - r_q) - 1); //// -1 because distance shoud be calulated from r_q +1
                                                                        //x_cordinate_obstacle - r_q because x_cordinate_obstacle - r_q is same as y_cordinate_obstacle - c_q
              }

              //For dminusxminusy cordinate
              if( r_q > x_cordinate_obstacle && c_q >y_cordinate_obstacle  &&( r_q - x_cordinate_obstacle == c_q - y_cordinate_obstacle)){
                  dminusxminusy = Math.min(dminusxminusy ,(r_q - x_cordinate_obstacle) - 1); //// -1 because distance shoud be calulated from r_q +1
                  //x_cordinate_obstacle - r_q because x_cordinate_obstacle - r_q is same as y_cordinate_obstacle - c_q
              }

              //For dxminusy cordinate

              if(x_cordinate_obstacle > r_q && c_q > y_cordinate_obstacle && (x_cordinate_obstacle - r_q == c_q - y_cordinate_obstacle)){
                  dxminusy = Math.min(dxminusy ,(x_cordinate_obstacle - r_q) - 1); //// -1 because distance shoud be calulated from r_q +1
                  //x_cordinate_obstacle - r_q because x_cordinate_obstacle - r_q is same as y_cordinate_obstacle - c_q
              }


              //  For dyminusxy cordinate
              if(r_q > x_cordinate_obstacle && y_cordinate_obstacle > c_q && (r_q - x_cordinate_obstacle == y_cordinate_obstacle - c_q)){
                  dyminusxy = Math.min(dyminusxy ,(r_q - x_cordinate_obstacle) - 1); //// -1 because distance shoud be calulated from r_q +1
                  //x_cordinate_obstacle - r_q because x_cordinate_obstacle - r_q is same as y_cordinate_obstacle - c_q
              }



        }
        System.out.println("dxy = "+dxy);
        System.out.println("dxminusy = "+dxminusy);
        System.out.println("dminusxminusy = "+dminusxminusy);
        System.out.println("dyminusxy = "+dyminusxy);
        System.out.println("r1 = "+r1);
        System.out.println("r2 = "+r2);
        System.out.println("c1 = "+c1);
        System.out.println("c2 = "+c2);

      return dxy + dxminusy + dminusxminusy + dyminusxy + r1 + r2 + c1 + c2;
    }

    public static void main(String[] args) {

        int n =5;
        int  k = 3;
        int r_q = 4;
        int c_q = 3;
        int[][] obstacles = new int[3][2];
        obstacles[0][0]=5;
        obstacles[0][1]=5;
        obstacles[1][0]=4;
        obstacles[1][1]=2;
        obstacles[2][0]=2;
        obstacles[2][1]=3;

        System.out.println(" total numbe of attacks ="+queensAttack(n,k,r_q,c_q,obstacles));


    }
}

