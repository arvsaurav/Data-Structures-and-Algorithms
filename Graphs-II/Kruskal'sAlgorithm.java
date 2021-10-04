/*
Problem Statement :
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.

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
import java.util.Arrays;

public class Solution
{    
    private static int findParent(int v, int parent[])
    {
        // base case
        if(v == parent[v])
        {
            return v;
        }
        return findParent(parent[v], parent);
    }
    
    public static Edge[] kruskalAlgorithm(Edge edgeList[], int v)
    {
        Arrays.sort(edgeList);
        // final output array
        // MST will have (v-1) edges
        Edge mst[] = new Edge[v-1];
        
        // keep track of parent array for Union Find Algorithm
        int parent[] = new int[v];
        for(int i = 0; i < v; i++)
        {
            parent[i] = i;
        }
        
        int count = 0;
        int i = 0;
        // start picking edge one by one until (count != v-1)
        while(count != v-1)
        {
            Edge currentEdge = edgeList[i++];
            int v1Parent = findParent(currentEdge.v1, parent);
            int v2Parent = findParent(currentEdge.v2, parent);
            if(v1Parent != v2Parent)
            {
                // include current edge in MST
                mst[count] = currentEdge;
                count++;
                // update parent
                parent[v1Parent] = v2Parent;
            }
        }
        return mst;
    }
    
    public static void main(String[] args)
    {
	Scanner sc = new Scanner(System.in);
	int v = sc.nextInt();
	int e = sc.nextInt();
        Edge edgeList[] = new Edge[e];
        
        // taking input and storing graph in Edge-List
	for(int i = 0; i < e; i++) 
        {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int w = sc.nextInt();
            Edge edge = new Edge(v1, v2, w);
            edgeList[i] = edge;
        }
        
        // will return the final MST array
	Edge mst[] = kruskalAlgorithm(edgeList, v);

	// printing final MST
        for(int i = 0; i < mst.length; i++)
        {
            if(mst[i].v1 <= mst[i].v2)
            {
                System.out.println(mst[i].v1 + " " + mst[i].v2 + " " + mst[i].weight);
            }
            else
            {
                System.out.println(mst[i].v2 + " " + mst[i].v1 + " " + mst[i].weight);
            }
        }
    }
}

// we have implemented Comparable interface so that we can sort the edgeList using Inbuilt sort.

class Edge implements Comparable<Edge>
{
    int v1;
    int v2;
    int weight;
    
    public Edge(int v1, int v2, int weight)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Edge edge)
    {
    	return this.weight - edge.weight;
    }
}