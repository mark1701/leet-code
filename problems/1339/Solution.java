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
    private long maxProduct = 0, total = 0;
    
    public int maxProduct(TreeNode root) {
        total = dfs(root);
        dfs(root);
        return (int) (maxProduct % (int)(1e9 + 7));
    }
    
    private long dfs(TreeNode n){
        if(n == null) return 0;
        long sum = n.val + dfs(n.left) + dfs(n.right);
        maxProduct = Math.max(maxProduct, (total - sum)*sum);
        return sum;
    }
}