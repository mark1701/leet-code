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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res){
        if(node == null) return;
        
        path.add(node.val);
        
        if(node.left == null && node.right == null){
            if(sum == node.val) res.add(new ArrayList<Integer>(path));            
        }else{        
            dfs(node.left, sum-node.val, path, res);
            dfs(node.right, sum-node.val, path, res);
        }
        
        path.remove(path.size()-1);        
    }  
}