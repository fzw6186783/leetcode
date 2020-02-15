package t973;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class Solution {
	  public int[][] kClosest(int[][] points, int k) {
		  PriorityQueue<Integer> heap=new PriorityQueue<Integer>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return points[o2][0]*points[o2][0]+points[o2][1]*points[o2][1]-points[o1][0]*points[o1][0]-points[o1][1]*points[o1][1];
				}
			});
			 for (int i = 0; i < points.length; i++) {
				 if(heap.size()<k) {
					 heap.add(i);
				 }
				 else {
					 int o2=heap.peek();
				if(points[i][0]*points[i][0]+points[i][1]*points[i][1]<points[o2][0]*points[o2][0]+points[o2][1]*points[o2][1]) {
					heap.poll();
					heap.add(i);
				}}
			}
			 int[][] result=new int[k][2];
			 for (int i = 0; i < k; i++) {
				 int c=heap.poll();
				result[i][0]=points[c][0];result[i][1]=points[c][1];
			}
			 return result;
	    }
	  @Test
		 public void ss() {
			 int[][] points= {{-5,4},{-6,5},{4,6}};
		 	System.out.println(kClosest(points, 2));
		 }
}
