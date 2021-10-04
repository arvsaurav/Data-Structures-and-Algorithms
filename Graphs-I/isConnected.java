/*
Problem Statement :
Given an undirected graph G(V,E), check if the graph G is connected graph or not.

Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.

Output Format :
The first and only line of output contains "true" if the given graph is connected or "false", otherwise.
*/


import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution 
{
    public static boolean isConnected(int adjMatrix[][])
    {
        if(adjMatrix.length == 0)
        {
            return true;
        }
        boolean visitedVertex[] = new boolean[adjMatrix.length];
        Queue<Integer> pendingVertex = new LinkedList<>();
        pendingVertex.add(0);
        visitedVertex[0] = true;
        while(!pendingVertex.isEmpty())
        {
            int currentVertex = pendingVertex.poll();
            for(int i = 0; i < adjMatrix.length; i++)
            {
                if(adjMatrix[currentVertex][i] == 1 && visitedVertex[i] == false)
                {
                    pendingVertex.add(i);
                    visitedVertex[i] = true;
                }
            }
        }
        for(int i = 0; i < adjMatrix.length; i++)
        {
            if(visitedVertex[i] == false)
            {
                return false;
            }
        }
        return true;
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
        boolean ans = isConnected(adjMatrix);
        System.out.println(ans);
    }
}