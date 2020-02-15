package t24;

public class Solution {
	 public ListNode swapPairs(ListNode head) {
	        if(head==null||head.next==null) {return head;}
	        ListNode pree=new ListNode(3);
	        ListNode pre=head;ListNode now=head.next;ListNode next=null;
	        ListNode head2=head;
	        while(true) {
	        	next=now.next;
	        	pree.next=now;
	        	pre.next=next;
	        	now.next=pre;
	        	pree=pre;
	        	if(pre.next==null) {break;}
	        	pre=pre.next;
	        	if(pre.next==null) {break;}
	        	now=pre.next;
	        	
	        }
	        return head2;
	    }
}
