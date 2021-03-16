package YFD;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class YFD662_prod {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> index = new LinkedList<>();
        queue.addFirst(root);
        index.addFirst(1);
        int res = 1;
        while(!queue.isEmpty()){
            int N = queue.size();
            for(int i = 0; i < N; i++){
                TreeNode pop = queue.removeLast();
                int currentIndex = index.removeLast();
                if(pop.left!=null){
                    queue.addFirst(pop.left);
                    index.addFirst(currentIndex * 2);
                }
                if(pop.right!=null){
                    queue.addFirst(pop.right);
                    index.addFirst(currentIndex * 2 + 1);
                }
            }
            if(index.size()>=2){
                res = Math.max(res,index.getFirst()-index.getLast()+1);
            }
        }
        return res;
    }
}
