package LCCI.chapter16;

import java.util.*;

public class Solution22_prod {
    private class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj){
            if (obj==this)
                return true;
            if (!(obj instanceof Position))
                return false;
            Position o = (Position) obj;
            return x == o.x&&y == o.y;
        }
        @Override
        public int hashCode(){
            return 31*x+y;
        }
    }
    public List<String> printKMoves(int K) {
        char[] direction = {'L','U','R','D'};
        // 用“向量”记录方向（二维平面的移动方向），顺序与上一行方向的字符顺序保持一致，每个元素的后一个元素都是可以90°向右变换得到的
        int[][] offset = {{-1,0},{0,-1},{1,0},{0,1}};
        // 蚂蚁的位置
        Position antPos = new Position(0,0);
        // 蚂蚁方向的向量序号
        int antDir = 2;
        // 用集合存储所有黑块的坐标
        Set<Position> blackSet = new HashSet<>();
        while(K>0){
            Position t = new Position(antPos.x,antPos.y);
            // 如果能够存入黑块集合，说明脚下的块不在集合中（白色），方向序号循环自增1
            if (blackSet.add(t)) antDir = (antDir + 1)%4;
            else{
                // 否则说明脚下的块已经在集合中（黑色），方向序号循环自增3（相当于自减1）
                antDir = (antDir+3)%4;
                blackSet.remove(t);
            }
            // 蚂蚁移动位置
            antPos.x += offset[antDir][0];
            antPos.y += offset[antDir][1];
            K--;
        }
        // 计算边界，即输出网格的行数和列数
        int left = antPos.x, top = antPos.y, right = antPos.x, bottom = antPos.y;
        for (Position pos : blackSet) {
            left = pos.x<left?pos.x:left;
            top = pos.y<top?pos.y:top;
            right = pos.x>right?pos.x:right;
            bottom = pos.y>bottom?pos.y:bottom;
        }
        char[][] grid = new char[bottom-top+1][right-left+1];
        // 填充白块
        for(char[] row:grid)
            Arrays.fill(row,'_');
        // 替换黑块
        for (Position pos : blackSet) {
            grid[pos.y-top][pos.x-left] = 'X';
        }
        grid[antPos.y-top][antPos.x-left] = direction[antDir];
        // 利用网格生成字符串列表
        List<String> res = new ArrayList<>();
        for (char[] row : grid) {
            res.add(String.valueOf(row));
        }
        return res;
    }
}
