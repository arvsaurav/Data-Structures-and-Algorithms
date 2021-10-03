/*
Problem Statement :
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. 
Print true if the path exists and false otherwise.

Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.

Output Format :
The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution 
{
    public static boolean BFS(int adjMatrix[][], int v1, int v2)
    {
        if(adjMatrix.length == 0)
        {
            return false;
        }
        Queue<Integer> pendingVertex = new LinkedList<>();
        boolean visitedVertex[] = new boolean[adjMatrix.length];
        pendingVertex.add(v1);
        visitedVertex[v1] = true;
        while(!pendingVertex.isEmpty())
        {
            int currentVertex = pendingVertex.poll();
            for(int i = 0; i < adjMatrix.length; i++)
            {
                if(adjMatrix[currentVertex][i] == 1 && visitedVertex[i] == false)
                {
                    // path found
                    if(i == v2)
                    {
                        return true;
                    }
                    pendingVertex.add(i);
                    visitedVertex[i] = true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int adjMatrix[][] = new int[v][v];
        int e = sc.nextInt();
        for(int i = 0; i < e; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adjMatrix[a][b] = 1;
            adjMatrix[b][a] = 1;
        }
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();
        boolean hasPath = BFS(adjMatrix, v1, v2);
        System.out.println(hasPath);
    }
}