/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode cur=head;
		ListNode prev=null;
		ListNode next=null;
		int count=0;
		ListNode temp=head;
		int length=0;
		while(temp!=null) {
				length++;
			temp=temp.next;	
		}
		int dig=length/k;
		if(dig>0) {
			if(head==null)
				return null;
			while(count<k&&cur!=null) {
				next=cur.next;
				cur.next=prev;
				prev=cur;
				cur=next;
				count++;
			}
			
		}
		else {
			
			for(int i=0;i<(length%k) && cur!=null;i++) {
				if(prev==null) {
					prev=cur;
					cur=cur.next;
				}
				else {
					if(prev.next==null) {
					prev=cur;
					cur=cur.next;
				}
				}
			}
		}
		if(next!=null)
			head.next=reverseKGroup(next,k);
	return prev;
    }
}