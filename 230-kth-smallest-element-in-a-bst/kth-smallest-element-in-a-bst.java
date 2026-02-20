class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return solve(root, k).val;
    }

    TreeNode solve(TreeNode node, int k){
        if(node == null) return null;

        TreeNode left = solve(node.left, k);
        if(left != null) return left;

        count++;

        if(count == k) return node;

        return solve(node.right, k);
    }
}
