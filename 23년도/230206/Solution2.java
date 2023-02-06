import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    //200. Number of Islands
    // bfs 로 떨어져있는 섬 탐색.
    //https://leetcode.com/problems/number-of-islands/submissions/892750650/

    public int numIslands(char[][] grid) {
        boolean[] visited = new boolean[grid.length * grid[0].length];

        int numOfIsl = 0;
        for(int row = 0 ; row<grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1' && ! visited[getIndex(row, col, grid[0].length)]) {
                    bfs(grid, visited, getIndex(row, col, grid[0].length));
                    numOfIsl++;
                }
            }
        }
        return numOfIsl;
    }

    static void bfs(char[][] grid, boolean[] visited, int start){

        int[] rowDiff = new int[]{1, 0, -1, 0};
        int[] colDiff = new int[]{0, 1, 0, -1};
        int length = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int next = queue.poll();

            int row = next / length;
            int col = next % length;

            //북 동 남 서
            for(int i = 0; i<4; i++){

                int newRow = row+rowDiff[i];
                int newCol = col+colDiff[i];
                if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length ){
                    continue;
                }
                int index = getIndex(newRow, newCol, length);

                if(grid[newRow][newCol] == '1' && !visited[index]){
                    queue.add(index);
                    visited[index] = true;
                }
            }
        }

    }
    static int getIndex(int row, int col, int length){
        return row*length + col;
    }
}
