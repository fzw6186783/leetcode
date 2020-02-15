package t5335;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import t5332.TweetCounts;

public class Solution {
	char[][] seats;List<Integer> list;int max;
public int maxStudents(char[][] seats) {
    this.seats=seats;
	list=new ArrayList<Integer>();
        
        back(0, 0);
        return max;
        
}
public void back(int index,int count) {
	max=Math.max(count, max);
	if(index>=list.size()) {return;}
	int a=list.get(index);
	seats[a/10][a%10]='*';
	if(check(seats)) {
		back(index+1, count+1);}
	seats[a/10][a%10]='.';
	back(index+1, count);
	
}
public boolean check(char[][] seats) {
	for (int i = 0; i < seats.length; i++) {
		for (int j = 0; j < seats[i].length; j++) {
			if(seats[i][j]=='*') {
				if(!checkone(i-1, j+1)||!checkone(i-1, j-1)||!checkone(i, j-1)||!checkone(i, j+1)) {
					return false;
				}
			}
		}
	}
	return true;
}
public boolean checkone(int i,int j) {
	if(i<0||j<0||i>=seats.length||j>=seats[i].length) {return true;}
	if(seats[i][j]!='*')return true;
	return false;
}
@Test
public void ss() {
	char[][] seats= {{'.','.','.','.','#','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','#','.'},{'.','.','.','.','.','.','.','.'},{'.','.','#','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','#','.','.','#','.'}};
System.out.println(maxStudents(seats));

	
}
}
