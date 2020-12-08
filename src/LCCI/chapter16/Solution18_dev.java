package LCCI.chapter16;

import java.util.ArrayList;

public class Solution18_dev {
    String pattern;
    String value;
    String a;
    String b;
    public boolean patternMatching(String pattern, String value) {
        this.pattern = pattern;
        this.value = value;
        int patLen = pattern.length();
        int valLen = value.length();
        int aNum = 0, bNum = 0;
        for (int i = 0; i < patLen; i++) {
            if (pattern.charAt(i)=='a')
                aNum++;
            else
                bNum++;
        }
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <= valLen; i++) {
            for (int j = 0; j <= valLen; j++) {
                if (i*aNum+j*bNum==valLen)
                    list.add(new int[]{i,j});
            }
        }
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            int[] candidate = list.get(i);
            int valueStartIndex = 0;
            int j = 0;
            for (; j < patLen; j++) {
                if(!match(candidate,j,valueStartIndex)){
                    break;
                }
                valueStartIndex+=(pattern.charAt(j)=='a'?candidate[0]:candidate[1]);
            }
            if (j==patLen){
                if (this.b!=null&&this.a!=null){
                    if (!this.a.equals(this.b)) {
                        result = true;
                        break;
                    }
                }else{
                    result = true;
                    break;
                }
            }
            this.a = null;
            this.b = null;
        }
        return result;
    }
    private boolean match(int[] candidate, int start1, int start2){
        if (pattern.charAt(start1)=='a'){
            if (this.a==null){
                if (candidate[0]==0)
                    this.a="";
                else
                    this.a = value.substring(start2,start2+candidate[0]);
                return true;
            }else{
                if (candidate[0]==0)
                    if (this.a=="")
                        return true;
                    else return false;
                if (a.equals(value.substring(start2,start2+candidate[0])))
                    return true;
                else
                    return false;
            }
        }
        else {
            if (this.b==null){
                if (candidate[1]==0)
                    this.b="";
                else
                    this.b = value.substring(start2,start2+candidate[1]);
                return true;
            }else{
                if (candidate[1]==0)
                    if (this.b=="")
                        return true;
                    else return false;
                if (b.equals(value.substring(start2,start2+candidate[1])))
                    return true;
                else
                    return false;
            }
        }
    }
}
