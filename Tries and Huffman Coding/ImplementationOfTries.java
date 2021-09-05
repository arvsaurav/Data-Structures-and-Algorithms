/*
Implementation of Trie data structure.
*/


public class TrieNode 
{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	public TrieNode(char data)
	{
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];  // by default each entry will be null
		childCount = 0;
	}
}


public class Trie 
{
	private TrieNode root;
	//constructor
	public Trie()
	{
		root = new TrieNode('\0'); // set root to null since, root dosen't contains any data.
	}
	
	// add function of tries data structure
//	public void add(String word)
//	{
//		int childIndex = word.charAt(0) - 'a'; //we will get the index of word.charAt(0).
//		TrieNode child = root.children[childIndex];
//		
//		if(child == null)  // character is not present.
//		{
//			child = new TrieNode(word.charAt(0));
//			root.children[childIndex] = child;
//		}
		
//		add(word.substring(1));  //recursively adding characters.
//		if we make recursive call like this then, for next recursive call root will remain same and
//		the next character will be searched in the original root only but we want to search for next character 
//		in child node i.e., by making current child as a root for the next recursive call.
//		so, to implement this we will make another function add. 
		
//	}
	
	//implementation of add function
	private void add(TrieNode root, String word)
	{
		//base case
		if(word.length() == 0)
		{
			root.isTerminating = true;
			return;
		}
		
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null)
		{
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}
	public void add(String word)
	{
		add(root,  word);
	}
	
	
	//implementation of search function
	public boolean search(String word)
    {
		return search(root, word);
    }
    private boolean search(TrieNode root, String word)
    {
        if(word.length() == 0)
        {
        	return root.isTerminating;
//            if(root.isTerminating)
//                return true;
//            return false;
        }
		int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
        {
            return false;
        }
        return search(child, word.substring(1));
    }
    
    
    
    //implementation of remove function
    public void remove(String word)
    {
    	remove(root, word);
    }
    private void remove(TrieNode root, String word)
    {
    	if(word.length() == 0)
    	{
    		root.isTerminating = false;
    		return;
    	}
    	int childIndex = word.charAt(0) - 'a';
    	TrieNode child = root.children[childIndex];
    	if(child == null)
    	{
    		return;  // character is not present.
    	}
    	remove(child, word.substring(1));
    	// we can remove child node only if it is non-terminating and it's number of children is 0. 
    	if(!child.isTerminating && child.childCount == 0)
    	{
    		//we can delete child
    		root.children[childIndex] = null;
    		child = null;
    		root.childCount--;
    	}
    	
//    	if(!child.isTerminating)
//    	{
//    		int numChild = 0;
//    		for(int i = 0; i < 26; i++)
//    		{
//    			if(child.children[i] != null)
//    				numChild++;
//    		}
//    		if(numChild == 0)
//    		{
//    			//we can delete child
//    			root.children[childIndex] = null;
//    			child = null;
//    		}
//    	}
    }
    
    
    
    //inefficient way
//    private void remove(TrieNode root, String word)
//    {
//    	if(word.length() == 0)
//    	{
//    		root.isTerminating = false;
//    		return;
//    	}
//    	int childIndex = word.charAt(0) - 'a';
//    	TrieNode child = root.children[childIndex];
//    	if(child == null)
//    	{
//    		return;  // character is not present.
//    	}
//    	remove(child, word.substring(1));
//    }
}



public class TrieUse 
{
	public static void main(String[] args)
	{
		Trie trie = new Trie();
		trie.add("news");
		trie.add("are");
		trie.add("as");
//		System.out.println(trie.search("are"));
//		System.out.println(trie.search("a"));
//		System.out.println(trie.search("news"));
		trie.add("a");
//		System.out.println(trie.search("a"));
		trie.remove("news");
		trie.remove("a");
		System.out.println(trie.search("news"));
		System.out.println(trie.search("a"));
		System.out.println(trie.search("are"));
		System.out.println(trie.search("as"));
		trie.remove("are");
		System.out.println(trie.search("are"));
		System.out.println(trie.search("as"));
	}
}






