/*
Problem Statement :
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.

For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format - 
   v1 v2 w
   where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex 
   first while printing an edge.
2. Print V-1 edges in above format in different lines.

Note : Order of different edges doesn't matter.

Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi 
(separated by space)

Output Format :
Print the MST, as described in the task.
*/


import java.util.Scanner;

public class Solution 
{
    private static int findMinVertex(boolean visitedVertex[], int weight[])
    {
        int minVertex = -1;
        int v = visitedVertex.length;
        for(int i = 0; i < v; i++)
        {
            if(!visitedVertex[i] && (minVertex == -1 || weight[minVertex] > weight[i]))
            {
                minVertex = i;
            }
        }
        return minVertex;
    }
    
    private static MST prims(int adjMatrix[][])
    {
        int v = adjMatrix.length;
        boolean visitedVertex[] = new boolean[v];
        int parent[] = new int[v];
        parent[0] = -1;
        int weight[] = new int[v];
        weight[0] = 0;
        for(int i = 1; i < v; i++)
        {
            weight[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < v; i++)
        {
            int minVertex = findMinVertex(visitedVertex, weight);
            visitedVertex[minVertex] = true;
            for(int j = 0; j < v; j++)
            {
                // unvisited neighbor with minimum weight
                if(adjMatrix[minVertex][j] != 0 && !visitedVertex[j])  
                {
                    if(weight[j] > adjMatrix[minVertex][j])
                    {
                        // update weight
                        weight[j] = adjMatrix[minVertex][j];
                        // update parent
                        parent[j] = minVertex;     
                    }
                }
            }
        }
        
        MST mst = new MST(parent, weight);
        return mst;
    }
    
    public static void main(String[] args) 
    {
	Scanner sc = new Scanner(System.in);
	int v = sc.nextInt();
	int e = sc.nextInt();
	int adjMatrix[][] = new int[v][v];
        for(int i = 0; i < e; i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            adjMatrix[v1][v2] = w;
            adjMatrix[v2][v1] = w;
        }
		
        MST mst = prims(adjMatrix);
        
        // printing MST
        for(int i = 1; i < v; i++)
        {
            if(mst.parent[i] <= i)
            {
                System.out.println(mst.parent[i] + " " + i + " " + mst.weight[i]);
            }
            else
            {
                System.out.println(i + " " + mst.parent[i] + " " + mst.weight[i]);
            }
        }
    }
}

class MST
{
    int parent[];
    int weight[];
    public MST(int parent[], int weight[])
    {
        this.parent = parent;
        this.weight = weight;
    }
}