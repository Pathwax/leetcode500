package dp.linear.single.houserobber;

import util.TreeNode;

public class DP337_prod3 {
    public int rob(TreeNode root) {
        int[] result = myRob(root);
        return Math.max(result[0],result[1]);
    }
    private int[] myRob(TreeNode root){
        if (root==null)
            return new int[]{0,0};
        int[] res = new int[2];
        int[] left = myRob(root.left);
        int[] right = myRob(root.right);
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = root.val+left[0]+right[0];
        return res;
    }
}
