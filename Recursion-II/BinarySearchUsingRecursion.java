import javax.lang.model.util.ElementScanner14;

public class BinarySearchUsingRecursion 
{
    public static int BinarySearch(int arr[], int startIndex, int endIndex, int x)
    {
        if(startIndex > endIndex)
            return -1;
        int midIndex = (startIndex + endIndex) / 2;
        if(arr[midIndex] == x)
        {
            return midIndex;
        }
        else if(arr[midIndex] < x)
        {
            //element must be present in the right partition of array.
            return BinarySearch(arr, midIndex + 1, endIndex, x);
        }
        else
        {
            //element must be present in the left partition of array.
            return BinarySearch(arr, startIndex, midIndex - 1, x);
        }
    }

    public static void main(String[] args) 
    {
        int a[] = {1,2,3,4,5,6};
        System.out.println(BinarySearch(a, 0, a.length - 1, 2));
    }
    
}
