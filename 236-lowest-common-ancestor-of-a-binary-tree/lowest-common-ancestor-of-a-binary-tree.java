
class Solution {
    public boolean exist(TreeNode root, TreeNode node){
        if(root==node){
            return true;
        }
        if(root==null) return false;
        return exist(root.left,node) || exist(root.right,node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q) return root;
        boolean pexistinleft = exist(root.left,p);
        boolean qexistinleft = exist(root.left,q);
        if(pexistinleft==true && qexistinleft==true) return lowestCommonAncestor(root.left , p ,q);
        if(pexistinleft==false && qexistinleft==false) return lowestCommonAncestor(root.right , p ,q);
        else{
            return root;
        }

    }
}