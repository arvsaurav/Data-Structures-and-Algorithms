/*
Problem Statement :
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). 
Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.

Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.

Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
The following line contain two integers, that denote the value of v1 and v2.

Output Format :
Print the path from v1 to v2 in reverse order.
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution 
{	
    public static ArrayList<Integer> getPath(int adjMatrix[][], int source, int destination)
    {
        boolean visitedVertex[] = new boolean[adjMatrix.length];
        Queue<Integer> pendingVertex = new LinkedList<>();
        // (key, value) -> (vertex, parent of this vertex)
        HashMap<Integer, Integer> map = new HashMap<>();
        pendingVertex.add(source);
        visitedVertex[source] = true;
        map.put(source, -1);
        
        while(!pendingVertex.isEmpty())
        {
            int currentVertex = pendingVertex.poll();
            for(int i = 0; i < adjMatrix.length; i++)
            {
		if(adjMatrix[currentVertex][i] == 1 && visitedVertex[i] == false)
                {
                    pendingVertex.add(i);
                    visitedVertex[i] = true;
                    map.put(i, currentVertex);  // parent of i will be currentVertex
                    if(i == destination)
                    {
                        return getPath(map, destination);
                    }
                }
            }
        }
        // path not found
        return null;
    }
    // helper function
    public static ArrayList<Integer> getPath(HashMap<Integer, Integer> map, int val)
    {
        ArrayList<Integer> path = new ArrayList<>();
        while(map.get(val) != -1)
        {
            path.add(val);
            val = map.get(val);
        }
        path.add(val);
        return path;
    }
    
    public static void main(String[] args)  throws NumberFormatException, IOException
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