package LCOF;

import java.util.HashMap;
import java.util.Map;

public class Solution67_dev {
    public int strToInt(String str) {
        AutoMachine autoMachine = new AutoMachine();
        for (int i = 0; i < str.length(); i++) {
            autoMachine.transfer(str.charAt(i));
        }
        return (int) (autoMachine.sign*autoMachine.res);
    }

    static class AutoMachine{
        public long res = 0;
        public int sign = 1;
        private String state = "start";
        private final Map<String,String[]> machine = new HashMap<String,String[]>(){{
            put("start",new String[]{"start","signed","in_num","end"});
            put("signed",new String[]{"end","end","in_num","end"});
            put("in_num",new String[]{"end","end","in_num","end"});
        }};
        public void transfer(char c){
            if ("end".equals(state))
                return;
            state = machine.get(state)[getIndex(c)];
            if ("in_num".equals(state)){
                res = res * 10 + c - '0';
                if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){
                    state = "end";
                    res = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            else if ("signed".equals(state)&&c=='-'){
                sign = -1;
            }
        }
        private int getIndex(char c){
            if (c==' ')
                return 0;
            else if (c=='+'||c=='-')
                return 1;
            else if (Character.isDigit(c))
                return 2;
            else
                return 3;
        }
    }
}


