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
    public List<TreeNode> allPossibleFBT(int N) {
        
        List<TreeNode> res = new ArrayList<>();
        if(N == 1){
            res.add(new TreeNode(0));
        }else if(N % 2 == 1){
            N=N-1;
            for(int i = 1; i <= N; i++){
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N-i);
                for(TreeNode l : left){
                    for(TreeNode r: right){
                        TreeNode node = new TreeNode(0);
                        node.left = l;
                        node.right = r;
                        res.add(node);
                    }
                }
                
            }
        
        }
        
        return res;
    }
}