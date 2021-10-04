/*
Problem Statement :
An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island 
to any other island in the same group . Given V islands (numbered from 1 to V) and E connections or edges between islands. Can you count 
the number of connected groups of islands.
*/


// Just perform Depth First Traversal for disconnected graph and count.
public class Solution 
{
    public static int numConnected(int[][] adjMatrix, int v) 
    {
        boolean visitedVertex[] = new boolean[v];
        int count = 0;
        for(int i = 0; i < v; i++)
        {
            if(!visitedVertex[i])
            {
            	numConnected(adjMatrix, i, visitedVertex);
                count++;
            }
        }
        return count;
    }
    // helper function
    public static void numConnected(int adjMatrix[][], int currentVertex, boolean visitedVertex[])
    {
        visitedVertex[currentVertex] = true;
        for(int i = 0; i < adjMatrix.length; i++)
        {
            if(adjMatrix[currentVertex][i] == 1 && !visitedVertex[i])
            {
                numConnected(adjMatrix, i, visitedVertex);
            }
        }
    }
}