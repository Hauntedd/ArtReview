package main.java.learning.LeetCode;

import java.util.LinkedList;
import java.util.List;

/*
螺旋矩阵：59题和这个太相似了，告辞
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
* */
public class _54_SpiralMatrix {
    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if(matrix==null||matrix.length==0)
            return result;
        int left = 0;
        int right = matrix[0].length - 1;//列的左右(索引)
        int top = 0;
        int bottom = matrix.length - 1;//行的上下
        int numEle = matrix.length * matrix[0].length;//元素的总数，长*宽
        while (numEle >= 1) {//根据元素的总数进行循环输出
            for (int i = left; i <= right && numEle >= 1; i++) {//输出上行
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;//上行下移
            for (int i = top; i <= bottom && numEle >= 1; i++) {//输出右列
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;//左移
            for (int i = right; i >= left && numEle >= 1; i--) {//输出下行
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;//上移
            for (int i = bottom; i >= top && numEle >= 1; i--) {//输出左列
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;//右移
        }
        return result;
    }
}
