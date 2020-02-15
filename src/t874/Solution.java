package t874;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class Solution {
	 public int robotSim(int[] commands, int[][] obstacles) {
	        int x=0;int y=0;int result=0;
	        int[] fx= {1,-1,-1,1};
	        boolean flag=true;
	        HashMap<Integer, List<Integer>> mapx=new HashMap<Integer, List<Integer>>();
	        HashMap<Integer, List<Integer>> mapy=new HashMap<Integer, List<Integer>>();
	        for (int[] a:obstacles) {
	        	if(!mapx.containsKey(a[0])) {mapx.put(a[0], new ArrayList<Integer>());mapx.get(a[0]).add(a[1]);
	        	}
	        	else {mapx.get(a[0]).add(a[1]);}
	        	if(!mapy.containsKey(a[1])) {mapy.put(a[1], new ArrayList<Integer>());mapy.get(a[1]).add(a[0]);
	        	}
	        	else {mapy.get(a[1]).add(a[0]);}
			}
	        int now=0;
	        for (int a:commands) {
				if(a==-2) {
					now=(now==3?0:now+1);flag=!flag;
				}
				else if(a==-1) {
					now=(now==0?3:now-1);flag=!flag;
				}
				else {
					if(flag) {
						if(mapx.containsKey(x)) {
							boolean kkj=false;
							for (int i = 0; i < a; i++) {
								for (int j :mapx.get(x)) {
									if(y+fx[now]==j) {kkj=true;break;}
									}
								if(!kkj) {y=y+fx[now];}
								
							}
						}
						else {
							y=y+fx[now]*a;
						}
						
//							if(mapx.containsKey(x)) {
//								int b=mapx.get(x);
//								if(fx[now]>0&&b>y&&b<=y+fx[now]*a) {y=b-1;result=Math.max(x*x+y*y,result);continue;}
//								if(fx[now]<0&&b<y&&b>=y+fx[now]*a) {y=b+1;result=Math.max(x*x+y*y,result);continue;}
//								}
//							y=y+fx[now]*a;
//						result=Math.max(x*x+y*y,result);
					}
					else {
						if(mapy.containsKey(y)) {
							boolean kkj=false;
							for (int i = 0; i < a; i++) {
								for (int j :mapy.get(y)) {
									if(x+fx[now]==j) {kkj=true;break;}
									}
								if(!kkj) {x=x+fx[now];}
								
							}
							}
						else{x+=fx[now]*a;}
						
					}
					result=Math.max(x*x+y*y,result);
					}
				}
			
	        return result;
	    }
	 @Test
	 public void ss() {
		
		
		 int[] commands=  {7,-2,-2,7,5};
		int[][] obstacles=  {{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
		 System.out.println(robotSim(commands, obstacles));
	 }
}
