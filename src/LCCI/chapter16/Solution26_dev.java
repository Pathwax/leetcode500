package LCCI.chapter16;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution26_dev {
    public int calculate(String s) {
        Deque<Integer> numStack  = new ArrayDeque<>();
        Deque<Character> operatorStack = new ArrayDeque<>();
        char[] chars = s.trim().toCharArray();
        int index = 0;
        while(index < chars.length){
            if (chars[index]==' ') {index++; continue;}
            if (Character.isDigit(chars[index]))
            {
                int basic = chars[index]-'0';
                index++;
                while (index<chars.length && Character.isDigit(chars[index])){
                    basic = basic*10 + chars[index++]-'0';
                }
                numStack.push(basic);
                if (!operatorStack.isEmpty()&&(operatorStack.peek() == '*' || operatorStack.peek()=='/')) {
                    Character operator = operatorStack.pop();
                    Integer pop1 = numStack.pop();
                    Integer pop2 = numStack.pop();
                    numStack.push(operator == '*'?pop1*pop2:pop2/pop1);
                }
                if (index==chars.length) break;
            }
            if (chars[index]=='+' || chars[index]=='-' || chars[index]=='*'||chars[index]=='/'){
                operatorStack.push(chars[index]);
                index++;
            }
        }
        while(!operatorStack.isEmpty()){
            Character operatorpoll = operatorStack.pollLast();
            Integer poll1 = numStack.pollLast();
            Integer poll2 = numStack.pollLast();
            numStack.addLast(operatorpoll == '+'?poll1+poll2:poll1-poll2);
        }
        return numStack.pop();
    }
}
