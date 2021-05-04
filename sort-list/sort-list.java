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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        return head;
        
        ListNode middle=getmiddle(head);
        ListNode nextofmiddle=middle.next;
        middle.next=null;
        
        ListNode left=sortList(head);
        ListNode right=sortList(nextofmiddle);
        
        ListNode sortedlist=sortmerge(left,right);
        return sortedlist;
    }
    static ListNode getmiddle(ListNode head){
        if(head==null)
            return head;
            
            ListNode slow=head,fast=head;
            
            while(fast.next!=null  && fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            
            return slow;
    }
    static ListNode sortmerge(ListNode a,ListNode b){
        if(a==null)
            return b;
            
            if(b==null)
            return a;
            
            
            ListNode result=null;
            if(a.val<=b.val){
                result=a;
                result.next=sortmerge(a.next,b);
            }
            else{
                result=b;
                result.next=sortmerge(a,b.next);
            }
            
            
            return result;
    }
}