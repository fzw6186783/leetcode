package t5328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

public class Solution {
public int[] kWeakestRows(int[][] mat, int k) {
	ArrayList<Integer []> result=new ArrayList<Integer[]>();
        for (int i = 0; i < mat.length; i++) {
        	Integer[] aIntegers=new Integer[2];
        	aIntegers[0]=i;aIntegers[1]=0;
        	result.add(aIntegers);
			for (int j = 0; j < mat[i].length; j++) {
				if(mat[i][j]==1) {
					result.get(i)[1]++;
				}
			}
		}
      Collections.sort(result,new Comparator<Integer[]>() {

		public int compare(Integer[] o1, Integer[] o2) {
			// TODO Auto-generated method stub
			return o1[1]-o2[1];
		}
	});
      int[] kk=new int[k];
      for (int i = 0; i < k; i++) {
    	  
		kk[i]=result.get(i)[0];
	}
      return kk;
        
    }
@Test
public void ss() {
	int[][] mat= {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
	int k=3;
	System.out.print(kWeakestRows(mat, k));
}
}
