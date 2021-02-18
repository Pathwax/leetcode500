package meituan;

import util.TreeNode;

public class MT124_prod {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root){
        if (root == null) return 0; // 遍历到null节点，收益0
        int left = dfs(root.left); // 左子树提供的最大路径和
        int right = dfs(root.right); // 右子树提供的最大路径和
        int innerMaxSum = root.val + left + right; // 当前子树内部的最大路径和
        maxSum = Math.max(maxSum,innerMaxSum);
        int outputMaxSum = root.val + Math.max(left,right); //当前子树对外提供的最大路径和
        if (outputMaxSum < 0) outputMaxSum =  0; // 对外提供的路径和为负，直接返回0
        return outputMaxSum; // 非负，则正常返回
    }
}
