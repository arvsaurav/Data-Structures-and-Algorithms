/*
Problem Statement :
For a given queue containing all integer data, reverse the first K elements.
You have been required to make the desired change in the input queue itself.

Input Format :
The first line of input would contain two integers N and K, separated by a single space. 
They denote the total number of elements in the queue and the count with which the elements 
need to be reversed respectively.
The second line of input contains N integers separated by a single space, representing the 
order in which the elements are enqueued into the queue.

Output Format:
The only line of output prints the updated order in which the queue elements are dequeued, 
all of them separated by a single space. 

Contraints :
1 <= N <= 10^6
1 <= K <= N
-2^31 <= data <= 2^31 - 1
 
Time Limit: 1sec
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public static Queue<Integer> reverseKElements(Queue<Integer> queue, int k) {
		//Your code goes here
        if(queue.size() <= 1 || k <= 0)
        {
            return queue;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int temp;
        while(i < k)
        {
            stack.push(queue.remove());
            /*
            temp = queue.peek();
            queue.remove();
            stack.push(temp);
            */
            i++;
        }
        while(!stack.isEmpty())
        {
            queue.add(stack.pop());
        }
        i = 0;
        while(i < queue.size() - k)
        {
            queue.add(queue.remove());
            /*
			temp = queue.peek();
            queue.remove();
            queue.add(temp);
            */
            i++;
        }
        return queue;
	}

}



//Driver Code :
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Input {
	int n;
	int k;
	Queue<Integer> queue;

	public Input(int n, int k, Queue<Integer> queue) {
		this.queue = queue;
		this.n = n;
		this.k = k;
	}

}

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {
    	String[] n_k = br.readLine().trim().split(" ");

    	int n = Integer.parseInt(n_k[0]);
    	int k = Integer.parseInt(n_k[1]);

    	String[] values = br.readLine().trim().split(" ");

    	Queue<Integer> queue = new LinkedList<>();

    	for (int i = 0; i < n; i++) {
    		queue.add(Integer.parseInt(values[i]));
    	}

    	return new Input(n, k, queue);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	Input input = takeInput();

    	int n = input.n;
    	int k = input.k;
    	Queue<Integer> queue = input.queue;

    	queue = Solution.reverseKElements(queue, k);


    	while (!queue.isEmpty()) {
    		System.out.print(queue.poll() + " ");
    	}
    }
}