package Graph;

import java.util.*;

public class islandPerimeter {

   //Cells are connected up, down, left, right (no diagonal).
   //Each land cell (1) contributes 4 sides.but, For every neighbor land cell, you lose 1 side of perimeter.
   //APPROACH: Add 4 to perimeter Check its 4 neighbors If neighbor is also land → subtract 1 for that side
    public int islandPerimeterBrute(int[][]grid) {
        int perimeter =0;
        int rows = grid.length;
        int col = grid[0].length;
        for(int i =0;i<rows;i++) {
            for(int j =0;j<col;j++){
                if(grid[i][j] ==1) {
                    perimeter += 4;
                    if(i>0 &&grid[i-1][j]==1){
                        perimeter--;
                    }
                    if (i < rows-1 && grid[i+1][j] == 1){
                        perimeter--;
                    }
                    if(j>0 &&grid[i][j-1]==1){
                        perimeter--;
                    }
                    if (j < col-1 && grid[i][j+1] == 1){
                        perimeter--;
                    }
                }

            }
        }
        return perimeter;

    }
    
    
    //bfs approach can also be used to solve this problem.
    public int islandPerimeterBFS(int[][]grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;
        int [][] directions = {{-1,0},{1,0},{0,-1},{0,1}}; //up, down, left, right
        int perimeter =0;

        //BFS always needs a starting point && !flag This stops both loops as soon as the first land cell is found.
        for(int i =0;i<row && !flag;i++){
            for(int j=0;j<col && !flag;j++){
                if(grid[i][j]==1) {
                    visited[i][j]=true;
                    queue.add(new int[]{i,j});
                    flag = true;
                }
            }
        }

        //BFS traversal
        while(!queue.isEmpty()){
            int []cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            perimeter += 4;
            for(int[]dir : directions) {
                int newRow = r +dir[0];
                int newCol = c +dir[1];
                if(newRow>=0 && newRow<row && newCol>=0 && newCol<col){
                    if(grid[newRow][newCol]==1){
                        perimeter--;
                
                        if (!visited[newRow][newCol]){
                        visited[newRow][newCol]=true;
                        queue.offer(new int[]{newRow,newCol});
                        }
                    }
                }  
            }
        }
            
        return perimeter;
        }



    public static void main(String[]args){
        islandPerimeter obj = new islandPerimeter();
        int[][]grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };
        int result = obj.islandPerimeterBrute(grid);
        System.out.println("The perimeter of the island is: " + result);
    }

}
