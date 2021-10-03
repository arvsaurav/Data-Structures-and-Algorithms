/* 
DFS for disconnected graphs.
*/

import java.util.Scanner;
public class Graph 
{
    public static void DFTraversal(int adjMatrix[][])
    {
	boolean visitedVertex[] = new boolean[adjMatrix.length];
	for(int i = 0; i < adjMatrix.length; i++)
	{
	    if(visitedVertex[i] == false)
	    {
		DFTraversal(adjMatrix, i, visitedVertex); 
	    }
	}
    }
    // helper function
    public static void DFTraversal(int adjMatrix[][], int currentVertex, boolean visitedVertex[])
    {
	System.out.print(currentVertex + " ");
	visitedVertex[currentVertex] = true;  
	for(int i = 0; i < adjMatrix.length; i++)
	{
	    if(adjMatrix[currentVertex][i] == 1 && visitedVertex[i] == false)
	    {
		DFTraversal(adjMatrix, i, visitedVertex);
	    }
	}
    }
	
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
	sc.close();
	DFTraversal(matrix);
    }
}