package t1328;

import org.junit.Test;

public class Solution {
	  public int maxValueAfterReverse(int[] nums) {
		  int result=0;
		  for (int i = 0; i < nums.length-1; i++) {
			result+=Math.abs(nums[i]-nums[i+1]);
		}
		  int[] fx1= {1,1,-1,-1};
		  int[] fx2= {1,-1,1,-1};
		  int maxvalue=Integer.MIN_VALUE;
		  for(int i=0;i<nums.length;i++)
	        {
	            if(i != nums.length - 1)
	                maxvalue = Math.max(maxvalue,Math.abs(nums[0] - nums[i + 1]) - 
	                		Math.abs(nums[i] - nums[i + 1])); // 左端点为0右端点为i
	            if(i != 0)
	            	maxvalue = Math.max(maxvalue,Math.abs(nums[nums.length - 1] - nums[i - 1]) -
	            			Math.abs(nums[i] - nums[i - 1])); // 右端点为n-1,左端点为i
	        }
		  for (int i = 0; i < 4; i++) {
			  int max=Integer.MIN_VALUE;int min=Integer.MAX_VALUE;
			for (int j = 1; j < nums.length; j++) {
				int a=fx1[i]*nums[j-1]+fx2[i]*nums[j]-Math.abs(nums[j]-nums[j-1]);
				max=Math.max(max, a);
				int b=fx1[i]*nums[j-1]+fx2[i]*nums[j]+Math.abs(nums[j]-nums[j-1]);
				min=Math.min(min, b);
			}
			maxvalue=Math.max(maxvalue, max-min);
			
		}
		  return result+maxvalue;
	        
	    }
	  @Test
		 public void ss() {
			 int[] nums= {1,2,3}; 
			 System.out.print(maxValueAfterReverse(nums));
		 }
}
