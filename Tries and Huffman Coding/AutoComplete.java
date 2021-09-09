/*
Problem Statement :
Given n number of words and an incomplete word w. You need to auto-complete that word w.
That means, find and print all the possible words which can be formed using the incomplete word w.
Note : Order of words does not matter.
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

    private void add(TrieNode root, String word)
    {
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
	add(root, word);
    }
	


    
    // Write your code here
    public void autoComplete(ArrayList<String> arr, String word) 
    {
        // add all words of arraylist to trie.
	for(int i = 0; i < arr.size(); i++)
        {
            add(arr.get(i));
        }
        autoComplete(root, word, word);
    }
    // this function will find the given word
    private void autoComplete(TrieNode root, String remainingWord, String originalWord)
    {
        if(remainingWord.length() == 0)
        {
            if(root.isTerminating)
            {
                System.out.println(originalWord); // printed original word
            }
            suggestion(root, originalWord);  // it will auto complete suggestions
            return;
        }
        int childIndex = remainingWord.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if(child == null)
            return;
        autoComplete(child, remainingWord.substring(1), originalWord);
    }
    // it will auto complete suggestions
    private void suggestion(TrieNode root, String word)
    {
        if(root.childCount == 0)
        {
        	return;
        }
        for(int i = 0; i < 26; i++)
        {
            TrieNode child = root.children[i];
            if(child != null)
            {
                String output = word + child.data;
                if(child.isTerminating)
                {
                    System.out.println(output);
                }
            	suggestion(child, output);
            }
        }
    }
}
