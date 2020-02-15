package t5332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TweetCounts {
Map<String,List<Integer>> memo;Map<String, Integer> huansuanMap;
    public TweetCounts() {
       memo=new HashMap<String, List<Integer>>();
      
    }
    
    public void recordTweet(String tweetName, int time) {
        if(!memo.containsKey(tweetName)) {
        	memo.put(tweetName, new ArrayList<Integer>());
        }
        	memo.get(tweetName).add(time);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
    	List<Integer> result=new ArrayList<Integer>();
        if(memo.containsKey(tweetName)) {
        	List<Integer> list=memo.get(tweetName);
        	 huansuanMap=new HashMap<String, Integer>();
             huansuanMap.put("hour", 3600);huansuanMap.put("minute", 60);
             huansuanMap.put("day", 3600*24);
        	int time=huansuanMap.get(freq);
        	int jg=(endTime-startTime)/time+1;
        	for (int i = 0; i < jg; i++) {
				int count=0;
				for (int j = 0; j < list.size(); j++) {
					int cc=list.get(j);
					if(cc>=startTime+i*time&&cc<endTime+i*time)count++; 
				}
				result.add(count);
			}
        }
        return result;
    }
    @Test
    public void ss() {
    	TweetCounts tweetCounts = new TweetCounts();
    	tweetCounts.recordTweet("tweet3", 0);
    	tweetCounts.recordTweet("tweet3", 60);
    	tweetCounts.recordTweet("tweet3", 10);             
    	// 返回 [2]。统计频率是每分钟（60 秒），因此只有一个有效时间间隔 [0,60> - > 2 条推文。
    	 // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。 
    	                            // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
      // 返回 [4]。统计频率是每小时（3600 秒），因此只有一个有效时间间隔 [0,211> - > 4 条推文。
    System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 10, 59));
    System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));
    tweetCounts.recordTweet("tweet3", 120);
    System.out.print(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210));
    	
    }
}
