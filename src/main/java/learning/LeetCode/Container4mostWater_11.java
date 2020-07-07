package main.java.learning.LeetCode;
/*
盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
输入：[1,8,6,2,5,4,8,3,7]
输出：49
题目描述的很抽象，起始就是坐标轴当容器来用，希望找出当前坐标轴情况下的最大容量是多少 max(横*纵)
双指针法：O(N)
* */
public class Container4mostWater_11 {
    public int maxArea(int[] height){
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i<j){
            int area = (j-i) * Math.min(height[i],height[j]);//计算当前的面积值
            res = Math.max(res,area);//获取当前面积和已知最大面积的较大值
            if(height[i]>height[j]){//左边的柱子高于右边的，那么当前容器的高是由右边柱子决定的，所以调整(最短的模板)右柱才有实际意义
                j--;
            }else{//左边的低，调整左边(每次调整宽必定减少，所以只能调整矮的边去寻找更高的柱子才有可能找到大于当前值的容量(宽*高))
                i++;
            }
        }
        return res;
    }
}
