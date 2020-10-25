package com.legend.dsandalgo.sort;

import java.util.Arrays;

/**
 * 插入排序
 * （1）以只有一个元素的有序数组为基础，每一轮将第i个数与前面（i-1）个数做对比从而找到合适的位置并插入，然后形成新的有序数组
 * （2）重复（n-1）轮以上步骤，即可得到有序结果
 */
public class InsertSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 从已经排序的序列最右边的开始比较，遇到比要插入的值大的元素则把该元素后移（腾出位置），直到找到比其小的数停止
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j-1]) {
                    int tmp =arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                    j--;
                } else {
                    break;
                }
            }
        }
    }
}
