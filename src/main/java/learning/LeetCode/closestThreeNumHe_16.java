package main.java.learning.LeetCode;

import com.sun.javafx.image.BytePixelSetter;

import java.util.Arrays;

/*
最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
返回这三个数的和。假定每组输入只存在唯一答案。

* */
public class closestThreeNumHe_16 {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);//排序
        int res =Integer.MAX_VALUE;
        for (int k = 0; k < nums.length -2; k++) {//最小的数作为外循环
            if(k>0 && nums[k] == nums[k+1]) continue;//过滤重复的元祖
            int i = k+1,j=nums.length-1;//固定第一个数后，对后面两个数字用双指针
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                int closer = Math.abs((sum - target));//差的绝对值
                if(closer < Math.abs((res - target))){//差值小于当前的最接近值
                    res = sum;
                    //while (i<j && nums[i] == nums[++i]) {}//相当于移动左边的标的同时过滤重复元祖
                }
                if(sum < target ){//这里的移动不管上面是否满足都需要执行
                    while (i<j && nums[i] == nums[++i]) {}//让sum增大
                }else if(sum > target){
                    while (i<j && nums[j] == nums[--j]) {}//让sum减小
                }else
                    return res;
            }
        }
        return res;

    }
}
