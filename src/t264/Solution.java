package t264;

import org.junit.Test;

public class Solution {
	 public int nthUglyNumber(int n) {
	        int[] dp=new int[n];
	        dp[0]=1;int two=0;int three=0;int five=0;
	        for (int i = 1; i < dp.length; i++) {
	        	if(dp[i-1]/2>=dp[two]) {two++;}
	        	if(dp[i-1]/3>=dp[three]) {three++;}
	        	if(dp[i-1]/5>=dp[five]) {five++;}
				dp[i]=Math.min(Math.min(dp[two]*2,dp[three]*3),dp[five]*5);
			}
	        return dp[n-1];
	    }
	 @Test
	 public void ss() {
		 
		 System.out.print(nthUglyNumber(10));
	 }
}
