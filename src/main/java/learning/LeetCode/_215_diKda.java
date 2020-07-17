package main.java.learning.LeetCode;

import java.util.Arrays;

/*
数组中第K大的元素（包含重复的，就很简单）
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
* */
public class _215_diKda {
    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);//java最简单的做法
//        return nums[-k];
        quickSorted(nums,0,nums.length -1);
        return nums[nums.length-k];
    }

    public void quickSorted(int[] nums, int left, int right){//快速排序
        if(left>right)
            return;
        int base = nums[left];//存放中数
        int i = left,j=right;
        while (i!=j){
            while(nums[j]>=base || i<j){//j先操作，所以一定是j靠向i，因为在最后一次循环之前一定会调整为“i小大j”的顺序
                j--;
            }
            while (nums[i]<=base || i<j){
                i++;
            }

            if (i<j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;//大小对换
            }
        }
        nums[left] = nums[i];
        nums[i] = base;
        quickSorted(nums,left,i-1);
        quickSorted(nums,i+1,right);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        System.out.println(test[test.length-3]);
    }
}
