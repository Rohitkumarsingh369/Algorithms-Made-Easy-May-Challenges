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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node=head;
        int n=countnode(head);   
        return sortedListToBSTUtil(n);
    }
    public int countnode(ListNode head){
        int count = 0;
        ListNode temp = head;
        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
       
        return count;
    }
    public TreeNode sortedListToBSTUtil(int n){
        if(n<=0)
            return null;
        
        TreeNode left=sortedListToBSTUtil(n/2);
        
        TreeNode root=new TreeNode(node.val);
        root.left=left;
        
        node=node.next;
        
        root.right=sortedListToBSTUtil(n-n/2-1);
        
        return root;
    }
}