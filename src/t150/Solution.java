package t150;

import java.util.Stack;

public class Solution {
	  public int evalRPN(String[] tokens) {
	        Stack<String> stack=new Stack<String>();
	        int a=0;int b=0;
	        for (int i = 0; i < tokens.length; i++) {
	        	switch (tokens[i]) {
			case "+":
				 a=Integer.parseInt(stack.pop()); b=Integer.parseInt(stack.pop());
				stack.push(String.valueOf(a+b));
				break;
			case "-":
				 a=Integer.parseInt(stack.pop()); b=Integer.parseInt(stack.pop());
				stack.push(String.valueOf(b-a));
				break;
			case "*":
				 a=Integer.parseInt(stack.pop()); b=Integer.parseInt(stack.pop());
				stack.push(String.valueOf(a*b));
				break;
			case "/":
				 a=Integer.parseInt(stack.pop());b=Integer.parseInt(stack.pop());
				stack.push(String.valueOf(b/a));
				break;

				default:
					stack.push(tokens[i]);
					break;
				}
				
			}
	        return Integer.parseInt(stack.pop());
	    }
}
