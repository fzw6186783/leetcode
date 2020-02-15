package t24;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution2 {
	 public ListNode reverseKGroup(ListNode head, int k) {
		 if(head==null) {return head;}
		 if(k==1) {return head;}
		 List<ListNode> heads=new ArrayList<ListNode>();
		 List<ListNode> weis=new ArrayList<ListNode>();
		 heads.add(head);
		 int count=1;
	        while(head.next!=null) {
	        	head=head.next;
	        	count++;
	        if(count==k) {
	        	weis.add(head);
	        	head=head.next;
	        	heads.add(head);
	        	weis.get(weis.size()-1).next=null;
	        	if(head==null) {break;}
	        	count=1;
	        }
	        }
	        if(weis.size()==0) {return heads.get(0);}
	       for (int i = 0; i < heads.size()&&i<weis.size(); i++) {
			reverseList(heads.get(i));
		}
	       for (int i = 0; i < heads.size(); i++) {
	    	if(weis.size()==i+1) {
	    		//if(heads.size()-1==i) {heads.get(i).next=null;}
	    		heads.get(i).next=heads.get(i+1);
	    		return weis.get(0);
	    		}
			heads.get(i).next=weis.get(i+1);
		}
	       return weis.get(0);
	        
	    }
	   public ListNode reverseList(ListNode head) {
		    ListNode prev = null;
		    ListNode curr = head;
		    while (curr != null) {
		        ListNode nextTemp = curr.next;
		        curr.next = prev;
		        prev = curr;
		        curr = nextTemp;
		    }
		    return prev;
		}
	   @Test
	   public void ss() {
		   ListNode a1=new ListNode(1);ListNode a2=new ListNode(2);ListNode a3=new ListNode(3);
		   ListNode a4=new ListNode(4);ListNode a5=new ListNode(5);
		   a1.next=a2;a2.next=a3;a3.next=a4;a4.next=a5;
		   System.out.print(reverseKGroup(a1, 3));
	   }
}
