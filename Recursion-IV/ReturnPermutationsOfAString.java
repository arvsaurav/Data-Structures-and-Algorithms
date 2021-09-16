/*
Problem Statement :
Given a string, find and return all the possible permutations of the input string.

Note : The order of permutations are not important.
*/


import java.util.ArrayList;
public class solution 
{	
    public static String[] permutationOfString(String str)
    {
	String permutationSoFar = "";
        ArrayList<String> ans = new ArrayList<>();
        permutationOfString(str, permutationSoFar, ans);
        String[] output = new String[ans.size()];
        for(int i = 0; i < output.length; i++)
        {
            output[i] = ans.get(i);
        }
        return output;
    }

    public static void permutationOfString(String str, String permutationSoFar, ArrayList<String> ans)
    {
        //base case
        if(str.length() == 1)
        {
            permutationSoFar = permutationSoFar + str.charAt(0);
            ans.add(permutationSoFar);
            return;
        }
        
        for(int i = 0; i < str.length(); i++)
        {
            // we can't append in permutationSoFar because for every iteration permutationSoFar must be same.
            // hence, we have used another varialbe permutationSoFar1.
            String permutationSoFar1 = permutationSoFar + str.charAt(i);
            permutationOfString(str.substring(0, i) + str.substring(i+1), permutationSoFar1, ans);
        }
    }
}
