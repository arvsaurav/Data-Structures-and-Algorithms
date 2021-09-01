/*
Problem Statement :
You are given with an integer k and an array of integers that contain numbers in random order. 
Write a program to find k smallest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(n * logk) and space complexity should not be more than O(k).

Note: Order of elements in the output is not important.
*/


import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Collections;
public class Solution 
{
    public static ArrayList<Integer> kSmallest(int n, int[] arr, int k) 
    {
        //max priority queue
	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = k;
        int j = 0;
        while(i > 0)
        {
	    pq.add(arr[j]);
            j++;
            i--;
        }
	for(i = k; i < n; i++)
        {
            if(pq.peek() > arr[i])
            {
                int temp = arr[i];
                arr[i] = pq.poll();
                pq.add(temp);
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        while(!pq.isEmpty())
        {
	    output.add(pq.poll());
        }
        return output;
    }
}