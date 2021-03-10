package hot100;

public class Hot10_prod2 {
    public boolean isMatch(String s, String p) {
        return recur(s.toCharArray(), p.toCharArray(), s.length()-1, p.length()-1);
    }

    private boolean recur(char[] ss, char[] pp, int sIdx, int pIdx){
        if (pIdx < 0)
            return sIdx == pIdx;
        if (sIdx < 0) {
            while(pIdx >= 0 && pp[pIdx] == '*')
                pIdx -= 2;
            return sIdx == pIdx;
        }

        if (pp[pIdx] != '*') {
            if (pp[pIdx] == ss[sIdx] || pp[pIdx] == '.')
                return recur(ss, pp, sIdx - 1, pIdx - 1);
            else
                return false;
        } else {
            if (recur(ss ,pp, sIdx, pIdx - 2))
                return true;
            char temp = pp[pIdx - 1];
            int sIdxMov = sIdx;
            while(sIdxMov >= 0 && (temp == '.' || temp == ss[sIdxMov])){
                if (recur(ss,pp,sIdxMov - 1, pIdx - 2))
                    return true;
                sIdxMov--;
            }
            return false;
        }
    }
}
