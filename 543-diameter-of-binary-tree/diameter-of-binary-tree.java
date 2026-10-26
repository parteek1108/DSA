
class Solution {
    public  int level(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1 + Math.max(level(root.left),level(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int mydai = level(root.left) + level(root.right);
        int leftdia = diameterOfBinaryTree(root.left);
        int rightdia = diameterOfBinaryTree(root.right);
        return Math.max(mydai , Math.max(leftdia,rightdia));
    }
}