package main.java.learning;

import java.util.Scanner;

public class Cow {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                if(!(n>0&&n<55)){
                    return;
                }else{
                    int num =getNum(n) ;
                    System.out.println(num);
                }
            }
        }
        public static int getNum(int n){//递归
            int num;
            if(n==1||n==2||n==3||n==4){
                return n;
            }else{
                num = getNum(n - 1) + getNum(n - 3);
            }
            return num;
        }
}
