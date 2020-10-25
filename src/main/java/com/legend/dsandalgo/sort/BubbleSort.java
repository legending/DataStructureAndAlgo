package com.legend.dsandalgo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * （1）每一轮通过比较arr[j]与arr[j-1]的大小，不符合从左小右大就交换，n那么第n轮排序能找到第n大的值（冒泡的提现）
 * （2）重复以上步骤（n-1）轮以上步骤即可得出有序结果
 */
public class BubbleSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }
}
