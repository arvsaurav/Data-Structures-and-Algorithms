/*
Implementation of MIN Heap priority queue.
*/


public class priorityQueueUse 
{
	public static void main(String args[]) throws PriorityQueueException
	{
		PriorityQueue<String> queue = new PriorityQueue<>();
		queue.insert("abc", 15);
		queue.insert("def", 13);
		queue.insert("fsas", 90);
		queue.insert("fsasasa", 150);
		queue.insert("xyzxyx", 120);
		while(!queue.isEmpty())
		{
			System.out.println(queue.getMin());
			System.out.println("Removed element is : " + queue.removeMin());
		}
	}
}






import java.util.ArrayList;

//MIN Heap
public class PriorityQueue<T>
{
	private ArrayList<Element<T>> heap;
	//constructor
	public PriorityQueue()
	{
		heap = new ArrayList<>();
	}
	
	//insert element in priority queue
	public void insert(T value, int priority)
	{
		//at first insert the element at the last position.
		Element<T> element = new Element<>(value, priority);
		heap.add(element);
		
		//now, we have to maintain MIN heap property.
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		//childIndex == 0 -> root of the tree i.e., no parent of this node.
		while(childIndex > 0)
		{
			if(heap.get(parentIndex).priority > heap.get(childIndex).priority)
			{
				//swap elements
				Element<T> temp = heap.get(parentIndex);
				heap.set(parentIndex, heap.get(childIndex));
				heap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			}
			else
			{
				return;
			}
		}
	}
	
	//returns the minimum value
	public T getMin() throws PriorityQueueException
	{
		if(heap.isEmpty())
		{
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}
	
	//remove MIN and return the removed value
	public T removeMin() throws PriorityQueueException
	{
		if(heap.isEmpty())
		{
			throw new PriorityQueueException();
		}
		Element<T> removedElement = heap.get(0);
		T removedElementValue = removedElement.value;
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		//now, we have to check whether our remaining priority queue follows MIN heap property or not.
		//if not, then modify it in such a way that it will follow MIN heap property.
		int parentIndex = 0;
		int leftChildIndex = 2*parentIndex + 1;
		int rightChildIndex = 2*parentIndex + 2;
		
		//execute while loop till we reach the bottom level of tree.(level wise traversal)
		//if we reach the bottom level of tree then it doesn't have any child 
		//therefore, no need to compare with child priorities. So, we must stop here.
		//In case of CBT, if we don't have left child then it is sure that we also don't have the right child.
		//Therefore, we have to only check whether left child is present or not.
		//if not then, terminate the while loop.
		while(leftChildIndex < heap.size())
		{
			int minIndex =  parentIndex;   //minimum priority element index                         
			if(heap.get(minIndex).priority > heap.get(leftChildIndex).priority)
			{
				minIndex = leftChildIndex;
			}
			//rightChildIndex < heap.size() --> because there can be a case where a node have only left child
			//so, for accessing right child's priority first we have to be sure that right child exists. 
			if(rightChildIndex < heap.size() && heap.get(minIndex).priority > heap.get(rightChildIndex).priority)
			{
				minIndex = rightChildIndex;
			}
			if(minIndex == parentIndex)
			{
				break;
			}
			Element<T> temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex = minIndex;
			leftChildIndex = 2*parentIndex + 1;
			rightChildIndex = 2*parentIndex + 2;
		}
		
		return removedElementValue;
	}
	
	//returns size of the priority queue
	public int size()
	{
		return heap.size();
	}
	
	//returns true if priority queue is empty
	public boolean isEmpty()
	{
		return heap.isEmpty();
	}
	
}




public class Element<T> 
{
	T value;  // value can be integer, character, string, etc.
	int priority;
	public Element(T value, int priority)
	{
		this.value = value;
		this.priority = priority;
	}
}




@SuppressWarnings("serial")
public class PriorityQueueException extends Exception 
{
	public PriorityQueueException()
	{
		System.out.println("Priority Queue is empty.");
	}
}


