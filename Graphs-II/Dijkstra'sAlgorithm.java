/*
Problem Statement :
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using 
Dijkstra's Algorithm.

Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi 
(separated by space)

Output Format :
For each vertex, print its vertex number and its distance from source, in a separate line. The vertex number and its distance needs to be 
separated by a single space.

Note : Order of vertices in output doesn't matter.
*/


import java.util.Scanner;

public class Solution 
{
    public static int findMinVertex(boolean visited[], int distance[])
    {
        int v = visited.length;
        int minVertex = -1;
        for(int i = 0; i < v; i++)
        {
            if(!visited[i] && (minVertex == -1 || distance[minVertex] > distance[i]))
            {
                minVertex = i;
            }
        }
        return minVertex;
    }
    
    public static int[] dijkstras(int adjMatrix[][])
    {
        int v = adjMatrix.length;
        boolean visited[] = new boolean[v];
        int distance[] = new int[v];
        distance[0] = 0;    // source vertex
        for(int i = 1; i < v; i++)
        {
            distance[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < v; i++)
        {
            int minVertex = findMinVertex(visited, distance);
            visited[minVertex] = true;
            for(int j = 0; j < v; j++)
            {
                // unvisited neighbor
                if(adjMatrix[minVertex][j] > 0 && !visited[j])
                {
                    int distanceViaMinVertex = distance[minVertex] + adjMatrix[minVertex][j];
                    if(distance[j] > distanceViaMinVertex)
                    {
                        // update distance
                        distance[j] = distanceViaMinVertex;
                    }
                }
            }
        }
        return distance;
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
        
        int distance[] = dijkstras(adjMatrix);
        
        // printing vertex and it's minimum distance from source
        for(int i = 0; i < v; i++)
        {
            System.out.println(i + " " + distance[i]);
        }
    }
}