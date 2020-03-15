/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int longestConsecutive(TreeNode root) {        
        return dfs(root, null, 0);
    }
    
    private int dfs(TreeNode n, TreeNode parent, int length){
            if(n == null) return length;
        
            length = (parent != null && n.val == parent.val + 1) ? (length + 1) : 1;
            
            return Math.max(length, 
                            Math.max(dfs(n.left, n, length), dfs(n.right, n, length)));
    }
}