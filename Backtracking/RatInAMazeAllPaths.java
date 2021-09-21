/*
Problem Statement :
You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination 
i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells 
and those with value 1 are open.
*/




public class Solution 
{
    static void ratInAMaze(int maze[][], int n) 
    {
	int path[][] = new int[n][n];
        solveMaze(maze, n, 0, 0, path);
    }
    
    static void solveMaze(int maze[][], int n, int row, int column, int path[][])
    {
        // invalid cells + blocked cells + cells already included in current path
        if(row < 0 || row >= n || column < 0 || column >= n || maze[row][column] == 0 || path[row][column] == 1)
        {
            return;
        }
        // include current cell in current path
        path[row][column] = 1;
        // reached destination cell
        if(row == n-1 && column == n-1)
        {
            // print current path
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    System.out.print(path[i][j] + " ");
                }
            }
            System.out.println();
            // set destination cell's path to 0.
            // so, that to consider this cell while finding other paths.
            path[row][column] = 0;  
            return;
        }
        // Explore all the directions
        // Top
        solveMaze(maze, n, row-1, column, path);
        // Right
        solveMaze(maze, n, row, column+1, path);
        // Down
        solveMaze(maze, n, row+1, column, path);
        //Left
        solveMaze(maze, n, row, column-1, path);
        // while backtracking set current path cell to 0
        // because for the paths that are found while exploring other directions
        // current cell will be seen as they are not part of current path and can
        // be considered in current path.
        path[row][column] = 0; 
    }
}