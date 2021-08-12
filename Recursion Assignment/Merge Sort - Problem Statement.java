/*
Problem Statement :
Sort an array A using Merge Sort.
Change in the input array itself. So no need to return or print anything.

Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)

Output format :
Array elements in increasing order (separated by space)
*/

//Driver Code :
import java.util.Scanner;

public class runner {
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		solution.mergeSort(input);
		printArray(input);
	}
}



public class solution 
{
    public static void merge(int s1[], int s2[], int f[])
    {
        int i = 0;  //for traversing s1
        int j = 0;  //for traversing s2
        int k = 0;  //for traversing f i.e, the final array output.
        
		//loop will execute and comparison will be done till any one of the subarrays not traversed completely.
        //if any one of the subarrays will be traversed completely, then the loop will be terminated because 
        //then the remaining elements will be present only in the one subarray which is already sorted.
        while(i < s1.length && j < s2.length)
        {
			if(s1[i] <= s2[j])
            {
				f[k] = s1[i];
                i++;
                k++;
            }
            else
            {
                f[k] = s2[j];
                j++;
                k++;
            }
        }
        
        //copying remaining element.
        
        if(i < s1.length)	//remaining elements are present in s1.
        {
            while(i < s1.length)
            {           
				f[k] = s1[i];
            	i++;
            	k++;
            }
        }
        if(j < s2.length)	//remaining elements are present in s2.
        {
            while(j < s2.length)
            {
				f[k] = s2[j];
            	j++;
            	k++;
            }
        }

    }

	public static void mergeSort(int a[])
    {
        if(a.length <= 1)
            return;     
		int mid = a.length / 2;
        int b[] = new int[mid];
        int c[] = new int[a.length - b.length];
        //copying left hallf of original array to b.
        for(int i = 0; i < mid; i++)
        {
			b[i] = a[i];
        }
        //copying right half of original array to c.
        for(int i = mid; i < a.length; i++)
        {
            c[i - mid] = a[i];
        }
        mergeSort(b);   //by hypothesis.
        mergeSort(c);   //by hypothesis.
		merge(b, c, a); //will merge sorted b and sorted c to the final array in sorted order.
	}
}

