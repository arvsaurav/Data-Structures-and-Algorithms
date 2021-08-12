/*
Problem Statement :
Sort an array A using Quick Sort.
Change in the input array itself. So no need to return or print anything.

Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)

Output format :
Array elements in increasing order (separated by space)
*/


//Driver Code :
import java.util.Scanner;

public class Runner {
	
	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		Solution.quickSort(input);
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}



public class Solution 
{
    public static void quickSort(int a[])
    {
		quickSort(a, 0, a.length - 1);
    }
    
    public static int partition(int arr[], int startIndex, int endIndex)
    {
        int pivotElement = arr[startIndex];
        int smallNumCount = 0;

        //counting number of elements less than pivotElement
        for(int i = startIndex + 1; i <= endIndex; i++)
        {
            if(arr[i] < pivotElement)
            {
                smallNumCount++;
            }
        }

        //shifting pivotElement to it's proper position.
        int temp = arr[startIndex + smallNumCount];
        arr[startIndex + smallNumCount] = arr[startIndex];
        arr[startIndex] = temp;

        int i = startIndex;       //Because we can't change startIndex because we have to use it in the return statement.
        int j = endIndex;
        //shifting all smaller element on left of pivotElement and greater or equal element on the right of the pivot element.
        while(i < j)
        {
            if(arr[i] < pivotElement)
            {
                i++;
            }
            else if(arr[j] >= pivotElement)
            {
                j--;
            }
            else           //swapping required
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return startIndex + smallNumCount;
    }

    public static void quickSort(int arr[], int startIndex, int endIndex)
    {
        if(startIndex >= endIndex)
        {
            return;
        }
        //partition method will return the proper position (i.e., index) of arr[0] after comparing it with other elements. 
        int pivotIndex = partition(arr, startIndex, endIndex);
        //quick sort on left part of the array.
        quickSort(arr, startIndex, pivotIndex - 1);
        //quick sort on right part of the array.
        quickSort(arr, pivotIndex + 1, endIndex);
    }

}


