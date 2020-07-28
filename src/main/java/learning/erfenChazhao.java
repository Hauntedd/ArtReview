package main.java.learning;

import java.util.ArrayList;
import java.util.Arrays;

public class erfenChazhao {
    public static boolean erfenFind(int[] nums, int target){
        Arrays.sort(nums);//升序排序，查找的前置工作
        int low = 0,height = nums.length-1;
        while (low <= height){
            int mid = (low + height)/2;
            if(target > nums[mid]){
                low = mid +1;
            }else if(target < nums[mid]){
                height = mid -1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {1,3,50,16,7,9,23,32,19,36};
        System.out.println(erfenFind(test, 23));

    }
}
