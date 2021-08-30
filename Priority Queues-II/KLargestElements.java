/*
Problem Statement :
You are given with an integer k and an array of integers that contain numbers in random order. 
Write a program to find k largest numbers from given array. You need to save them in an array and return it.

Time complexity should be O(nlogk) and space complexity should be not more than O(k).
*/


import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution 
{
    public static ArrayList<Integer> kLargest(int arr[], int k) 
    {
	//min priority queue
	PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = k;
        int j = 0;
        while(i > 0)
        {
            pq.add(arr[j]);
            i--;
            j++;
        }
        for(i = k; i < arr.length; i++)
        {
            if(arr[i] > pq.peek())
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