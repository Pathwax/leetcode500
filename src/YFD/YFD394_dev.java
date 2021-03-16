package YFD;

import java.util.ArrayDeque;
import java.util.Deque;

public class YFD394_dev {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> charStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                if (i>0&&s.charAt(i-1)>='0'&&s.charAt(i-1)<='9'){
                    Integer pop = numStack.pop();
                    numStack.push(pop*10+ s.charAt(i)-'0');
                }else{
                    numStack.push(s.charAt(i)-'0');
                }
            } else if(s.charAt(i)=='['){
                charStack.push(new StringBuilder());
            } else if(s.charAt(i)==']'){
                int loopNum = numStack.pop();
                StringBuilder temp = charStack.pop();
                if(numStack.isEmpty()){
                    for(int j = 0; j < loopNum; j++){
                        sb.append(temp);
                    }
                }else{
                    if (charStack.isEmpty()){
                        for(int j = 1; j < loopNum; j++){
                            temp.append(temp);
                        }
                        charStack.push(temp);
                    }else{
                        StringBuilder basic = charStack.pop();
                        for(int j = 0; j < loopNum; j++){
                            basic.append(temp);
                        }
                        charStack.push(basic);
                    }
                }
            } else{
                if(!numStack.isEmpty()){
                    StringBuilder temp = charStack.pop();
                    temp.append(s.charAt(i));
                    charStack.push(temp);
                }else{
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
