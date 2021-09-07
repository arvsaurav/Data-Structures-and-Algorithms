/*
Problem Statement :
Given a list of n words and a pattern p that we want to search. 
Check if the pattern p is present the given words or not. 
Return true if the pattern is present and false otherwise.
*/



import java.util.ArrayList;

class TrieNode
{
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;

    public TrieNode(char data) 
    {
	this.data = data;
	isTerminating = false;
	children = new TrieNode[26];
	childCount = 0;
    }
}


public class Trie 
{
    private TrieNode root;
    public int count;
    public Trie() 
    {
	root = new TrieNode('\0');
    }

    public boolean search(String word)
    {
	return search(root, word);
    }

    private boolean search(TrieNode root, String word) 
    {
	if(word.length() == 0)
        {
	    return true;
	}
	int childIndex = word.charAt(0) - 'a';
	TrieNode child = root.children[childIndex];
	if(child == null){
	    return false;
	}
	return search(child, word.substring(1));
    }

    //implement this function
    public boolean patternMatching(ArrayList<String> arr, String pattern) 
    {
        for(int i = 0; i < arr.size(); i++)
        {
            //we have to add all the suffix of every string.
            int j = 0;
            while(j < arr.get(i).length())
            {
                add(arr.get(i).substring(j));
                j++;
            }
        }
        return search(pattern);
    }
    
    private void add(String str)
    {
        add(root, str);
    }
    private void add(TrieNode root, String str)
    {
        if(str.length() == 0)
        {
            return;
        }
        int childIndex = str.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
        {
            child = new TrieNode(str.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, str.substring(1));
    }
}


