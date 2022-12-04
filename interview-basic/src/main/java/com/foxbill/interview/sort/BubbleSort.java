package com.foxbill.interview.sort;

import java.util.Arrays;

/**
 * 冒泡
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr ={5,9,7,4,1,3,2,8};
        int[] arr ={5,2,7,4,1,3,8,9};
//        int[] arr ={1,2,3,4,5,7,8,9};

//        bubble(arr);
        bubble_v2(arr);
    }

    /**
     * 最优化版本
     * @param arr
     */
    private static void bubble_v2(int[] arr) {
        int n = arr.length - 1; //设置比较次数
        //for (int j = 0; j < arr.length - 1; j++) {
        while(true){
            int last = 0; //表示最后一次交换索引位置
            for (int i = 0; i < n; i++) { //只需比较 未排好序的元素
                if (arr[i] > arr[i + 1]){
                    swap(arr,i,i+1);
                    last = i;//记录最后一次交换的位置，该位置之后已排好序。
                }
            }
            n = last;//重置比较次数
            System.out.println("第n轮冒泡"+ Arrays.toString(arr));
            if (n == 0){
                break;
            }
        }

    }

    /**
     * 冒泡排序 第一版优化
     * @param arr
     */
    private static void bubble(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            //一轮冒泡
            boolean swapped = false; //是否发生了交换
            for (int i = 0; i < arr.length - 1 - j; i++) { // 优化1： -j：目的是减少比较次数
                System.out.println("比较次数"+i);
                if (arr[i] > arr[i + 1]){
                    swap(arr,i,i+1);
                    swapped = true;
                }
            }
            System.out.println("第"+ j + "轮冒泡"+ Arrays.toString(arr));
            if (!swapped){  // 优化2： 没有发生交换，就退出冒泡，目的是减少冒泡次数
                break;
            }
        }

    }


    public static void swap(int[] a,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
