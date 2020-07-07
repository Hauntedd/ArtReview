package main.java.learning.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
思路：先排序，后双指针
* */
public class threeNumHe_15 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);//先从小到大排序
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length -2; k++) {//最小的数作为外循环
            if(nums[k]>=0)
                break;
            if(k>0 && nums[k] == nums[k+1]) continue;//过滤重复的元祖
            int i = k+1,j=nums.length-1;//固定第一个数后，对后面两个数字用双指针
            while (i<j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum <0){
                    while (i<j && nums[i] == nums[++i]) {}//相当于移动左边的标的同时过滤重复元祖
                }else if(sum >0){
                    while (i<j && nums[j] == nums[--j]) {}
                }else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[k],nums[j])));//添加三元组
                    while (i<j && nums[i] == nums[++i]) {}
                    while (i<j && nums[j] == nums[--j]) {}//移动指针并过滤重复元祖
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int a = 10;
        while (10>11&&a== ++a){}
        System.out.println(a);
    }
}
