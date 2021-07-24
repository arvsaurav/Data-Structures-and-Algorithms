/*
Problem Statement :
You have been given a queue that can store integers as the data. 
You are required to write a function that reverses the populated queue itself 
without using any other data structures.

Input Format:
The first list of input contains an integer 't' denoting the number of test cases/queries to be run.
Then the test cases follow.
The first line input for each test case/query contains an integer N, denoting the total number of elements in the queue.
The second line of input contains N integers separated by a single space, representing the order in which the elements 
are enqueued into the queue.

Output Format:
For each test case/query, the only line of output prints the order in which the queue elements are dequeued, 
all of them separated by a single space.
Output for every test case/query will be printed on a new line. 
*/

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void reverseQueue(Queue<Integer> queue) {
        //since we don't have to use any other data structure, therefore, we will use recursion.
		if(queue.size() <= 1)
        {
            return;
        }
        int temp = queue.peek();
        queue.remove();
        reverseQueue(queue);
        queue.add(temp);
	}

}


//Driver Code :
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Runner {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static Queue<Integer> takeInput() throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine().trim());

		String[] values = br.readLine().trim().split(" ");

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(values[i]));
		}

		return queue;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int t = Integer.parseInt(br.readLine().trim());

		while (t > 0) {
			Queue<Integer> queue = takeInput();
			Solution.reverseQueue(queue);

			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}

			System.out.println();

			t -= 1;
		}
	}
}