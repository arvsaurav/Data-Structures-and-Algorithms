/*
Problem Statement :
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). 
Print nothing if there is no path between v1 and v2.
Find the path using DFS and print the first path that you encountered.

Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.

Output Format :
Print the path from v1 to v2 in reverse order.
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution 
{
    public static ArrayList<Integer> getPath(int adjMatrix[][], int source, int destination)
    {
        boolean visitedVertex[] = new boolean[adjMatrix.length];
        // source -> currentVertex
        return getPath(adjMatrix, visitedVertex, source, destination);
    }
    // helper function
    public static ArrayList<Integer> getPath(int adjMatrix[][], boolean visitedVertex[], int currentVertex, int destination)
    {
	// base case
        // path found
        if(currentVertex == destination)
        {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(currentVertex);
            visitedVertex[currentVertex] = true;
            return path;
        }
        
        for(int i = 0; i < adjMatrix.length; i++)
        {
            if(adjMatrix[currentVertex][i] == 1 && visitedVertex[i] == false)
            {
                visitedVertex[currentVertex] = true;
                ArrayList<Integer> path = getPath(adjMatrix, visitedVertex, i, destination);
                if(path != null)
                {
                    // path found 
		    // therefore, no need to traverse rest of neighbors.
                    path.add(currentVertex);
                    return path;
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int adjMatrix[][] = new int[v][v];
        for(int i = 0; i < e; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        ArrayList<Integer> path = getPath(adjMatrix, v1, v2);
        if(path == null)
        {
            return;
        }
        for(int i = 0; i < path.size(); i++)
        {
            System.out.print(path.get(i) + " ");
        }
    }
}