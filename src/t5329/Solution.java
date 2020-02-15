package t5329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Solution {
	  public int minSetSize(int[] arr) {
		  HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		  ArrayList<Integer []> result=new ArrayList<Integer[]>();
	        for (int i = 0; i < arr.length; i++) {
	        	map.merge(arr[i], 1, (o1,o2)->o1+o2);
			}
	       for (int a:map.keySet()) {
	    	   Integer[] e= {a,map.get(a)};
			result.add(e);
		}
	      Collections.sort(result,new Comparator<Integer[]>() {

			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				return o2[1]-o1[1];
			}
		});
	      int count=0;int nums = 0;
	      for (Integer[] a:result) {
	    	  nums+=a[1];count++;
			if(nums*2>=arr.length) {break;}
		}
	      return count;
	    }
}
