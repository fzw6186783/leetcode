package t1335;

import org.junit.Test;

public class Solution {
	public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length <= 0 || d <= 0 || jobDifficulty.length < d) {
            return -1;
        }
        int n = jobDifficulty.length;
        //dp[i][j] 表示第i天，完成第j个任务，其中i<=j
        int[][] dp = new int[d][n];
        //第一天完成0-i项工作，难度等于0-i中最大的难度
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, jobDifficulty[i]); //当天最大难度
            dp[0][i] = max;
        }
        //第二天开始
        for(int i=1; i<d; i++) {
            //从第i项工作开始（每天至少完成一项，第i天至少已经完成前i项）
            for(int j=i; j<n; j++) {
                max = 0;
                int minSum = Integer.MAX_VALUE;
                //当天完成工作项是[k,j]，当天工作量=前k-1项工作量+当天最大难度
                for(int k=j; k>=i; k--) {
                    max = Math.max(max, jobDifficulty[k]); //当天最大难度
                    minSum = Math.min(minSum, dp[i-1][k-1]+max);
                }
                dp[i][j] = minSum;
            }
        }
        return dp[d-1][n-1];
    }
	 @Test
	 public void ss() {
		 int[] jobDifficulty= {11,111,22,222,33}; int d=3;
		 System.out.print(minDifficulty(jobDifficulty, d));
	 }

}
