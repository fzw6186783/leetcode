package t695;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Solution {
	int[][] grid;//int[][] memo;
	public int dfs(int x,int y) {
		if(x<0||x>=grid.length||y<0||y>=grid[0].length) {return 0;}
		if(grid[x][y]==0) {return 0;}
		//if(memo[x][y]!=0) {return memo[x][y]}
		grid[x][y]=0;
		int left=dfs(x-1, y);
		int right=dfs(x+1, y);
		int up=dfs(x, y-1);
		int down=dfs(x, y+1);
		//grid[x][y]=1;
		//memo[x][y]=left+right+up+down+1;
		return left+right+up+down+1;
		
	}
	   public int maxAreaOfIsland(int[][] grid) {
	        this.grid=grid;int result=0;
	        for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[i].length; j++) {
					result=Math.max(result, dfs(i, j));
				}
			}
	        return result;
	    }
	   public boolean singleNumber(int[] nums) {
	        int result=1;
	        for(int i=1;i<nums.length;i++){
	            result=result^nums[i];
	            if(result==0)return false;
	            
	        }
	        return true;
	    }
	   public boolean oneEditAway(String first, String second) {
	        if(first.length()==second.length()){
	            boolean flag=false;
	          for(int i=0;i<first.length();i++){
	             if(first.charAt(i)!=second.charAt(i)){
	                if(flag){return false;}
	                flag=true;
	             }
	          }
	           return true;
	        }
	        if(first.length()-1==second.length()){
	             int a=0;int b=0;  boolean flag=false;
	             while(a<first.length()&&b<second.length()){
	                 if(first.charAt(a)!=second.charAt(b)){
	                       if(flag){return false;}
	                     a++;  flag=true;continue;
	                 }
	                 a++;b++;
	             }
	             return true;
	        }
	        if(first.length()+1==second.length()){
	            return oneEditAway(second,first);
	        }
	      return false;
	    }
	   
	   public String compressString(String S) {
	        StringBuilder result=new StringBuilder("");
	        if(S.length()<3){return S;}
	        char[] ss=S.toCharArray();
	        int count=1;
	        for(int i=0;i<ss.length-1;i++){
	           if(ss[i]==ss[i+1]){count++;}
	           else{result.append(ss[i]);result.append(String.valueOf(count));count=1;}
	        }
	        return S.length()>=result.length()?S:result.toString();
	    }
	   public String help(String s1, String s2) {
		     int one=0;char ss[]=s2.toCharArray();
		    for(char a:ss){
		        if(s1.charAt(one)==a){one++;}
		        else{one=0;}
		    }
		    return s1.substring(one,s1.length());

		    }
	   public boolean isFlipedString(String s1, String s2) {
		   if(s1.length()!=s2.length()){return false;}
		   if(s1.equals(s2)){return true;}
		   String a=help(s1,s2);String b=help(s2,s1);
		   return (a+b).equals(b);

		    }
	   @Test
	   public void ss() {
//		   int[][] grid= {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//				   {0,0,0,0,0,0,0,1,1,1,0,0,0},
//				   {0,1,1,0,1,0,0,0,0,0,0,0,0},
//				   {0,1,0,0,1,1,0,0,1,0,1,0,0},
//				   {0,1,0,0,1,1,0,0,1,1,1,0,0},
//				   {0,0,0,0,0,0,0,0,0,0,1,0,0},
//				   {0,0,0,0,0,0,0,1,1,1,0,0,0},
//				   {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		   System.out.println(maxAreaOfIsland(grid));
		String S="Mr John Smith    ";//aString.replaceAll(" ","20");
		int length=13;
		 StringBuilder result=new StringBuilder("");
		
		
		   System.out.println(isFlipedString("leetcode", "codeleet"));
	   }
}
