package LCCI.chapter16;

public class Solution15_dev {
    public int[] masterMind(String solution, String guess) {
        int[] res = new int[]{0,0};
        boolean[] tag = new boolean[]{true,true,true,true};
        for (int i = 0; i < solution.length(); i++) {
            if (solution.charAt(i)==guess.charAt(i)){
                res[0]++;
                tag[i] = false;
            }
        }
        if (res[0]==4) return res;
        boolean[] tag2 = new boolean[]{true,true,true,true};
        for (int i = 0; i < guess.length(); i++) {
            if (tag[i]){
                for (int j = 0; j < solution.length(); j++) {
                    if (tag[j]&&tag2[j]){
                        if (guess.charAt(i)==solution.charAt(j)){
                            res[1]++;
                            tag2[j] = false;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
