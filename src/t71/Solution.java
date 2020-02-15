package t71;

import java.util.Stack;

import org.junit.Test;

public class Solution {
	 public String simplifyPath(String path) {
	        String[] arr=path.split("/");String result="";
	        Stack<String> stack=new Stack<String>();
	        for (int i = 0; i < arr.length; i++) {
				if(!arr[i].equals("")) {
				if (arr[i].equals("..")) {
					if(!stack.isEmpty()) {
                    	  stack.pop();}}
				else {
					if(!arr[i].equals(".")) {
						stack.push(arr[i]);
					}
				}
					
				}
			}
	        while(!stack.isEmpty()) {
	        	String a="/"+stack.pop();
	        	result=a+result;
	        }
	        if(result.equals("")) {result="/";}
	        return result;
	    }
	 @Test
	 public void ss() {
		
		System.out.println(simplifyPath("/hem???/aa/../"));
	 }
}
