package t5331;

import org.junit.Test;

import t5330.TreeNode;

public class Solution {
	int[] arr;int d;Integer[] memo;
	int back(int old,int index) {
		if(index<0||index>=arr.length) {return 0;}
		if(old!=-1) {
			if(old<index) {
				for (int i = old+1; i <= index; i++) {
					if(arr[old]<=arr[i]) {return 0;}//确定小于区间就行了
				}
			}
			else {
				 for (int i = index; i < old; i++) {
		            	if(arr[old]<=arr[i]) {return 0;}
					}
			}
			
           
		}
		if(memo[index]!=null) {return memo[index];}
		int max=0;
		for (int i = 1; i <= d; i++) {
			int a=back(index,i+index);
			int b=back(index,index-i);
			max=Math.max(Math.max(a, b), max);
		}
		memo[index]=max+1;
		return max+1;
		
		
	}
	  public int maxJumps(int[] arr, int d) {
		  this.arr=arr;this.d=d;memo=new Integer[arr.length];
		  int max=0;
		  for (int i = 0; i < arr.length; i++) {
			max=Math.max(max, back(-1,i));
		}
	        return max;
	    }
	  @Test
	  public void ss() {
	  int[] arr={66};int d=1;
	  	System.out.print(maxJumps(arr, d));
	  }
}
