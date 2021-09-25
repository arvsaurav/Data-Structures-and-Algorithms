/*
Problem Statement :
Byteland has a very strange monetary system.
Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into 
three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?
*/



import java.util.HashMap;
public class Solution 
{    
    //Recursive Dynamic Programming :
    public static long bytelandian(long n, HashMap<Long, Long> memo) 
    {
        if(n <= 1) 
        {
            return n;
        }
        if(memo.get(n) != null) 
        {
            return memo.get(n);
        }
        long subAns1 = bytelandian(n/2, memo);
        long subAns2 = bytelandian(n/3, memo);
        long subAns3 = bytelandian(n/4, memo);
        long subAns = subAns1 + subAns2 + subAns3;
        memo.put(n, Math.max(subAns, n));
        return memo.get(n);
    }
}

