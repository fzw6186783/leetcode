package t1335;

import org.junit.Test;

public class Solution {
	public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length <= 0 || d <= 0 || jobDifficulty.length < d) {
            return -1;
        }
        int n = jobDifficulty.length;
        //dp[i][j] ��ʾ��i�죬��ɵ�j����������i<=j
        int[][] dp = new int[d][n];
        //��һ�����0-i������Ѷȵ���0-i�������Ѷ�
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, jobDifficulty[i]); //��������Ѷ�
            dp[0][i] = max;
        }
        //�ڶ��쿪ʼ
        for(int i=1; i<d; i++) {
            //�ӵ�i�����ʼ��ÿ���������һ���i�������Ѿ����ǰi�
            for(int j=i; j<n; j++) {
                max = 0;
                int minSum = Integer.MAX_VALUE;
                //������ɹ�������[k,j]�����칤����=ǰk-1�����+��������Ѷ�
                for(int k=j; k>=i; k--) {
                    max = Math.max(max, jobDifficulty[k]); //��������Ѷ�
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
