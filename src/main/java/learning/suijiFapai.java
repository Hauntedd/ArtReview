package main.java.learning;

import java.util.Random;

/*
随机发牌（N张扑克），直接洗牌的话问题应该也不大。如果真的只让发17张牌就随机种子54-i,然后倒序输出后十七张牌
* */
public class suijiFapai {
    public static void shuffle(int[] cards, int n){
        if(cards == null){
            return;
        }
//        Random rand = new Random();//随机种子
        int value;
        //
        for (int i = 0; i < n; i++) {
            value = new Random().nextInt(54)%54; //((int) Math.random())%n;
            int temp = cards[i];
            cards[i] = cards[value];
            cards[value] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(cards[i] +" ");
        }
//        System.out.println(cards.toString());
    }

    public static void main(String[] args) {
        int[] cards = new int[54];
        for (int i = 0; i < 54; i++) {
            cards[i] = i;
        }
        shuffle(cards,54);
    }
}
