/*
Problem Statement :
You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any 
other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same 
diagonal of any of the other queens. You have to print all such configurations.
*/




public class Solution 
{
    public static void placeNQueens(int n)
    {
	int board[][] = new int[n][n];
	placeQueen(board, n, 0);   // 0 -> row in which we have to place a queen.
    }
    private static void placeQueen(int board[][], int n, int row)
    {
        // base case
        if(row >= n)   // row out of bound
        {
            // we have placed n queens.
            // so, print current path
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
            return;
        }
        for(int column = 0; column < n; column++)
        {
			if(isSafe(board, row, column, n))
            {
                board[row][column] = 1;
                
                //place queens in remaining rows
                placeQueen(board, n, row+1);

                board[row][column] = 0; // backtracking
            }
        }
    }
    
    // check whether (row, column) -> this position is safe or not
    private static boolean isSafe(int board[][], int row, int column, int n)
    {
        // check that entire column
        for(int i = 0; i < row; i++)
        {
            if(board[i][column] == 1)
                return false;
        }
        // check left upper diagonal
        int i = row;
        int j = column;
        while(i >= 0 && j >= 0)
        {
            if(board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        // check right upper diagonal
        i = row;
        j = column;
        while(i >= 0 && j < n)
        {
            if(board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        // current position is safe
        return true;
    }
}
