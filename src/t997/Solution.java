package t997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	 public int findJudge(int N, int[][] trust) {
	       int[] chudu =new int[N];
	       int[] nums=new int[N];int fg=0;
	       for (int i = 0; i < trust.length; i++) {
			chudu[trust[i][0]-1]=1;
			nums[trust[i][1]-1]+=1;
			if(nums[trust[i][1]-1]==N-1) {
				fg=trust[i][1]-1;
			}
		}
	       return fg==0?-1:chudu[fg]==0?fg:-1;
	    }
}
