/*
Problem Statement :
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.

Note : 
1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the 
   count of elements populated in the output array.
*/



public class solution 
{
    //helper to return characters present at nth key of keypad.
    //if n = 4 , return ['g', 'h', 'i']
    public static char[] helper(int n)
    {
        if(n == 2)
        {
	    char[] val = {'a', 'b', 'c'};
            return val;
        }
        else if(n == 3)
        {
	    char[] val = {'d', 'e', 'f'};
            return val;
        }
        else if(n == 4)
        {
	    char[] val = {'g', 'h', 'i'};
            return val;
        }
        else if(n == 5)
        {
	    char[] val = {'j', 'k', 'l'};
            return val;
        }
        else if(n == 6)
        {
            char[] val = {'m', 'n', 'o'};
            return val;
        }
        else if(n == 7)
        {
	    char[] val = {'p', 'q', 'r', 's'};
            return val;
        }
        else if(n == 8)
        {
	    char[] val = {'t', 'u', 'v'};
            return val;
        }
        else  // n == 9
        {
	    char[] val = {'w', 'x', 'y', 'z'};
            return val;
        }
    }
    
    public static String[] keypad(int n)
    {
	//base case
        if(n == 0 || n == 1)
        {
            String[] ans = {""};
            return ans;
        }
        String[] subAns = keypad(n/10);
        char[] val = helper(n%10);
        int k = 0;
        String[] ans = new String[subAns.length * val.length];
        for(int i = 0; i < subAns.length; i++)
        {
	    for(int j = 0; j < val.length; j++)
            {
		ans[k] = subAns[i] + val[j];
                k++;
            }
        }
	return ans;
    }
}
