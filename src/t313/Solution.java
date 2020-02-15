package t313;

import org.junit.Test;

public class Solution {
	 
	 public int nthSuperUglyNumber(int n, int[] primes) {
		 int[] dp=new int[n];
		 int[] ugltindex=new int[primes.length];
		 dp[0]=1;
		 for (int i = 1; i < dp.length; i++) {
			 dp[i]=Integer.MAX_VALUE;
			for (int j = 0; j < ugltindex.length; j++) {
				if(dp[i-1]/primes[j]>=dp[ugltindex[j]]) {ugltindex[j]++;}
				dp[i]=Math.min(dp[i], dp[ugltindex[j]]*primes[j]);
			}
			
		}
		 return dp[n-1];
	    }
	 @Test
	 public void ss() {
		 int n=10;int[] primes= {2,7,13,19};
		 System.out.print(nthSuperUglyNumber(n, primes));
	 }
}
