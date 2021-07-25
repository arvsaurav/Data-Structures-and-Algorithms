//Alternate Method :
//(Using recursion)
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution
{
    public static Queue<Integer> reverseKElements(Queue<Integer> queue, int k)
    {
		subReverse(queue, k);  // if we will give input queue -> 1 2 3 4 5, output queue -> 4 5 3 2 1
        int i = 0;
        while(i < queue.size() - k)
        {
            queue.add(queue.remove());
            i++;
        }
        return queue;
    }
    
    public static void subReverse(Queue<Integer> queue, int k)
    {
        if(queue.size() <= 1 || k <= 0)
        {
            return;
        }
        int temp = queue.remove();
        subReverse(queue, k-1);
        queue.add(temp);
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