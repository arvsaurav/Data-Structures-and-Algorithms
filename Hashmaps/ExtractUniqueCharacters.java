/*
Problem Statement :
Given a string S, you need to remove all the duplicates. 
That means, the output string should contain each character only once. 
The respective order of characters should remain same, as in the input string.
*/



import java.util.HashMap;

public class Solution 
{
    public static String uniqueChar(String str)
    {
        HashMap<Character, Boolean> map = new HashMap<>();
        String finalString = "";
        for(int i = 0; i < str.length(); i++)
        {
            if(map.containsKey(str.charAt(i)))
            {
                continue;
            }
            else
            {
                map.put(str.charAt(i), true);
                finalString += str.charAt(i);
            }
        }
        return finalString;
    }
}