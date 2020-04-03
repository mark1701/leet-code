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
    boolean success = true;
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        
        
        visit(root1, root2);
        
        return success;
    }
    
    private void visit(TreeNode root1, TreeNode root2){        
        
        if(!areEqual(root1, root2)) {
            success = false;
            return;
        }        
        
        if(root1 == null) return;
        
        if(areEqual(root1.left, root2.left) && areEqual(root1.right, root2.right)){
            visit(root1.left, root2.left);
            visit(root1.right, root2.right);
        } else if(areEqual(root1.left, root2.right) && areEqual(root1.right, root2.left)){
            visit(root1.left, root2.right);
            visit(root1.right, root2.left);
        } else{
            success = false;
        }
    }
    
    private boolean areEqual(TreeNode n, TreeNode m){
        if(n == null && m == null) return true;
        if(n == null || m == null) return false;
        return n.val == m.val;
    }
}