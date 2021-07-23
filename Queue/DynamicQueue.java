/*
Problem Statement :
Dynamic queue.
*/


public class DynamicQueue
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
	
	public void enqueue(int element)
	{
		if(size == data.length)   //Queue is full. Expand the size of the queue.
		{
			doubleCapacity();
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
	
	private void doubleCapacity()
	{
		int temp[] = data;
		data = new int[2 * temp.length];
		int index = 0;
		//copy in fifo sequence
		for(int i = front; i < temp.length; i++)
		{
			data[index++] = temp[i];
		}
		for(int i = 0; i < front - 1; i++)
		{
			data[index++] = temp[i];
		}
		front = 0;
		rear = temp.length - 1;
	}
}

