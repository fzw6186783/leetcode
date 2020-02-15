package t5314;

import org.junit.Test;

public class Solution {
    public int minJumps(int[] arr) {
    	 int length=arr.length;
		 if(length<=1) {return 0;}
      int[][] dp=new int[length][length];
      for (int i = 0; i < dp.length; i++) {
		for (int j = 0; j < dp.length; j++) {
			dp[i][j]=Integer.MAX_VALUE;
			if(j==i+1||j==i-1) {dp[i][j]=1;}
			if(arr[i]==arr[j]&&i!=j) {dp[i][j]=1;}
			if(i==j) {dp[i][j]=0;}
		}
	}
      for (int j2 = 1; j2 < length  ; j2++) {
      for (int i = length-1; i > -1; i--) {
  		for (int j = length-1; j > -1; j--) {
  			
  				if(dp[i][j2]==Integer.MAX_VALUE||dp[j2][j]==Integer.MAX_VALUE) {continue;}
				dp[i][j]=Math.min(dp[i][j], dp[i][j2]+dp[j2][j]);
			}
  		}
  	}
      return dp[0][length-1];
      //return dp[length-1][0];
   }
    @Test
	  public void ss() {
 int[] arr= {6,1,9};
		  System.out.println(minJumps(arr));
	  }
}
