package randomproblemsolving.medium;
import utility.CommonUtils;


import java.util.Map;
import java.util.TreeMap;

/**
 * Created by pourush.sinha on 26/12/18.
 */

/*
*
* Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking.
* The game uses Dense Ranking, so its leaderboard works like this:

The player with the highest score is ranked number  on the leaderboard.
Players who have equal scores receive the same ranking number, and the next
player(s) receive the immediately following ranking number.
For example, the four players on the leaderboard have high scores of 100,90 ,90 , and 80 .
Those players will have ranks 1,2,2,3 respectively. If Alice's scores are 70,80  and ,105
her rankings after each game are 4,3  and 1

Function Description

Complete the climbingLeaderboard function in the editor below. It should return
 an integer array where each element represents Alice's rank after the  game.

climbingLeaderboard has the following parameter(s):

scores: an array of integers that represent leaderboard scores
alice: an array of integers that represent Alice's scores
Input Format

The first line contains an integer , the number of players on the leaderboard.
The next line contains  space-separated integers , the leaderboard scores in decreasing order.
The next line contains an integer, , denoting the number games Alice plays.
The last line contains  space-separated integers , the game scores.
input
7
100 100 50 40 40 20 10
4
5 25 50 120

output
6
4
2
1
*/
public class ClimbingTheLeadersBoard {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
       int[] aliceRanks = new int[alice.length];
        Map<Integer,Integer> leadersBoard = new TreeMap<Integer,Integer>();
       int rank=0;

        for(Integer score : scores){
            if (!leadersBoard.containsKey(score)){
                leadersBoard.put(score,++rank);
            }

        }

        Integer[] marks =leadersBoard.keySet().toArray( new Integer[leadersBoard.keySet().size()]);
        new CommonUtils<Integer>().printArray(marks);
        int i =0;
        int j =0;
        int n = alice.length;
        int k =marks.length;
        while(i<n && j < k){

            if(alice[i]<marks[j]){
                if (j<=0){
                    aliceRanks[i] = leadersBoard.get(marks[j]) + 1;

                }else{
                    aliceRanks[i] = leadersBoard.get(marks[j - 1]);
                }
                i++;
            }else if(alice[i]==marks[j]){
                aliceRanks[i] = leadersBoard.get(marks[j]);
                i++;
                j++;
            }else{
                if (j >= marks.length-1){
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>");
                    aliceRanks[i] =1;
                    i++;
                }else{
                    j++;
                }
            }
           // CommonUtils.printArray(aliceRanks);
        }
        while(i<n){
            aliceRanks[i] =1;
            i++;
        }


      return aliceRanks;
    }

    public static void main(String[] args) {
        int[] scores ={100,100,50,40,40,20,10};
        int[] alice = {5,25,50,120};

       /* int[] scores ={100,90,90,80,75,60};
        int[] alice = {50,65,77,90,102};*/

        /*int[] scores ={295,294,291,287,287,285,285,284,283,279,277,274,274,271,270,268,268,268,264,260,259,258,257,255,252,250,244,241,240,237,236,236,231,227,227,227,226,225,224,223,216,212,200,197,196,194,193,189,188,187,183,182,178,177,173,171,169,165,143,140,137,135,133,130,130,130,128,127,122,120,116,114,113,109,106,103,99,92,85,81,69,68,63,63,63,61,57,51,47,46,38,30,28,25,22,15,14,12,6,4};
        int[] alice = {5,5,6,14,19,20,23,25,29,29,30,30,32,37,38,38,38,41,41,44,45,45,47,59,59,62,63,65,67,69,70,72,72,76,79,82,83,90,91,92,93,98,98,100,100,102,103,105,106,107,109,112,115,118,118,121,122,122,123,125,125,125,127,128,131,131,133,134,139,140,141,143,144,144,144,144,147,150,152,155,156,160,164,164,165,165,166,168,169,170,171,172,173,174,174,180,184,187,187,188,194,197,197,197,198,201,
        202,202,207,208,211,212,212,214,217,219,219,220,220,223,225,227,228,229,229,233,235,235,236,242,242,245,246,252,253,253,257,257,260,261,266,266,268,269,271,271,275,276,281,282,283,284,285,287,289,289,295,296,298,300,300,301,304,306,308,309,310,316,318,318,324,326,329,329,329,330,330,332,337,337,341,341,349,351,351,354,356,357,366,369,377,379,380,382,391,391,394,396,396,400};
*/
        System.out.println("climbing lader = ");
        CommonUtils.printArray(climbingLeaderboard(scores,alice));
    }

}
