/*
Implement your own hashmap.
*/


import java.util.ArrayList;
public class hashmapImplementation 
{
	public static void main(String args[])
	{
		Map<String, Integer> map = new Map<>();
		for(int i = 0; i < 20; i++)
		{
			map.insert("abc" + i, i+1);
			System.out.println("Load factor is : " + map.loadFactor());
		}
		map.removeKey("abc7");
		map.removeKey("abc10");
		for(int i = 0; i < 20; i++)
		{
			System.out.println("abc" + i + " : " + map.getValue("abc" + i));
		}
	}
}

//implementing using separate chaining
//Therefore, array of linked list
//since we can't create generic array in java
//therefore, we will create generic array list.	
//but we have to fix the array list size i.e., bucket size.
//because in separate chaining we want to store data at a particular index.
class Map<K, V>   //(key, value)
{
	ArrayList<MapNode<K, V>> buckets;
	int count;  //count of elements present in HashMap.
	int numBuckets; //bucket size
	public Map()
	{
		buckets = new ArrayList<>();
		numBuckets = 5;  //example
		for(int i = 0; i < numBuckets; i++)
		{
			buckets.add(null);
		}
	}
	
	
	private int getBucketIndex(K key)
	{
		int hc = key.hashCode();  //internal function for getting hash code.
		return hc%numBuckets;  //performing compression and returning the index.
	}
	
	//insertion in HashMap.
	public void insert(K key, V value)
	{
		int bucketIndex = getBucketIndex(key);
		//first we have to check if key is present or not.
		//if key is already present, update its value.
		//if key is not present then, add (key, value) pair.
		MapNode<K, V> head = buckets.get(bucketIndex);
		MapNode<K, V> temp = head;
		while(temp != null)
		{
			if(temp.key.equals(key))  //since, key is string.
			{
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		//execution of this line means key is not present there.
		MapNode<K, V> newNode = new MapNode<>(key, value);  //creating new map node.
		newNode.next = head;
		head = newNode;  //updated head
		buckets.set(bucketIndex, head);
		count++;
		double loadFactor = 1.0*(count) / numBuckets; // to make numerator double because 2/5=0 while, 2.0/5=0.4
		if(loadFactor > 0.7)  //we have to rehash
		{
			reHash();
		}
	}
	private void reHash()
	{
		//we can't simply copy linked list's head at index of array list i.e., buckets.
		//since, bucket size has changed, therefore, we have to perform compression again.
		ArrayList<MapNode<K, V>> oldBucket = buckets;
		buckets = new ArrayList<>();
		numBuckets = 2*numBuckets;  //double the size of bucket
		for(int i = 0; i < numBuckets; i++)  
		{
			buckets.add(null);
		}
		count = 0;
		// insert() will maintain count. (used inside while loop)
		for(int i = 0; i < oldBucket.size(); i++)
		{
			MapNode<K, V> head = oldBucket.get(i);  //will get head of linked list present at current index.
			while(head != null)
			{
				K key = head.key;
				V value = head.value;
				insert(key, value);  //this will automatically perform compression and insert it in the new bucket.
				head = head.next;
			}
		}
	}
	public double loadFactor()
	{
		return  1.0*(count) / numBuckets;
	}
	
	//size of HashMap
	public int size()
	{
		return count;
	}
	
	//searching key in HashMap and return it's corresponding value.
	//if key is not present then, return null.
	public V getValue(K key)
	{
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> temp = buckets.get(bucketIndex);
		while(temp != null)
		{
			if(temp.key.equals(key))
			{
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}
	
	//remove a key
	public V removeKey(K key)
	{
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> temp = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while(temp != null)
		{
			if(temp.key.equals(key))
			{
				if(prev != null)
				{
					prev.next = temp.next;
				}
				else //we are deleting head of linked list 
				{
					buckets.set(bucketIndex, temp.next);
				}
				count--;
				return temp.value;
			}
			prev = temp;
			temp = temp.next;
		}
		return null;
	}
	
}


//creating linked list.
class MapNode<K, V>
{
	K key;
	V value;
	MapNode<K, V> next;
	public MapNode(K key, V value)
	{
		this.key = key;
		this.value = value;
	}
}