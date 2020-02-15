package t5330;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution {
	 List<Integer> resultIntegers;
		public int back(TreeNode root) {
			if(root==null) {return 0;}
			int a=back(root.left);
			int b=back(root.right);
			resultIntegers.add(a+b+root.val);
			return a+b+root.val;
		}
		  public int maxProduct(TreeNode root) {
			  resultIntegers=new ArrayList<Integer>();
	           back(root);
			  long max=0;long sum=resultIntegers.get(resultIntegers.size()-1);
			  for (int i :resultIntegers) {
				max=Math.max(max, (sum-i)*i);
			}
			  int kk=(int) (max%1000000007);
			  return kk;
		    }
	  @Test
	  public void ss() {
	  	TreeNode aNode=new TreeNode(2);TreeNode bNode=new TreeNode(2);
	  	aNode.left=bNode;
	  	System.out.print(maxProduct(aNode));
	  }
}
