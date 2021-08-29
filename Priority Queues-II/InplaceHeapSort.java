/*
Problem Statement :
Given an integer array of size N. Sort this array (in decreasing order) using heap sort.

Note: Space complexity should be O(1).
*/



public class Solution 
{
    public static void inplaceHeapSort(int arr[]) 
    {
	// Change in the given input itself.
	for(int i = 0; i < arr.length; i++)
        {
            upHeapify(i, arr);
        }
        
        int j = arr.length - 1;
        for(int i = 0; i < arr.length; i++)
        {
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            downHeapify(j, arr);
            j--;
        }
    }
    
    public static void downHeapify(int endIndex, int[] arr)
    {
        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
        while(leftChildIndex < endIndex)
        {
            int minIndex = parentIndex;
            if(arr[minIndex] > arr[leftChildIndex])
            {
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < endIndex && arr[minIndex] > arr[rightChildIndex])
            {
                minIndex = rightChildIndex;
            }
            if(minIndex == parentIndex)
            {
                return;
            }
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
    }
    
    public static void upHeapify(int i, int[] arr)
    {
	int childIndex = i;
        int parentIndex = (childIndex-1)/2;
        while(childIndex > 0)
        {
            if(arr[parentIndex] > arr[childIndex])
            {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[childIndex];
                arr[childIndex] = temp;
            }
            else
            {
                return;
            }
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }
}