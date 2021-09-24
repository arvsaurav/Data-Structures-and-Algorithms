/*
Problem Statement :
Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. 
You can perform any one of the following 3 steps:

1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  

Write brute-force recursive solution for this.
*/


public class Solution 
{
    public static int countMinStepsToOne(int n) 
    {
	if(n == 1)
            return 0;
        int ans1 = countMinStepsToOne(n-1);
        int ans2 = Integer.MAX_VALUE;
        int ans3 = Integer.MAX_VALUE;
        if(n % 2 == 0)
            ans2 = countMinStepsToOne(n/2);
        if(n % 3 == 0)
            ans3 = countMinStepsToOne(n/3);
        return Math.min(ans1, Math.min(ans2, ans3)) + 1;
    }
}