package t1332;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution {
	public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
		List<Integer> checkedList = new ArrayList<Integer>();
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		boolean flag;
		boolean flag2;
		boolean flag3;
		for (int i = 0; i < restaurants.length; i++) {
			flag = false;
			flag3 = false;
			flag2 = false;
			if (restaurants[i][2] == veganFriendly || veganFriendly == 0) {
				flag = true;
			}
			if (restaurants[i][3] <= maxPrice) {
				flag2 = true;
			}
			if (restaurants[i][4] <= maxDistance) {
				flag3 = true;
			}
			if (flag && flag2 && flag3) {
				checkedList.add(restaurants[i][0]);
				map.put(restaurants[i][0], restaurants[i][1]);
			}
		}
		Collections.sort(checkedList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (map.get(o1) > map.get(o2)) {
					return -1;
				} else if (map.get(o1).equals(map.get(o2)) ) {
					return o1 > o2 ? -1 : 1;
				} else {
					return 1;
				}
			}
		});
		return checkedList;
	}

	
}
