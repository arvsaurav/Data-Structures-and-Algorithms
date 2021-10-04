/*
Problem Statement :
iven a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes 
the sentence “CODINGNINJA” .
There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an 
edge or a corner with the cell.

Input Format :
The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix. 
Each of the following N lines contain M characters. Please note that characters are not space separated.

Output Format :
Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.
*/


public class Solution 
{	
    int solve(String[] graph, int n, int m)
    {
	char adjMatrix[][] = new char[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                adjMatrix[i][j] = graph[i].charAt(j);
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(adjMatrix[i][j] == 'C')
                {
                    boolean visitedVertex[][] = new boolean[n][m];
                    visitedVertex[i][j] = true;
                    boolean ans = solve(adjMatrix, n, m, i, j, "ODINGNINJA", visitedVertex);   // (i, j) -> starting point
                    if(ans)
                    {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    // helper function
    private boolean solve(char adjMatrix[][], int n, int m, int i, int j, String targetString, boolean visitedVertex[][])
    {
	// base case
        if(targetString.length() == 0)
        {
            return true;
        }
        
	boolean subAns1 = false;
        if(i > 0 && adjMatrix[i-1][j] == targetString.charAt(0) && visitedVertex[i-1][j] == false)
        {
            visitedVertex[i-1][j] = true;
            subAns1 = solve(adjMatrix, n, m, i-1, j, targetString.substring(1), visitedVertex);
            visitedVertex[i-1][j] = false;  // so that, this can be available for alternate path
        }
        
        boolean subAns2 = false;
        if(i > 0 && j < m-1 && adjMatrix[i-1][j+1] == targetString.charAt(0) && visitedVertex[i-1][j+1] == false)
        {
            visitedVertex[i-1][j+1] = true;
            subAns2 = solve(adjMatrix, n, m, i-1, j+1, targetString.substring(1), visitedVertex);
            visitedVertex[i-1][j+1] = false;
        }
        
        boolean subAns3 = false;
        if(j < m-1 && adjMatrix[i][j+1] == targetString.charAt(0) && visitedVertex[i][j+1] == false)
        {
            visitedVertex[i][j+1] = true;
            subAns3 = solve(adjMatrix, n, m, i, j+1, targetString.substring(1), visitedVertex);
            visitedVertex[i][j+1] = false;
        }
        
        boolean subAns4 = false;
        if(i < n-1 && j < m-1 && adjMatrix[i+1][j+1] == targetString.charAt(0) && visitedVertex[i+1][j+1] == false)
        {
            visitedVertex[i+1][j+1] = true;
            subAns4 = solve(adjMatrix, n, m, i+1, j+1, targetString.substring(1), visitedVertex);
            visitedVertex[i+1][j+1] = false;
        }
        
        boolean subAns5 = false;
        if(i < n-1 && adjMatrix[i+1][j] == targetString.charAt(0) && visitedVertex[i+1][j] == false)
        {
            visitedVertex[i+1][j] = true;
            subAns5 = solve(adjMatrix, n, m, i+1, j, targetString.substring(1), visitedVertex);
            visitedVertex[i+1][j] = false;
        }
        
        boolean subAns6 = false;
        if(i < n-1 && j > 0 && adjMatrix[i+1][j-1] == targetString.charAt(0) && visitedVertex[i+1][j-1] == false)
        {
            visitedVertex[i+1][j-1] = true;
            subAns6 = solve(adjMatrix, n, m, i+1, j-1, targetString.substring(1), visitedVertex);
            visitedVertex[i+1][j-1] = false;
        }
        
        boolean subAns7 = false;
        if(j > 0 && adjMatrix[i][j-1] == targetString.charAt(0) && visitedVertex[i][j-1] == false)
        {
            visitedVertex[i][j-1] = true;
            subAns7 = solve(adjMatrix, n, m, i, j-1, targetString.substring(1), visitedVertex);
            visitedVertex[i][j-1] = false;
        }
        
        boolean subAns8 = false;
        if(i > 0 && j > 0 && adjMatrix[i-1][j-1] == targetString.charAt(0) && visitedVertex[i-1][j-1] == false)
        {
            visitedVertex[i-1][j-1] = true;
            subAns8 = solve(adjMatrix, n, m, i-1, j-1, targetString.substring(1), visitedVertex);
            visitedVertex[i-1][j-1] = false;
        }
        
        if(subAns1 || subAns2 || subAns3 || subAns4 || subAns5 || subAns6 || subAns7 || subAns8)
        {
            return true;
        }
        return false;
    }
}