/*
Problem Statement :
Implement queue using array.
*/



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
		if(rear == data.length-1)   //Queue is full.
		{
			throw new QueueFullException();
		}
		if(size == 0)    //queue is empty.
		{
			front = 0;
		}
		rear += 1;
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
		front += 1;
		size -= 1;
		if(size == 0)
		{
			front = -1;
			rear = -1;
		}
		return temp;
	}
}

public class QueueUsingArray
{
	public static void main(String args[]) throws QueueFullException, QueueEmptyException
	{
		Queue queue = new Queue();
		queue.enqueue(2);
		queue.enqueue(4);
		System.out.println(queue.size());
		System.out.println(queue.dequeue());
	}
}



public class QueueFullException extends Exception {
	public QueueFullException()
	{
		System.out.println("Queue is full.");
	}
}



public class QueueEmptyException extends Exception {
	public QueueEmptyException()
	{
		System.out.println("Queue is empty.");
	}

}
