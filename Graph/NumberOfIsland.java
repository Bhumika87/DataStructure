package Graph;

import java.util.*;

public class NumberOfIsland {
        public int numIslands(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            int count = 0;
            boolean[][] visited = new boolean[row][col];
            for(int i =0;i<row;i++){
                for(int j =0;j<col;j++){
                    if(grid[i][j]=='1' && !visited[i][j]){
                        count++;
                        bfs(i,j,grid,visited,count);
                    }
                }
            }

            return count;
        }
        void bfs(int row , int col, char[][] grid,boolean[][] visited, int count) {
            int m = grid.length;
            int n = grid[0].length;

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{row, col});
            visited[row][col] = true;

            while (!q.isEmpty()) {
                int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];

                for (int[] d : dirs) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];

                    if (nx >= 0 && ny >= 0 && nx < m && ny < n &&
                            grid[nx][ny] == '1' && !visited[nx][ny]) {

                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        public static void main(String[]args){
            char[][] grid ={
                    {'1','0','1','1','0'},
                    {'1','0','0','1','0'},
                    {'0','0','1','0','0'},
                    {'1','1','1','0','0'}
            };

            NumberOfIsland obj = new NumberOfIsland();
            int result = obj.numIslands(grid);
            System.out.println("Number of Islands: "+ result);


        }


}
