package main.java.learning;

public class shuzi2hanzi {
    public static void shuzi2hanzi(String nums){
//        String dx = "零一二三四五六七八九";
        char[] dxArray = "零一二三四五六七八九".toCharArray();
//        char[] numsArray = nums.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length(); i++) {
            String temp = String.valueOf(nums.charAt(i));//获取单个字符
            int tempFlag = Integer.parseInt(temp);
            String num = String.valueOf(dxArray[tempFlag]);//两种取的方法，都可以
            sb.append(num);
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args){
        shuzi2hanzi("4561237890");
    }
}
