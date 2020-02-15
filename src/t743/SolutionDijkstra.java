package t743;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class SolutionDijkstra {
	   Map<Integer, Integer> dist;
	 public int networkDelayTime(int[][] times, int N, int K) {
	        boolean[] check=new boolean[N+1];
//	        check[K]=true;
	        int[] dis=new int[N+1];
	        Arrays.fill(dis, Integer.MAX_VALUE);
	        dis[K]=0;
	        HashMap<Integer, List<int[]>> map=new HashMap<Integer, List<int[]>>();
	        for (int i = 0; i < times.length; i++) {
				if(!map.containsKey(times[i][0])) {map.put(times[i][0],new ArrayList<int[]>());}
				map.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});
			}
//	        for (int i:map.keySet()) {
//	        	  Collections.sort(map.get(i),new Comparator<int[]>() {
//
//					@Override
//					public int compare(int[] o1, int[] o2) {
//						// TODO Auto-generated method stub
//						return o1[1]-o2[1];
//					}
//				});
//			}
	      while(true) {
	    	  int candNode = -1;
	            int candDist = Integer.MAX_VALUE;
	            for (int i = 1; i <= N; ++i) {
	                if (!check[i] && dis[i] < candDist) {
	                    candDist = dis[i];
	                    candNode = i;
	                }
	            }

	            if (candNode < 0) break;
	            check[candNode] = true;
	            if (map.containsKey(candNode))
	                for (int[] info: map.get(candNode))
	                    dis[info[0]]=
	                             Math.min(dis[info[0]], dis[candNode] + info[1]);

			}
	      int min=Integer.MIN_VALUE;
	       for (int i = 1; i < dis.length; i++) {
			if(dis[i]==Integer.MAX_VALUE) {return -1;}
			min=Math.max(min, dis[i]);
		}
	       return min;
	     
	    }
	 public int networkDelayTime2(int[][] times, int N, int K) {
	        Map<Integer, List<int[]>> graph = new HashMap();
	        for (int[] edge: times) {
	            if (!graph.containsKey(edge[0]))
	                graph.put(edge[0], new ArrayList<int[]>());
	            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
	        }
	        dist = new HashMap();
	        for (int node = 1; node <= N; ++node)
	            dist.put(node, Integer.MAX_VALUE);

	        dist.put(K, 0);
	        boolean[] seen = new boolean[N+1];

	        while (true) {
	            int candNode = -1;
	            int candDist = Integer.MAX_VALUE;
	            for (int i = 1; i <= N; ++i) {
	                if (!seen[i] && dist.get(i) < candDist) {
	                    candDist = dist.get(i);
	                    candNode = i;
	                }
	            }

	            if (candNode < 0) break;
	            seen[candNode] = true;
	            if (graph.containsKey(candNode))
	                for (int[] info: graph.get(candNode))
	                    dist.put(info[0],
	                             Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
	        }

	        int ans = 0;
	        for (int cand: dist.values()) {
	            if (cand == Integer.MAX_VALUE) return -1;
	            ans = Math.max(ans, cand);
	        }
	        return ans;
	    }


	 @Test
	 public void ss() {
		 int[][] times= {{2,1,1},{2,3,1},{3,4,1}};
		 int N=4;int K=2;
		 System.out.println(networkDelayTime(times, N, K));
		 System.out.println(networkDelayTime2(times, N, K));
	 }
}
