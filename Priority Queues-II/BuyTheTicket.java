/*
Problem Statement :
You want to buy a ticket for a well-known concert which is happening in your city. 
But the number of tickets available is limited. Hence the sponsors of the concert decided 
to sell tickets to customers based on some priority.

A queue is maintained for buying the tickets and every person is attached with a priority 
(an integer, 1 being the lowest priority).

The tickets are sold in the following manner -
1. The first person (pi) in the queue requests for the ticket.
2. If there is another person present in the queue who has higher priority than pi, 
   then ask pi to move at end of the queue without giving him the ticket.
3. Otherwise, give him the ticket (and don't make him stand in queue again).

Giving a ticket to a person takes exactly 1 minute and it takes no time for removing and adding a person to the queue. 
And you can assume that no new person joins the queue.
Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). 
Find and return the time it will take until you get the ticket.
*/




import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Collections;
public class Solution 
{	
    public static int buyTicket(int arr[], int k) 
    {
        Queue<Integer> queue = new LinkedList<>();
        //since elements are repeated, we will be more specific to kth index instead of kth person's priority.
        //therefore, add index to queue.
        // queue -> queue of people
	for(int i = 0; i < arr.length; i++)
        {
            queue.add(i);
        }
        //to fetch highest priority in O(1), we will use priority queue.
        //max priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++)
        {
            pq.add(arr[i]);
        }
        int time = 0;
        while(!queue.isEmpty())
        {
            if(arr[queue.peek()] < pq.peek())
            {
                queue.add(queue.poll());
            }
            else
            {
                int temp = queue.poll();
                pq.poll();
                time++;
                if(temp == k)
                    break;
            }
        }
        return time;
    }
}