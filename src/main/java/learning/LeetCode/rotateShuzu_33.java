package main.java.learning.LeetCode;

import javax.sound.midi.MidiEvent;

public class rotateShuzu_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index = findMaxIndex(nums);//最大值索引
        int left,right;
        if(nums[index]<target)
            return -1;
        else if(nums[index] == target)//||nums[0] == target||nums[nums.length-1] == target)
            return index;
        else if(nums[0] < target){//已知小于最大值
            left = 0;right=index -1;
        }else{
            left = index + 1;right = nums.length -1;
        }
        while (left <right){
            int middle = (left + right) / 2;
            if(nums[middle]<target)
                left = middle +1;
            else if(nums[middle]>target)
                right = middle -1;
            else
                return middle;
        }//如果能跳出循环，那说明没找到
        if(nums[left]==target)
            return left;
        else
            return -1;
    }

    public int findMaxIndex(int[] nums){//这个方法是找到旋转数组中的最小/大值
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) {
                // middle可能是最小值
                right = middle;
            } else {
                // middle肯定不是最小值
                left = middle + 1;
            }
        }
        return left - 1;//最小值的索引减1就是最大值的索引
    }
    public void caonima (){}
}
