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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        
        List<Integer> level=new ArrayList<>();
        Queue<TreeNode> q1=new LinkedList<>();
         Queue<TreeNode> q2=new LinkedList<>();
        q1.add(root);
        
        while(!q1.isEmpty()|| !q2.isEmpty()){
            
            while(!q1.isEmpty()){
                TreeNode temp=q1.peek();
                q1.remove();
                level.add(temp.val);
                
                if(temp.left!=null)
                    q2.add(temp.left);
                if(temp.right!=null)
                    q2.add(temp.right);
            }
            if(!level.isEmpty())
                result.add(new ArrayList<>(level));
            level.clear();
            
            while(!q2.isEmpty()){
                TreeNode temp=q2.peek();
                q2.remove();
                level.add(temp.val);
                
                if(temp.left!=null)
                    q1.add(temp.left);
                if(temp.right!=null)
                    q1.add(temp.right);
            }
            if(!level.isEmpty())
                result.add(new ArrayList<>(level));
            level.clear();
        }
        
        return result;
    }
}