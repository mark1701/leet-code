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
            dfs(root, 1);
        
        return maxLength;        
    }
    
    private void dfs(TreeNode node, int currLength){
        maxLength = Math.max(maxLength, currLength);
        if(node.left != null){
            int newVal = (node.left.val == node.val + 1) ? (currLength + 1) : 1;
            dfs(node.left, newVal);
        }
        if(node.right != null){
            int newVal = (node.right.val == node.val + 1) ? (currLength + 1) : 1;
            dfs(node.right, newVal);
        }     
    }
}