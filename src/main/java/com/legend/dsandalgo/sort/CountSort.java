package com.legend.dsandalgo.sort;

/**
 * 计数排序
 * 计数排序是桶排序的一种体现
 * 但是对数据本身有要求：只适用于参与排序数的范围有限，且不是太大的情况
 * 比如说整数，一般会要求是非负整数（因为要拿数组元素做下标）
 */
public class CountSort implements IArraySort {

    @Override
    public void sort(int[] arr) {
        int max = getMax(arr);
        countSort(arr, max);
    }

    private void countSort(int[] arr, int max) {
        int bucketLen = max + 1;
        int[] bucket = new int[bucketLen];
        for (int i = 0; i < arr.length; i++) bucket[arr[i]]++;
        int index = 0;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) max = Math.max(arr[i], max);
        return max;
    }

}
