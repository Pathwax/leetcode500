package YFD;

import util.TreeNode;

public class YFD114_prod {
    public void flatten(TreeNode root) {
        while(root != null) {
            if (root.left != null) {
                TreeNode rightPos = root.left;
                while (rightPos.right != null) {
                    rightPos = rightPos.right;
                }
                rightPos.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
