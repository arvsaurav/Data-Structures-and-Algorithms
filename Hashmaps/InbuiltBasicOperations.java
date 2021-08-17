/*
Inbuilt HashMap basic operations.
*/


import java.util.HashMap;
import java.util.Set;
public class inbuiltMapUse 
{
	public static void main(String args[])
	{
		HashMap<String, Integer> map = new HashMap<>();
		//insert
		map.put("abc", 2);
		map.put("pqr", 3);
		
		//check whether key is present or not
		if(map.containsKey("abc"))
		{
			System.out.println("map has abc");
		}
		
		System.out.println(map.containsKey("abc"));  //returns true or false
		
		if(map.containsKey("lmn"))
		{
			System.out.println("map has lmn");
		}
		
		//update key
		map.put("abc", 1);
		
		//get value
		int i = map.get("abc");
		System.out.println(i);
		
		/*
		//getting value of that key which is not present in HashMap
		int j = map.get("lmn");  //it will throw null pointer exception
		System.out.println(j);
		*/
		
		//to avoid null pointer exception first check whether key is present in HashMap or not.
		int j = 0;
		if(map.containsKey("lmn"))
		{
			j = map.get("lmn");
		}
		System.out.println(j);
		
		
		//remove
		map.remove("abc"); 
		
		//size of map
		System.out.println("Size of map is " + map.size());
		
		//iterate 
		Set<String> keys = map.keySet();  // map.keySet() returns all keys of HashMap in Set format.
		//print all keys
		for(String str : keys)   //there is no concept of indexing
		{
			System.out.println(str);
		}
		
	}

}





