package main.java.learning.LeetCode;
/*
最大子序列和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
这提莫的是动态规划？
* */
public class subMaxHe_53 {
    public static void main(String[] args) {
        int[] test = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(test));
    }

    public int maxSubArray(int[] nums) {
        int pre = 0;//这个值的作用是当前一个子序列为负数时丢弃。
        int maxAns = nums[0];//这个值就是一直存储最大子序列的值(从前到后试)
        for (int x :nums) {
            pre = Math.max(pre + x,x);//这里决定ai单独成为一段，还是ai+f(i-1) 注：f(i-1)并不一定大于f(i-2),但若i-1是个小负数呢就必然会加入进去得到正结果
            maxAns = Math.max(maxAns,pre);//选择保留
        }
        return maxAns;
    }
    //标准动态规划的写法，好理解一点（空间复杂度要高一些）
    public static int maxSubArray2(int[] nums) {
        int[] res = new int[nums.length];//存放每个子段的最大值的表格
        int maxAns = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i==0)
                res[0] = nums[0];//最大子序列和第一段
            else
                res[i] = Math.max((res[i-1] + nums[i]), nums[i]);
        }
        for (int i = 0; i <res.length ; i++) {//查询结果里的最大值
            if(res[i]>maxAns)
                maxAns = res[i];
        }
        return maxAns;
    }
}
