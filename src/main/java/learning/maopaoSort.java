package main.java.learning;

public class maopaoSort {
    public static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr.length -1-i ; j++) {//-1是避免溢出，-i是避免重复
                //两两比较
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
