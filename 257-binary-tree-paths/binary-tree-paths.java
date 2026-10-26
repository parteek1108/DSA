
class Solution {
    public void helper(TreeNode root,String s,List<String> list){
        if(root==null) return;
        if(root.left==null && root.right == null){
            s+= root.val;
            list.add(s);
            return ;
        }
        helper(root.left,s+root.val +"->",list);
        helper(root.right,s+root.val +"->",list);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        helper(root,"",list);
        return list;
    }
}