package meituan;

// 火星词典

import java.util.*;

/**
 * 现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
 *
 * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个不为空的单词列表。因为是从词典中获得的，所以该单词列表内的单词已经按这门新语言的字母顺序进行了排序。
 *
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 */
// Java 拓扑排序
public class MT269_prod {
    public String alienOrder(String[] words) {
        // 1. 构建图
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j <words[i+1].length(); j++) {
                // 如果字符串相同，比较下一个
                if (words[i].charAt(j) == words[i+1].charAt(j)) continue;
                // 保存第一个不同的字符顺序
                Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                set.add(words[i+1].charAt(j));
                map.put(words[i].charAt(j),set);
                break;
            }
        }
        // 2. 拓扑排序
        // 创建保存入度的数组
        int[] degrees = new int[26];
        Arrays.fill(degrees,-1);
        // 没有出现的字符出度为-1，出现了的字母出度为非负数
        for (String str : words) {
            // 将出现过的字符的出度设定为0
            for (char c : str.toCharArray()) {
                degrees[c-'a'] = 0;
            }
        }
        for (char key : map.keySet()) {
            for(char val : map.get(key)){
                degrees[val-'a']++;
            }
        }
        // 创建StringBuilder保存拓扑排序
        StringBuilder sb = new StringBuilder();
        // 创建一个Queue保存入度为0的节点
        Queue<Character> list = new LinkedList<>();

        // 计算图中节点数
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (degrees[i] != -1) count++;
            if (degrees[i] == 0) list.add((char)('a'+i));
        }

        while(!list.isEmpty()){
            Character cur = list.poll();
            sb.append(cur);
            // 将邻接点的出度-1
            if (map.containsKey(cur)) {
                Set<Character> set = map.get(cur);
                for (Character c : set) {
                    degrees[c-'a']--;
                    if (degrees[c-'a']==0) list.add(c);
                }
            }
        }

        // 判断是否有环
        if (sb.length() != count) return "";
        else return sb.toString();
    }
}
