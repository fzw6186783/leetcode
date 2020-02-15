package t1042;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution {
	 public int[] gardenNoAdj(int N, int[][] paths) {
		 graph[] nums=new graph[N];
		 int[] answer=new int[N];
		 for (int i = 0; i < N; i++) {
			nums[i]=new graph(i+1);
		}
		 for (int[] a:paths) {
			
			nums[a[0]-1].setlingb(a[1]);
			nums[a[1]-1].setlingb(a[0]);
		}
		for (int i = 0; i < answer.length; i++) {

			int[] color= {1,2,3,4};
			List<Integer> aIntegers=nums[i].getlingb();
			for (int j = 0; j < aIntegers.size(); j++) {
				for (int j2 = 0; j2 < color.length; j2++) {
					if(answer[aIntegers.get(j)-1]==color[j2]) {color[j2]=0;}
				}
			}
			for (int j = 0; j < color.length; j++) {
				if(color[j]!=0) {answer[i]=color[j];break;}
			}
		}
		return answer;
	       
	    }
	 private class graph{
		 int val;
		 List<Integer> lingb;
		 private graph(int vall) {
			 val=vall;
			 lingb=new ArrayList<Integer>();
		 }
		 public void setlingb(int vall) {
			 lingb.add(vall);
		 }
		 public List<Integer> getlingb(){
			 return lingb;
		 }
		 
	 }
	 @Test
	 public void ss() {
		 int N=4;int[][] paths= {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
		 System.out.println(gardenNoAdj(N, paths));
	 }
}
