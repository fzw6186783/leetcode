package t5311;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution {
	 public int minJumps(int[] arr) {
		 int length=arr.length;
		 if(length<=1) {return 0;}
	        int[] dp=new int[length];
	        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
	        dp[length-1]=0;map.put(arr[length-1], 1);
	        for (int i = length-2; i > -1; i--) {
	        	int a=Integer.MAX_VALUE;
	        	if(map.containsKey(arr[i])) {a=map.get(arr[i]);}
				dp[i]=Math.min(a, dp[i+1]+1);
				if(!map.containsKey(arr[i])) {map.put(arr[i],dp[i]+1);}
				if(dp[i+1]-1>dp[i]) {dp[i+1]=dp[i]+1;map.put(arr[i+1], dp[i+1]+1);
				for (int j = length-2; j >= i; j--) {
					int b=Integer.MAX_VALUE;
		        	if(map.containsKey(arr[i])) {a=map.get(arr[i]);}
					dp[i]=Math.min(a, dp[i+1]+1);
				}
				}
			}
	        return dp[0];
	    }
	  @Test
	  public void ss() {
   int[] arr= {11,22,7,7,7,7,7,7,7,22,13};
		  System.out.println(minJumps(arr));
	  }
}
