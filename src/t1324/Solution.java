package t1324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Solution {
	 public List<String> printVertically(String s) {
	        int h=1;int l=1;int count=0;
	        char[] ss=s.toCharArray();
	        for (int i = 0; i < ss.length; i++) {
	        	
				if(ss[i]==' ') {
					h++;
					l=Math.max(l, count);
					count=-1;
					}
				count++;
			}
	        l=Math.max(l, count);
	        char[][] zm=new char[h][l];
	        for (int i = 0; i < zm.length; i++) {
				Arrays.fill(zm[i], ' ');
			}
	        h=0;count=0;
	        for (int i = 0; i < ss.length; i++) {
	        	if(ss[i]==' ') {
					h++;
					count=0;continue;
					}
				zm[h][count]=ss[i];
				count++;
			}
	        List<String> resultList=new ArrayList<String>();
	        for (int j = 0; j < l; j++) {
	        	String str="";
	        for (int i = 0; i < zm.length; i++) {
	        	str+=zm[i][j];
			}
	     
	        	int num=0;char[] strr=str.toCharArray();
	        	for (int k = 0; k < strr.length; k++) {
					if(strr[k]==' ') {num++;}
					else {break;}
				}
	        	str=str.trim();
	        	for (int k =num ; k >0; k--) {
					str=" "+str;
				}
	        
	        resultList.add(str);
	        }
	        return resultList;
	        
	    }
	  @Test
		 public void ss() {
			 
			System.out.println(printVertically("AA BB SSSSSSS AA AA AA"));
		 }
}
