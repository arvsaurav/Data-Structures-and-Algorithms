/*
Inbuilt Priority Queue.
*/


import java.util.PriorityQueue;
public class InbuiltPQ 
{
	public static void main(String args[])
	{
		int[] arr = {4,3,7,9,6,2,1};
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// by default it is MIN priority queue.
		for(int i = 0; i < arr.length; i++)
		{
			pq.add(arr[i]);
		}
		while(!pq.isEmpty())
		{
			System.out.println(pq.poll());
		}
	}
}
