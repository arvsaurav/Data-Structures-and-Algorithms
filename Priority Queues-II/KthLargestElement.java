/*
Problem Statement :
Given an array A of random integers and an integer k, find and return the kth largest element in the array.

Note: Try to do this question in less than O(N * logN) time.
*/



import java.util.PriorityQueue;
public class Solution 
{
    public static int kthLargest(int n, int[] arr, int k) 
    {
	PriorityQueue<Integer> pq = new PriorityQueue<>();
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
            if(arr[i] > pq.peek())
            {
                int temp = arr[i];
                arr[i] = pq.poll();
                pq.add(temp);
            }
        }
        return pq.peek();
    }
}