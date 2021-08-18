/*
Remove duplicate elements from array.
*/


import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
public class inbuiltMapUse 
{
	public static ArrayList<Integer> removeDuplicates(int arr[])
	{
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++)
		{
			if(map.containsKey(arr[i]))
			{
				continue;
			}
			output.add(arr[i]);
			map.put(arr[i], true);
		}
		return output;
	}
	
	public static void main(String args[])
	{
		int arr[] = {1,3,5,4,1,2,1,2,2,9,6,4,6,3};
		ArrayList<Integer> output = removeDuplicates(arr);
		System.out.println(output);
	}
}

