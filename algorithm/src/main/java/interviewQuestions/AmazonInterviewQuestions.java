package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by pourush.sinha on 09/02/20.
 */
public class AmazonInterviewQuestions {

    /*
    * Given a 2D m*n grid (or matrix) with 1s and 0s where 1 represent updated server and 0 represent older version,
    * replace 0s with 1s if they are adjacent. Once the server is updated, it will only update it's adjacent servers
    * the next day. Return the number of days it'll take to update all the servers. If there's a way if some servers
    * cannot be updated, then return -1.
      Update can only happen in up, down, right, or left directions.
      Eg:
grid:
[[0, 1, 1, 0],
[0, 0, 0, 1],
[0, 0, 0, 0]]
Answer: 2 days will be required to update all the servers.

Explanation:
DAY 0 (initial state):
[[0, 1, 1, 0]
[0, 0, 0, 1],
[0, 0, 0, 0]]

DAY 1
[[1, 1, 1, 1],
[0, 1, 1, 1],
[0, 0, 0, 1]]

DAY 2
[[1, 1, 1, 1],
[1, 1, 1, 1],
[1, 1, 1, 1]]

At the end of the interview, explanation and complexity of the algorithms were asked. 15 minutes were given for this purpose.

I had got 15 correct out of 17
*/

    static int   minimumDays(int rows, int columns, List<List<Integer>> grid){
        Queue<int[]> q = new LinkedList<>();
        int target = grid.size() * grid.get(0).size();
        int cnt = 0, res = 0;
        for(int i=0;i<grid.size();i++) {
            for(int j=0;j<grid.get(0).size();j++) {
                if(grid.get(i).get(j) == 1) {
                    q.add(new int[] {i,j});
                    cnt++;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            if(cnt == target)
                return res;
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni >=0 && ni < grid.size() && nj >=0 && nj < grid.get(0).size() && grid.get(ni).get(nj) == 0) {
                        cnt++;
                        q.offer(new int[] {ni, nj});
                        grid.get(ni).set(nj,1);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(new Integer[] { 0, 1, 1, 0,1}));
        grid.add(Arrays.asList(new Integer[] { 0, 1, 0, 1,0}));
        grid.add(Arrays.asList(new Integer[] { 0, 0, 0, 0,1}));
        grid.add(Arrays.asList(new Integer[] { 0, 1, 0, 0,0}));

        System.out.println("minium Days === "+minimumDays(0,1,grid));
    }

}
