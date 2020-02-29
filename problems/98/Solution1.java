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
    //second solution - purely recursive
    public boolean isValidBST(TreeNode root) {
        return checkTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean checkTree(TreeNode node, long minLimit, long maxLimit){
        if(node == null) return true;

        if(node.val <= minLimit || node.val >= maxLimit)
            return false;
        
        return checkTree(node.left, minLimit, node.val) && checkTree(node.right, node.val, maxLimit);
    }
}