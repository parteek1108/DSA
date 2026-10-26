
class Solution {
    public boolean helper(TreeNode root, int target,int sum){
        if(root==null){
            return false;
        }
        sum += root.val;
        if(root.left==null && root.right==null && sum==target){
            return true;
        }
        return helper(root.left,target,sum) || helper(root.right,target,sum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum,0);
    }
}