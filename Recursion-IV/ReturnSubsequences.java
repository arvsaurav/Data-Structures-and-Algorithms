/*
Problem Statement :
Find all subsequences of a given string.
*/


import java.util.Scanner;
public class ReturnSubsequences
{
    public static String[] findSubsequences(String str)
    {
	//base case
	if(str.length() == 0)
	{
	    String[] ans = {""};
	    return ans;
	}
	String[] smallAns = findSubsequences(str.substring(1));
	String[] ans = new String[2 * smallAns.length];
	for(int i = 0; i < smallAns.length; i++)
	{
	    ans[i] = smallAns[i];
	}
	for(int i = 0; i < smallAns.length; i++)
	{
	    ans[i + smallAns.length] = str.charAt(0) + smallAns[i];
	}
	return ans;
    }
	
    public static void main(String args[])
    {
	Scanner sc = new Scanner(System.in);
	String str = sc.nextLine();
	sc.close();
	String[] ans = findSubsequences(str);
	for(String s : ans)
	{
	    System.out.println(s);
        }
    }
}