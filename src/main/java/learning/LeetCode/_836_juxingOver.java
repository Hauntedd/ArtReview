package main.java.learning.LeetCode;
/*
矩形重叠
矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
给出两个矩形，判断它们是否重叠并返回结果。
* */
public class _836_juxingOver {

    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {//这是给定的左下右上的坐标
        return !(rec1[2] <= rec2[0] || //1在2的左边
                 rec1[0] >= rec2[2] || //1在2的右边
                 rec1[1] >= rec2[3] || //1在2的上边
                 rec1[3] <= rec2[1]); //1在2的下边
        //相交为true,上述均为不相交的条件
    }
    public void isRectangleOverlap1MJ(int[] rec1, int[] rec2){//这里给的也是坐标的边长
        //首先判断矩形坐标的位置关系
        int x1 = Math.max(rec1[0],rec2[0]);//不管怎么相交左上坐标大的值都是相交矩形的右上角坐标
        int y1 = Math.min(rec1[1],rec2[1]);//不管怎么相交左上坐标值Y都是小值

        int x2 = Math.min(rec1[0] + rec1[2],rec2[0] + rec2[2]);//右下x坐标取小
        int y2 = Math.max(rec1[1] -rec1[3],rec2[1] - rec2[3]);
        int AJoin = 0;
        if(true){
            AJoin = (y1 - y2) * (x2 - x1);//到这里就有相交面积和相交坐标了
        }
    }
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2){//左上坐标和边长宽和高
        //如果只判断是否相交的话和上面类似
        return !(rec1[0] + rec1[2] <= rec2[0] ||//左
                rec1[0] >= rec2[0] + rec2[2] ||//右
                rec1[1] - rec1[3] >= rec2[1] ||//上
                rec1[1] <= rec2[1] - rec2[3]//下
                );
    }


}
