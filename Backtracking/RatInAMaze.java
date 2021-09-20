/*
Problem Statement :
You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow 
to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direction (left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not 
enter into those cells and those with value 1 are open.
*/


public class Solution 
{
    public static boolean ratInAMaze(int maze[][])
    {
	int[][] path = new int[maze.length][maze.length];  //each cell is initialized with 0.
        return ratInAMaze(maze, path, 0, 0);
    }
    
    // consider traversal order -> Top Right Down Left 
    // initially (row, column) -> (0, 0) 
    private static boolean ratInAMaze(int[][] maze, int[][] path, int row, int column)
    {
        int n = maze.length;
        //check whether cell is valid or not
        if(row < 0 || row >= n || column < 0 || column >= n)
        {
            return false;
        }
        //blocked cell
        if(maze[row][column] == 0)   
        {
            return false;
        }
        //cell is already included in path
        if(path[row][column] == 1)
        {
            return false;
        }
        
        //include current cell in path
        path[row][column] = 1;
        
        //destination
        if(row == n-1 && column == n-1)
        {
            return true;
        }
        
        //Explore further in all directions
        //explore in top direction
        if(ratInAMaze(maze, path, row-1, column))
        {
            //path found
            return true;
        }
        //else explore in right direction
        if(ratInAMaze(maze, path, row, column+1))
        {
            //path found
            return true;
        }
        //else explore in down direction
        if(ratInAMaze(maze, path, row+1, column))
        {
            //path found
            return true;
        }
        //else explore in left direction
        if(ratInAMaze(maze, path, row, column-1))
        {
            //path found
            return true;
        }
        //explore in all directions but path not found
        return false;
    }
}
