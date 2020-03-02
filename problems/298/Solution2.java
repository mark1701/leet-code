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
    private int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {        
        if(root != null)
            dfs(root, null, 1);
        
        return maxLength;        
    }
    
    private void dfs(TreeNode node, TreeNode parent, int currLength){
            if(node == null) return;
        
            currLength = (parent != null && node.val == parent.val + 1) ? (currLength + 1) : 1;
            maxLength = Math.max(maxLength, currLength);        
            
            dfs(node.left, node, currLength);
            dfs(node.right, node, currLength);
    }
}