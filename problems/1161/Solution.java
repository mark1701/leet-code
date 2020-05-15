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
    public int maxLevelSum(TreeNode root) {       
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        int[] levelSum = new int[]{1,root.val};
        int level = 0;
        
        while(!queue.isEmpty()){            
            int size = queue.size();
            int sum = 0;
            level++;
            while(size > 0){
                TreeNode node = queue.poll();
                size--;
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(sum > levelSum[1]) {
                levelSum[0] = level;
                levelSum[1] = sum;
            }
        }
        
        return levelSum[0];
    }
}