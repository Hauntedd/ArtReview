package main.java.learning.LeetCode;
/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票。
* */
public class _121_gupiao {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];//首先从前到后遍历一个最低值，如果找到新的最低值那么前面的最低值就没用了，因为后面的值减当前最低值必定赚的更多(但不一定大于最大值)
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;//记录所有最低值对应的赚钱值中的最大值
        }
        return maxprofit;
    }

    public int maxProfit2(int[] prices) {//122.你可以尽可能地完成更多的交易（多次买卖一支股票）,求最大利润。顺序遍历应该就可以（只求利润的话）

        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                maxprofit += prices[i] - prices[i-1];
            }
        }
        return maxprofit;
    }
}
