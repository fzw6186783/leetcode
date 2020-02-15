package t103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class Solution {
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList=new ArrayList<List<Integer>>();
        if(root==null) {return resultList;}
        Stack<TreeNode> stack=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        stack.push(root);int count=0;
        while(!stack.isEmpty()||!stack2.isEmpty()) {
        	List<Integer> aIntegers=new ArrayList<Integer>();
				if((count&1)==1) {
					//先右后左
					while(!stack2.isEmpty()) {
						TreeNode aNode=stack2.pop();aIntegers.add(aNode.val);
						if(aNode.right!=null)stack.push(aNode.right);
						if(aNode.left!=null)stack.push(aNode.left);
					}
				}
				else {
					//先左后右
					while(!stack.isEmpty()) {
						TreeNode aNode=stack.pop();aIntegers.add(aNode.val);
						if(aNode.left!=null)stack2.push(aNode.left);
						if(aNode.right!=null)stack2.push(aNode.right);
					}
					
				}
				resultList.add(aIntegers);
        	count++;
        	}
        return resultList;
    }
@Test
public void ss() {
	TreeNode aNode=new TreeNode(3);TreeNode aNode1=new TreeNode(9);TreeNode aNode2=new TreeNode(20);
	TreeNode aNode3=new TreeNode(1);TreeNode aNode4=new TreeNode(2);TreeNode aNode5=new TreeNode(3);
	TreeNode aNode6=new TreeNode(4);
	aNode.left=aNode1;aNode.right=aNode2;
	aNode1.left=aNode3;aNode1.right=aNode4;
	aNode2.left=aNode5;aNode2.right=aNode6;
	
	System.out.println(zigzagLevelOrder(aNode));
}
}
