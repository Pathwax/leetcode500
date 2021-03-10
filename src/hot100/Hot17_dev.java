package hot100;

import java.util.*;

public class Hot17_dev {
    List<String> res;
    Map<Character, Character[]> hashmap = new HashMap<Character, Character[]>(){{
        put('2',new Character[]{'a','b','c'});
        put('3',new Character[]{'d','e','f'});
        put('4',new Character[]{'g','h','i'});
        put('5',new Character[]{'j','k','l'});
        put('6',new Character[]{'m','n','o'});
        put('7',new Character[]{'p','q','r','s'});
        put('8',new Character[]{'t','u','v'});
        put('9',new Character[]{'w','x','y','z'});
    }};
    public List<String> letterCombinations(String digits) {
        this.res = new ArrayList<>();
        if(digits.length()==0)
            return res;
        dfs(digits.toCharArray(),0,new StringBuilder(),digits.length());
        return res;
    }

    private void dfs(char[] digits,int index,StringBuilder sb,int sum){
        if (index==sum){
            res.add(sb.toString());
            return;
        }
        Character[] cs = hashmap.get(digits[index]);
        for (Character c : cs) {
            sb.append(c);
            dfs(digits,index + 1,sb,sum);
            sb.delete(sb.length()-1,sb.length());
        }
    }
}
