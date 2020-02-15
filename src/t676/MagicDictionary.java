package t676;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import t5330.TreeNode;

public class MagicDictionary {
	List<String> memoList;
	 /** Initialize your data structure here. */
    public MagicDictionary() {
        memoList=new ArrayList<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
       for(String a:dict) {
    	   memoList.add(a);
       }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
    	char[] words=word.toCharArray();
        for (String a:memoList) {
        	int count=0;
        	char[] aa=a.toCharArray();
        	if(words.length!=aa.length) {continue;}
        	for (int i = 0; i < words.length; i++) {
				if(aa[i]!=words[i]) {count++;}
				if(count==2) {break;}
				if(i==word.length()-1&&count==1) {return true;}
			}
		}
        return false;
    }
    @Test
	  public void ss() {
	  MagicDictionary aDictionary=new MagicDictionary();
	  String[] aStrings={"hello","hallo","leetcode"};
	  aDictionary.buildDict(aStrings);
	  aDictionary.search("hello");
	  aDictionary.search("hallo");
	  aDictionary.search("hell");
	  aDictionary.search("leetcodd");
	  }
}

