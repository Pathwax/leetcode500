package meituan;

import util.TreeNode;

// 二叉树两指定节点的最近公共祖先
public class MT236_prod {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left==null) return right;
        if (right==null) return left;
        return root;
        // if(left == null && right == null) return null; // 1.
        // if(left == null) return right; // 3.
        // if(right == null) return left; // 4.
        // return root; // 2. if(left != null and right != null)
    }
}
