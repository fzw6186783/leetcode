package t215;

import java.util.PriorityQueue;

public class Solution {
	 public int findKthLargest(int[] nums, int k) {
		 PriorityQueue<Integer> heap=new PriorityQueue<Integer>();
		 for (int i = 0; i < nums.length; i++) {
			 if(heap.size()<k) {
				 heap.add(nums[i]);
			 }
			 else {
			if(nums[i]>heap.peek()) {
				heap.poll();
				heap.add(nums[i]);
			}}
		}
		 return heap.peek();
		 
	    }
}
