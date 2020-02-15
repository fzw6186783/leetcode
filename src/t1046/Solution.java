package t1046;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

public class Solution {
	 public int lastStoneWeight(int[] stones) {
		 PriorityQueue<Integer> heap=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		 for(int a:stones) {
			 heap.add(a);
		 }int a=0;int b=0;
        while(heap.size()>1) {
        	a=heap.poll();
        	b=heap.poll();
        	if(a==b) {continue;}
        	heap.add(Math.abs(a-b));
        }
        return heap.size()==0?0:heap.poll();

    }
	 @Test
	 public void ss() {
		 int[] stones= {10,11,12};
	 	System.out.println(lastStoneWeight(stones));
	 }
}
