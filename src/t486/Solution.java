package t486;

import org.junit.Test;

public class Solution {
	  public boolean PredictTheWinner(int[] nums) {
	        int[][] dp=new int[nums.length][nums.length];
	        for (int i = 0; i < dp.length; i++) {
				dp[i][i]=nums[i];
			}
	        for (int i = dp.length-1; i>-1; i--) {
				for (int j = i+1; j < dp[i].length; j++) {
					dp[i][j]=Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
				}
			}
	        return dp[0][nums.length-1]>=0;
	       
	    }
	  @Test
		 public void ss() {
			int[] nums= {2,4,55,6,8};
			 System.out.print(PredictTheWinner(nums));
		 }
}
