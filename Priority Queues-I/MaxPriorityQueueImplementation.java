/*
Problem Statement :
Implement the class for Max Priority Queue which includes following functions -
1. getSize -
Return the size of priority queue i.e. number of elements present in the priority queue.
2. isEmpty -
Check if priority queue is empty or not. Return true or false accordingly.
3. insert -
Given an element, insert that element in the priority queue at the correct position.
4. getMax -
Return the maximum element present in the priority queue without deleting. Return -Infinity if priority queue is empty.
5. removeMax -
Delete and return the maximum element present in the priority queue. Return -Infinity if priority queue is empty.
Note : main function is given for your reference which we are using internally to test the class.
*/




import java.util.ArrayList;
public class PQ 
{
    private ArrayList<Integer> heap;
    //constructor
    public PQ()
    {
	heap = new ArrayList<>();
    }
    
    boolean isEmpty() 
    {
	return heap.isEmpty();
    }

    int getSize() 
    {
	return heap.size();
    }

    int getMax() //throws PriorityQueueException
    {
	// if(heap.isEmpty())
	// {
	    // throw new PriorityQueueException();
	// }
        return heap.get(0);
    }

    void insert(int element) 
    {
	heap.add(element);
        upHeapify();
    }
    void upHeapify()
    {
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex -1) / 2;
        while(childIndex > 0)
        {
            if(heap.get(childIndex) > heap.get(parentIndex))
            {
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
            else
            {
                return;
            }
        }
    }

    int removeMax() //throws PriorityQueueException
    {
        // if(heap.isEmpty())
        // {
        //     throw new PriorityQueueException();
        // }
        int removedElement = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        downHeapify();
        return removedElement;
    }
    void downHeapify()
    {
	int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        int maxIndex = parentIndex;
        while(leftChildIndex < heap.size())
        {
	    if(heap.get(maxIndex) < heap.get(leftChildIndex))
            {
                maxIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(maxIndex) < heap.get(rightChildIndex))
            {
                maxIndex = rightChildIndex;
            }
            if(maxIndex == parentIndex)
            {
                break;
            }
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(maxIndex));
            heap.set(maxIndex, temp);
            parentIndex = maxIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
            maxIndex = parentIndex;
        }
    }
}

// class PriorityQueueException extends Exception
// {

// }
