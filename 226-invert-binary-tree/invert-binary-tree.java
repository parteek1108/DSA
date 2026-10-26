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
    public static void swaping(TreeNode root){
        if(root==null){
            return;
        }
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            swaping(root.left);
            swaping(root.right);

    }
    public TreeNode invertTree(TreeNode root) {
        swaping(root);
        return root;
    }
}