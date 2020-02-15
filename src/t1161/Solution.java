package t1161;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import t1161.TreeNode;

public class Solution {
	  public int maxLevelSum(TreeNode root) {
		  int min=root.val;int result=0;
	        Stack<TreeNode> stack=new Stack<TreeNode>();
	        Stack<TreeNode> stack2=new Stack<TreeNode>();
	        stack.push(root);int count=0;
	        while(!stack.isEmpty()||!stack2.isEmpty()) {
	        	int nums=0;
				if((count&1)==1) {
					//先右后左
					while(!stack2.isEmpty()) {
						TreeNode aNode=stack2.pop();nums+=aNode.val;
						if(aNode.right!=null)stack.push(aNode.right);
						if(aNode.left!=null)stack.push(aNode.left);
						
					}
				}
				else {
					//先左后右
					while(!stack.isEmpty()) {
						TreeNode aNode=stack.pop();nums+=aNode.val;
						if(aNode.left!=null)stack2.push(aNode.left);
						if(aNode.right!=null)stack2.push(aNode.right);
					}
					
				}
				if(min<nums) {min=nums;result=count;}
        	count++;
	        }
	        return count;
	    }
}
