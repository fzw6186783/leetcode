package t1334;

import java.util.Arrays;

import org.junit.Test;

public class Solution {
	 public int findTheCity(int n, int[][] edges, int distanceThreshold) {
	        int[][] tu=new int[n][n];
	        for (int i = 0; i < tu.length; i++) {
	        	 Arrays.fill(tu[i], Integer.MAX_VALUE);
				for (int j = 0; j < tu.length; j++) {
					if(i==j) {tu[i][j]=0;}
				}
			}
	       for (int i = 0; i < edges.length; i++) {
				tu[edges[i][0]][edges[i][1]]=edges[i][2];
				tu[edges[i][1]][edges[i][0]]=edges[i][2];
		}
	       for (int k = 0; k < n; k++) {
	      for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i != k && j != k && tu[i][k] != Integer.MAX_VALUE && tu[k][j] != Integer.MAX_VALUE) {
					tu[i][j]=Math.min(tu[i][j], tu[i][k]+tu[k][j]);
				}
			}
		}}
	       int count=0;int minvalue=Integer.MAX_VALUE;int result=0;
	       for (int i = 0; i < tu.length; i++) {
	    	   count=0;
			for (int j = 0; j < tu[i].length; j++) {
				if(tu[i][j]<=distanceThreshold) {count++;}
			}
			if(count<=minvalue) {minvalue=count;result=i;}
		}

	      return result;
	    }
	 @Test
	 public void ss() {
		int n=4;int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}}; int distanceThreshold = 4;
		 System.out.print(findTheCity(n, edges, distanceThreshold));
	 }
}
