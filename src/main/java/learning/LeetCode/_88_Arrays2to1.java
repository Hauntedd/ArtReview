package main.java.learning.LeetCode;


/*
合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
nums1[1,2,3,0,0,0],m=3,n=3，这种感觉。可以从后面开始截取

* */
public class _88_Arrays2to1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;//最后一位索引
        m--;n--;//均置为有效索引的最后一位
        while (n>=0){//因为要把第二个插入到第一个数组里，所以结束条件是n
            while (m >= 0 && nums1[m] >nums2[n]){
                int temp = nums1[i];//交换顺序,内部（直接赋值为0也可以，问题不大）
                nums1[i] = nums1[m];
                nums2[m] = temp;
                i--;m--;
            }
            //数组2更大
            nums1[i] = nums2[n];
            i--;n--;
        }
//        return nums1;
    }
}
