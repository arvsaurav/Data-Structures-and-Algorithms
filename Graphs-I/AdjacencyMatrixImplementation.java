// Implementation of Adjacency Matrix.

import java.util.Scanner;
public class Graph 
{
    public static void main(String args[])
    {
	Scanner sc = new Scanner(System.in);
	// number of vertices
	// 0 based numbering
	int v = sc.nextInt();  
	// adjacency matrix
	int matrix[][] = new int[v][v]; 
	// number of edges
	int e = sc.nextInt();
	// input edges v1 to v2
	for(int i = 0; i < e; i++)
	{
	    int v1 = sc.nextInt();
	    int v2 = sc.nextInt();
	    matrix[v1][v2] = 1;
	    matrix[v2][v1] = 1;
	}
		
	// print adjacency matrix
	for(int i = 0; i < v; i++)
	{
	    for(int j = 0; j < v; j++)
	    {
		System.out.print(matrix[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}
