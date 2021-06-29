public class arraySortOptimisedRecursion 
{
    public static boolean isSorted(int arr[], int startingIndex)
    {
        if(startingIndex == arr.length - 1)
        {
            return true;
        }
        if(arr[startingIndex] > arr[startingIndex + 1])
        {
            return false;
        }
        boolean isSubarraySorted = isSorted(arr, startingIndex + 1);;
        return isSubarraySorted;
    }

    public static void main(String args[])
    {
        int arr[] = {1,3,2,4,5};
        System.out.println(isSorted(arr, 0));
    }
    
}
