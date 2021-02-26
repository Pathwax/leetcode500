package meituan;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MT144_dev {
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        this.res = new ArrayList<>();
        preorderHelper(root);
        return res;
    }
    private void preorderHelper(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        preorderHelper(root.left);
        preorderHelper(root.right);
    }
}
