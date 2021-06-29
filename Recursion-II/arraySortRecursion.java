public class arraySortRecursion 
{
    public static boolean isSorted(int[] a)
    {
        if(a.length == 1)
        {
            return true;
        }
        if(a[0] > a[1])
        {
            return false;
        }
        int b[] = new int[a.length - 1];
        for(int i = 1; i < a.length; i++)
        {
            b[i-1] = a[i];
        }
        return isSorted(b);    
    }
    public static void main(String args[])
    {
        int a[] = {1,2,3,4,5};
        System.out.println(isSorted(a));
    }
    
}
