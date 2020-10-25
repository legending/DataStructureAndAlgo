package com.legend.dsandalgo.sort;

/**
 * 基数排序
 * 考虑负数的情况还可以参考： https://code.i-harness.com/zh-CN/q/e98fa9
 * 基数排序是桶排序的一种（也是借助容器）
 * 但是对数据本身有要求：只适用于参十进制，且一般只用于非负整数
 * 桶排序的缺陷：只要数据状况发生改变就要改写代码
 */

public class RadixSort implements IArraySort {

    @Override
    public void sort(int[] arr) {
        int maxBit = maxBit(arr);
        System.out.println("maxBit: " + maxBit);
        radixSort(arr, maxBit);
    }

    private void radixSort(int[] arr, int maxBit) {
        final int radix = 10;
        for (int d = 1; d <= maxBit; d++) {
            //构造第n位数计数器
            int[] count = new int[radix];
            for (int i = 0; i < arr.length; i++) {
                int val = getDigit(arr[i], d);
                count[val]++;
            }
            //将count转为小于或等于digit个数的数组
            for (int i = 1; i < count.length; i++) {
                count[i] = count[i] + count[i - 1];
            }
            //把数组按照d位上元素排序，并把结果存储在help中
            int[] help = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = getDigit(arr[i], d);
                help[count[digit] - 1] = arr[i];//
                count[digit]--;
            }
            for (int i = 0; i < help.length; i++) {
                arr[i] = help[i];
            }
        }
    }

    //获取数组元素的最大位数
    private int maxBit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) max = Math.max(max, arr[i]);
        int maxBit = 1;
        int q = max / 10;
        while (q != 0) {
            maxBit++;
            q /= 10;
        }
        return maxBit;
    }

    private int getDigit(int val, int d) {//这个函数稍微记一下，且Math.pow的结果要强转为int
        return ((val / (int) Math.pow(10, d - 1)) % 10);
    }
}
