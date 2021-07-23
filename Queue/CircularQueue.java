/*
Problem Statement :
Implement Circular Queue.
*/

public class CircularQueue
{
	public static void main(String args[]) throws QueueFullException, QueueEmptyException
	{
		Queue queue = new Queue();
		queue.enqueue(2);
		queue.enqueue(4);
		//System.out.println(queue.size());
		System.out.println(queue.dequeue());
		queue.enqueue(4);
		queue.enqueue(4);
		queue.enqueue(4);
		//queue.enqueue(4);
	}
}


class Queue{

	private int data[];
	private int front;
	private int rear;
	private int size;
	//by default
	public Queue()
	{
		data = new int[5];
		front = -1;
		rear = -1;
		size = 0;
	}
	//for desired queue size.
	public Queue(int capacity)
	{
		data = new int[capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		if(size == 0)
		{
			return true;
		}
		return false;
	}
	
	public int front() throws QueueEmptyException
	{
		if(size == 0)
		{
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
	public void enqueue(int element) throws QueueFullException
	{
		if(size == data.length)   //Queue is full.
		{
			throw new QueueFullException();
		}
		if(size == 0)    //queue is empty.
		{
			front = 0;
		}
		/*
		rear += 1;
		if(rear == data.length)
		{
			rear = 0;
		}
		*/
		//Alternate :
		rear = (rear + 1) % data.length;
		
		data[rear] = element;
		size += 1;
	}
	
	public int dequeue() throws QueueEmptyException
	{
		if(size == 0)   //Queue is empty.
		{
			throw new QueueEmptyException();
		}
		int temp = data[front];
		/*
		front += 1;
		if(front == data.length)
		{
			front = 0;
		}
		*/
		//Alternate :
		front = (front + 1) % data.length;
		
		size -= 1;
		if(size == 0)
		{
			front = -1;
			rear = -1;
		}
		return temp;
	}
}

