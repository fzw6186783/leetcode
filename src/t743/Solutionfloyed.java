package t743;

import java.util.Arrays;

public class Solutionfloyed {
	   public int networkDelayTime(int[][] times, int n, int K) {
		   int[][] tu=new int[n][n];//Í¼±í
	        for (int i = 0; i < tu.length; i++) {
	        	 Arrays.fill(tu[i], Integer.MAX_VALUE);
				for (int j = 0; j < tu.length; j++) {
					if(i==j) {tu[i][j]=0;}
				}
			}
	       for (int i = 0; i < times.length; i++) {
				tu[times[i][0]-1][times[i][1]-1]=times[i][2];
		}
	       for (int k = 0; k < n; k++) {
	      for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i != k && j != k && tu[i][k] != Integer.MAX_VALUE && tu[k][j] != Integer.MAX_VALUE) {
					tu[i][j]=Math.min(tu[i][j], tu[i][k]+tu[k][j]);
				}
			}
		}}
	       int min=Integer.MIN_VALUE;
	       for (int i = 0; i < tu.length; i++) {
			if(tu[K-1][i]==Integer.MAX_VALUE) {return -1;}
			min=Math.max(min, tu[K-1][i]);
		}
	       return min;
	    }
}
