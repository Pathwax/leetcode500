package LCOF;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 二叉树镜像 辅助栈
public class Solution27_dev {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.left!=null) stack.push(pop.left);
            if (pop.right!=null) stack.push(pop.right);
            TreeNode temp = pop.right;
            pop.right = pop.left;
            pop.left = temp;
        }
        return root;
    }
}
