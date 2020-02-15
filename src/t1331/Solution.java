package t1331;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

public class Solution {
	 public int[] arrayRankTransform(int[] arr) {
	        int[] arr2=arr.clone();
	        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
	        Arrays.sort(arr2);
	        int num=1;
	        for (int i = 0; i < arr2.length; i++) {
				if(map.containsKey(arr2[i])) {
					num--;
				}
				map.put(arr2[i], num);
				num++;
			}
	       for (int i = 0; i < arr.length; i++) {
			arr[i]=map.get(arr[i]);
		}
	       return arr;
	    }
	 @Test
	 public void ss() {
		 int[] arr= {37,12,28,9,100,56,80,5,12}; 
		 System.out.print(arrayRankTransform(arr));
	 }
}
