package meituan;

public class MT11_dev {
    public int maxArea(int[] height) {
        int N = height.length;
        int res = 0;
        for(int i = 0; i < N - 1; i++){
            if(height[i] <= height[N-1]){
                res = Math.max(res,height[i] * (N - 1 - i));
                continue;
            }else{
                res = Math.max(res,height[N-1] * (N - 1 - i));
                int maxRight = height[N-1];
                for(int j = N - 2; j > i; j--){
                    if(height[j] < maxRight) continue;
                    else if(height[j] >= height[i]){
                        res = Math.max(res,height[i] * (j - i));
                        break;
                    }else{
                        res = Math.max(res,height[j] * (j-i));
                        maxRight = height[j];
                    }
                }
            }
        }
        return res;
    }
}
