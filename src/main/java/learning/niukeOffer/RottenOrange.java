package main.java.learning.niukeOffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
在给定的网格中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
知识点：岛屿问题
* */
public class RottenOrange {
    public static int orangeRotting(int[][] grid) {
        int M = grid.length;  //行数
        int N = grid[0].length;  //列数
        Queue<int[]> queue = new LinkedList<>();  //队列存储腐烂橘子的坐标，队列可用在数据只使用一次并需要添加新数据的地方

        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {//循环遍历网格中的橙子
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        int round = 0; // round 表示腐烂的轮数，或者分钟数
        while (count > 0 && !queue.isEmpty()) {//还有新鲜橘子且烂橘子不为0
            round++;
            int n = queue.size(); //烂橘子个数
            for (int i = 0; i < n; i++) {//每一次循环都把队列中的烂橘子用完，下一次for循环就是新一轮的烂橘子
                int[] orange = queue.poll(); //移除并返问队列头部的元素。取出是因为腐烂的橘子只能有一轮有用，一轮之后就没用了
                int r = orange[0];
                int c = orange[1]; //获取当前腐烂橘子的行和列
                if (r-1 >= 0 && grid[r-1][c] == 1) {//上方向可以走，且有新鲜橘子
                    grid[r-1][c] = 2;
                    count--;
                    queue.add(new int[]{r-1, c});//新鲜橘子-1，新腐烂的橘子添加到队列中
                }
                if (r+1 < M && grid[r+1][c] == 1) {//下方向
                    grid[r+1][c] = 2;
                    count--;
                    queue.add(new int[]{r+1, c});
                }
                if (c-1 >= 0 && grid[r][c-1] == 1) {//左
                    grid[r][c-1] = 2;
                    count--;
                    queue.add(new int[]{r, c-1});
                }
                if (c+1 < N && grid[r][c+1] == 1) {//右
                    grid[r][c+1] = 2;
                    count--;
                    queue.add(new int[]{r, c+1});
                }
            }
        }

        if (count > 0) {
            return -1;
        } else {
            return round;
        }

    }

}
