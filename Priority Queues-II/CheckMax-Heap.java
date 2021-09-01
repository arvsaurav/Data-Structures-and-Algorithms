/*
Problem Statement :
Given an array of integers, check whether it represents max-heap or not. 
Return true if the given array represents max-heap, else return false.
*/



public class Solution 
{
    public static boolean checkMaxHeap(int arr[]) 
    {
        int parentIndex = 0;
        int leftChildIndex = 2*parentIndex + 1;
        int rightChildIndex = 2*parentIndex + 2;
	while(leftChildIndex < arr.length)
        {
            if(arr[leftChildIndex] > arr[parentIndex])
                return false;
            if(rightChildIndex < arr.length && arr[rightChildIndex] > arr[parentIndex])
                return false;
            parentIndex++;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
        return true;
    }
}