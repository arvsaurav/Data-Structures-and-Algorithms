/*
Problem Statement :
Given a string, find and print all the possible permutations of the input string.

Note : The order of permutations are not important. Just print them in different lines.
*/


public class solution 
{
    public static void permutations(String str)
    {
	permutations(str, "");
    }
    
    public static void permutations(String str, String permutationSoFar)
    {
	//base case
        if(str.length() == 1)
        {
            permutationSoFar = permutationSoFar + str.charAt(0);
            System.out.println(permutationSoFar);
            return;
        }
        
        for(int i = 0; i < str.length(); i++)
        {
            String permutationSoFar1 = permutationSoFar + str.charAt(i);
            permutations(str.substring(0, i) + str.substring(i+1), permutationSoFar1);
        }
    }
}
