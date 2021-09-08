/*
Problem Statement :
Given 'n' number of words, you need to find if there exist any two words which can be joined to make a palindrome or any word, 
which itself is a palindrome.
The function should return either true or false. You don't have to print anything.
*/



// WITHOUT USING TRIE DATA STRUCTURE


/*..................... Palindrome Pair................... */

private static boolean isPalindrome(String str) 
{ 
	int len = str.length();

        // compare each character from starting 
        // with its corresponding character from last 
        for (int i = 0; i < len/2; i++) 
        {
            if (str.charAt(i) != str.charAt(len-i-1)) 
            {
                return false;
            } 
        }
        return true; 
} 
    
// Your code goes here.
public boolean isPalindromePair(ArrayList<String> vect) 
{
        // check for palindrome.
        for(int i = 0; i < vect.size(); i++)
        {
            String str = vect.get(i);
            String reverseStr = "";
            for(int j = 0; j < str.length(); j++)
            {
                reverseStr = str.charAt(j) + reverseStr;
            }
            if(str.equals(reverseStr))
                return true;
        }
        
        // check for palindrome pair.
        for(int i = 0; i < vect.size()-1; i++) 
        { 
            for (int j = i+1; j < vect.size(); j++) 
            { 
                // concatenate both strings 
                String str1 = vect.get(i) + vect.get(j); 
                String str2 = vect.get(j) + vect.get(i);
                
                // check if the concatenated string is palindrome
                if(isPalindrome(str1) || isPalindrome(str2)) 
                    return true; 
            } 
        } 
        return false;
}