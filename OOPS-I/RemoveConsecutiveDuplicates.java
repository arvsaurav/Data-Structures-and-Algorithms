import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class RemoveConsecutiveDuplicates
{
    public static void main(String[] args) 
    {
        int arr[] = {10, 10, 20, 20, 20, 30, 40, 10};
        ArrayList<Integer> result = removeConsecutiveDuplicate(arr);
        for(int i : result)
        {
            System.out.println(i);
        }
    }

    public static ArrayList<Integer> removeConsecutiveDuplicate(int arr[])
    {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] != arr[i-1])
            {
                result.add(arr[i]);
            }
        }
        return result;
    }
}
