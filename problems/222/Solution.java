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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int d = findDepth(root);
        if(d == 0) return 1;
        
        int l = 1; 
        int r = (int)Math.pow(2,d) - 1;
        while (l <= r){
            
            int m = l + (r - l)/2;
            if(exists(m, d, root)){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        
        return (int) Math.pow(2, d) -1 + l;
    }
    
    private boolean exists(int index, int d, TreeNode root){
    
        int l = 0;
        int r = (int)Math.pow(2, d) - 1;
        
        for(int i = 0; i < d; i++){
            int m = l + (r - l)/2;
            if(index <= m){
                root = root.left;
                r = m;
            }else{
                l = m + 1;
                root = root.right;
            }
        }
        return root != null;
    }
    
    
    private int findDepth(TreeNode node){
        if(node == null) return 0;
        int depth = 0;
        while (node.left != null){
            depth++;
            node = node.left;
        }
        return depth;
    }
}