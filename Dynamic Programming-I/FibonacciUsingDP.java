/*
Calculate nth fibonacci number using dynamic programming.
*/


// Time Complexity -> O(n)
import java.util.Scanner;
public class Fibonacci 
{
	public static int fibonacci(int n, int dp[])
	{
		if(n == 0 || n == 1)
		{
			return n;
		}
		int ans1 = 0;
		int ans2 = 0;
		// dp[index] = -1 --> we don't have answer of this subproblem
		// therefore, we will calculate answer of this subproblem and store this in dp[].
		if(dp[n-1] == -1)
		{
			ans1 = fibonacci(n-1, dp);
			dp[n-1] = ans1;
		}
		else
		{
			ans1 = dp[n-1];
		}
		if(dp[n-2] == -1)
		{
			ans2 = fibonacci(n-2, dp);
			dp[n-2] = ans2;
		}
		else
		{
			ans2 = dp[n-2];
		}
		int ans = ans1 + ans2;
		return ans;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		// n+1 -> since, for n=5, we have to calculate for 0,1,2,3,4 and 5. Therefore, 6 elements.
		int dp[] = new int[n+1];
		// initialize all index with -1.
		for(int i = 0; i < dp.length; i++)
		{
			dp[i] = -1;
		}
		int ans = fibonacci(n, dp);
		System.out.println(ans);
	}
}
