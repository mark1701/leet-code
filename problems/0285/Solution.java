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
    
    private TreeNode successor = null;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        search(root, p);
        return successor;
    }
    
    private void search(TreeNode node, TreeNode p){
        
        if(node == null) return;
        
        if(node.val > p.val){
            successor = node;
            search(node.left, p);
        } else {
            search(node.right, p);
        }
        
    }
    
}