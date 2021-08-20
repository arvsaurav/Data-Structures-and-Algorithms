/*
Problem Statement :
You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. 
You need to print their intersection. An intersection for this problem can be defined when 
both the arrays/lists contain a particular value or to put it in other words, 
when there is a common value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.
The intersection elements printed would be in the order they appear in the first sorted array/list (ARR1).
*/


import java.util.HashMap;
import java.util.Arrays;
import java.lang.Math;
public class Solution 
{
    public static void printIntersection(int[] arr1,int[] arr2)
    {
	HashMap<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < arr1.length; i++)
        {
            if(map.containsKey(arr1[i]))
            {
                int val = map.get(arr1[i]);
                map.put(arr1[i], val+1);
            }
            else
            {
                map.put(arr1[i], 1);
            }
        }
        Arrays.sort(arr2);
        for(int i = 0; i < arr2.length; i++)
        {
	    if(map.containsKey(arr2[i]))
            {
                int freq = map.get(arr2[i]);
                if(freq > 0)
                {
                    System.out.println(arr2[i]);
                    freq = freq - 1;
                    map.put(arr2[i], freq);
                }
            }
        }
    }
}





/*
//Alternate approach :
public class Solution 
{
    public static void printIntersection(int[] arr1,int[] arr2)
    {
	HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        Arrays.sort(arr1);
        //hashmap for arr1
        for(int i = 0; i < arr1.length; i++)
        {
            if(map1.containsKey(arr1[i]))
            {
                int val = map1.get(arr1[i]);
                map1.put(arr1[i], val+1);
            }
            else
            {
                map1.put(arr1[i], 1);
            }
        }
        //hashmap for arr2
        for(int i = 0; i < arr2.length; i++)
        {
            if(map2.containsKey(arr2[i]))
            {
                int val = map2.get(arr2[i]);
                map2.put(arr2[i], val+1);
            }
            else
            {
                map2.put(arr2[i], 1);
            }
        }
        for(int i = 0; i < arr1.length; i++)
        {
            if(map1.containsKey(arr1[i]) && map2.containsKey(arr1[i]))
            {
		int temp = Math.min(map1.get(arr1[i]), map2.get(arr1[i]));
                while(temp > 0)
                {
                    System.out.println(arr1[i]);
                    temp--;
                }
                map1.remove(arr1[i]); 
            }
        }
    }
}
*/