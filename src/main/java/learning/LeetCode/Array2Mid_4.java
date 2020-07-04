package main.java.learning.LeetCode;
/*
寻找两个有序数组的中位数
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
* */
public class Array2Mid_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){//时间复杂度是O(M+N)
        int index1 = 0;
        int index2 = 0;
        int index0 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] data = new int[length1 + length2];

        while (index1 <length1 || index2<length2){//合并成一个有序数组

            if(index1 <length1 && index2 ==length2){//补齐数组，完成后可以直接跳出循环，也可以不跳
                while (index1<length1){
                    data[index0] = nums1[index1];
                    index1++;
                    index0++;
                }
                break;
            }
            if(index1 ==length1 && index2 <length2){
                while (index2<length2){
                    data[index0] = nums2[index2];
                    index2++;
                    index0++;
                }
//                break;
            }
            //正常的数组合并操作
            if(nums1[index1]<nums2[index2]){
                data[index0] = nums1[index1];
                index0++;
                index1++;
            }else{
                data[index0] = nums2[index2];
                index0++;
                index2++;
            }
        }
        if((length1 + length2)%2 == 1){
            return data[(length1 + length2) / 2] * 1.0;//*1.0是为了转换为double
        }else{
            return (data[(length1 + length2) / 2] + data[(length1 + length2) / 2 - 1]) / 2.0;
        }
    }

}
