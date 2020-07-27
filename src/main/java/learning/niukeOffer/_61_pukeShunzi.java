package main.java.learning.niukeOffer;

import java.util.Arrays;

/*
* 剑指 Offer 61. 扑克牌中的顺子
* 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
* */
public class _61_pukeShunzi {
    public boolean isStraight(int[] nums) {//nums是已经抽取出来的五张牌
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if(nums[i] == 0)
                joker++;//统计大小王的数量
            else if(nums[i] == nums[i+1]){
                return false;//重复的牌非0，肯定不是顺子
            }
        }
        return nums[4] - nums[joker]<5;//正常牌的最大值减最小值,只要小于5就可以用0补成顺子
    }
}
