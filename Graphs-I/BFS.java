/*
Problem Statement :
Given an undirected and disconnected graph G(V, E), print its BFS traversal.

Note:
1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
*/


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution 
{
    // Iterative Approach
    public static void BFS(int adjMatrix[][])
    {
        if(adjMatrix.length == 0)
        {
            return;
        }
        Queue<Integer> pendingVertex = new LinkedList<>();
        boolean visitedVertex[] = new boolean[adjMatrix.length];
        for(int i = 0; i < adjMatrix.length; i++)
        {
            if(visitedVertex[i] == false)
            {
                int currentVertex = i;
                BFS(adjMatrix, visitedVertex, pendingVertex, currentVertex);
            }
        }
    }
    // helper function
    public static void BFS(int adjMatrix[][], boolean visitedVertex[], Queue<Integer> pendingVertex, int currentVertex)
    {
        pendingVertex.add(currentVertex);
        visitedVertex[currentVertex] = true;
        while(!pendingVertex.isEmpty())
        {
            currentVertex = pendingVertex.poll();
            System.out.print(currentVertex + " ");
            for(int i = 0; i < adjMatrix.length; i++)
            {
                if(adjMatrix[currentVertex][i] == 1 && visitedVertex[i] == false)
                {
                    pendingVertex.add(i);
                    visitedVertex[i] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int adjMatrix[][] = new int[v][v];
        int e = sc.nextInt();
        for(int i = 0; i < e; i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        BFS(adjMatrix);
    }
}


/*
// only for connected graph

public class Solution 
{
    // Iterative Approach
    public static void BFS(int adjMatrix[][])
    {
        if(adjMatrix.length == 0)
        {
            return;
        }
        Queue<Integer> pendingVertex = new LinkedList<>();
        boolean visitedVertex[] = new boolean[adjMatrix.length];
        pendingVertex.add(0);
        visitedVertex[0] = true;
        while(!pendingVertex.isEmpty())
        {
            int currentVertex = pendingVertex.poll();
            System.out.print(currentVertex + " ");
            for(int i = 0; i < adjMatrix.length; i++)
            {
                if(adjMatrix[currentVertex][i] == 1 && visitedVertex[i] == false)
                {
                    pendingVertex.add(i);
                    visitedVertex[i] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int adjMatrix[][] = new int[v][v];
        int e = sc.nextInt();
        for(int i = 0; i < e; i++)
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        BFS(adjMatrix);
    }
}
*/