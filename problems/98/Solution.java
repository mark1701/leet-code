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
    //my first attempt with inorder visit
    public boolean isValidBST(TreeNode root) {
        List<Integer> visit = new ArrayList<>();
        inOrder(root, visit);
        
        return isAscendingOrder(visit);
    }
    
    private void inOrder(TreeNode node, List<Integer> visit){
        if(node == null) return;
        
        inOrder(node.left, visit);
        visit.add(node.val);
        inOrder(node.right, visit);
    }
    
    private boolean isAscendingOrder(List<Integer> list){
        if(list == null) return false;
        if(list.isEmpty()) return true;
        
        for(int i = 0; i < list.size(); i++){
            if(i+1 == list.size()) break;
            
            if(list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
}