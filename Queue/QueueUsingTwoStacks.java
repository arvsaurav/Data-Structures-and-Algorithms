import java.util.Stack;
public class QueueUsingTwoStack {
	public static void main(String args[])
	{
		Queue queue = new Queue();
		queue.enqueue(5);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}


class Queue
{
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	public void enqueue(int element)
	{
		while(!s1.isEmpty())    //all elements of s1 will be pushed to s2.
		{
			s2.push(s1.pop());
		}
		s1.push(element);    //enqueued element is pushed in s1.
		while(!s2.isEmpty())     //all elements of s2 will be pushed to s1.
		{
			s1.push(s2.pop());
		}
	}
	
	public int dequeue()
	{
		if(s1.isEmpty())
		{
			System.out.println("Queue is empty.");
			return -1;
		}
		int temp = s1.peek();
		s1.pop();
		return temp;
	}
}