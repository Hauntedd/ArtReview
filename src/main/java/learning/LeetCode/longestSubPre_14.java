package main.java.learning.LeetCode;
/*
最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
注：输入只包含小写字母
输入: ["flower","flow","flight"]
输出: "fl"
* */
public class longestSubPre_14 {
    public String longestCommonPrefix(String[] strs){
        if(strs.length ==0)
            return "";
        String ans = strs[0];//初始化为第一个字符串(这么初始化的原因是最大公共前缀必在每一个字符串里，比较完之后剪掉多余的就可以了)
        for (int i = 1; i < strs.length; i++) {
            int j = 0;//要用在最后的剪切上，所以定义在外面
            for (; j < strs[i].length(); j++) {
                if(ans.charAt(j) == strs[i].charAt(j)){
                    j++;
                }else{
                    break;
                }
                ans = ans.substring(0,j);//前闭后开
//                if("".equals(ans))
//                    return ans;//好像是多余的判断
            }
        }
        return ans;
    }
}
