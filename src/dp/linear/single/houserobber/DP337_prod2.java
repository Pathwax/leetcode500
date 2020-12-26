package dp.linear.single.houserobber;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DP337_prod2 {
    Map<TreeNode,Integer> map;
    public int rob(TreeNode root) {
        this.map = new HashMap<>();
        return myRob(root);
    }
    private int myRob(TreeNode root){
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int money = root.val;
        if (root.left!=null)
            money+=(myRob(root.left.left)+myRob(root.left.right));
        if (root.right!=null)
            money+=(myRob(root.right.left)+myRob(root.right.right));
        int result = Math.max(money,myRob(root.left)+myRob(root.right));
        map.put(root,result);
        return result;
    }
}
