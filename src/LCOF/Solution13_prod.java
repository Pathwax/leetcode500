package LCOF;

import java.util.*;

public class Solution13_prod {
    List<String> res = new ArrayList<>();
    char[] chars;
    // 回溯+交换
    public String[] permutation(String s){
        this.chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }
    private void dfs(int layer){
        if (layer==chars.length-1){
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = layer; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i,layer);
            dfs(layer+1);
            swap(i,layer);
        }
    }
    private void swap(int index1, int index2){
        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
