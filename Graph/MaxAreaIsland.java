package Graph;

import java.util.*;

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;
        int area = 0;
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    area = bfs(i,j,grid,visited);
                    maxArea = Math.max(area,maxArea);
                }
            }
        }
        return maxArea;

    }

    public int bfs(int i, int j, int[][] grid, boolean [][] visited){
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int[] index = queue.poll();
            for(int[] d: dir){
                int newRow = index[0]+d[0];
                int newCol = index[1]+d[1];
                if(newRow >= 0 &&  newRow < grid.length && newCol >=0 &&  newCol < grid[0].length && !visited[newRow][newCol] && grid[newRow][newCol] ==1){
                    visited[newRow][newCol]=true;
                    queue.add(new int[]{newRow,newCol});
                    count++;
                }
            }

        }
        return count;
    }


    public static void main(String[]args){
        System.out.println("Find out Max Area of Island");
        int[][] grid ={
                {1,1,0,0,0},
                {1,1,0,1,1},
                {0,0,0,1,1},
                {0,1,0,1,1}
        };
        MaxAreaIsland obj = new MaxAreaIsland();
        int result = obj.maxAreaOfIsland(grid);
        System.out.println("The maximum area of island is: " + result);

    }
}
