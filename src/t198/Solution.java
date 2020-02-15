package t198;

import org.junit.Test;

public class Solution {
	 public int rob(int[] nums) {
		 int result=0;
		 if(nums.length==0) {return result;}
			if(nums.length==1) {return nums[0];}
			if(nums.length==2) {return Math.max(nums[0], nums[1]);}
			int[] dp=new int[nums.length-1];int[] dp2=new int[nums.length-1];
			dp[0]=nums[0];dp[1]=Math.max(nums[0], nums[1]);
			dp2[0]=nums[1];dp2[1]=Math.max(nums[1], nums[2]);
			for (int i = 2; i < nums.length-1; i++) {
				dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i]);
			}
			for (int i = 2; i < nums.length-1; i++) {
				dp2[i]=Math.max(dp2[i-1], dp2[i-2]+nums[i+1]);
			}
			return Math.max(dp[dp.length-1], dp2[dp.length-1]);
		    }
	 @Test
	 public void ss() {
		 int[] nums= {1,2,3,1};
		 System.out.print(rob(nums));
	 }
}
