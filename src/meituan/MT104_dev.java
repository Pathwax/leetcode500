package meituan;

import util.TreeNode;

// 二叉树的最大深度
public class MT104_dev {
    int res = 0;
    public int maxDepth(TreeNode root) {
        preOrder(root,1);
        return res;
    }
    private void preOrder(TreeNode root, int maxLevel){
        if(root==null) return;
        res = Math.max(res,maxLevel);
        preOrder(root.left,maxLevel+1);
        preOrder(root.right,maxLevel+1);
    }
}
