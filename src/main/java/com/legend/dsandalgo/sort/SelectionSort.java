package com.legend.dsandalgo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * （1）每一轮默认第一个值为最小值，并记录其下标为min，然后不断找出比当前最小值还小的元素，并把对应的下标赋给min，最后判断当前arr[i]与arr[min]的大小，从而决定是否交换位置
 * （2）重复（n-1）轮以上循环，最终找到最小值
 */
public class SelectionSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {//使用min下标是精髓（实际上就是反复拿目前找到的最小值与后面的值对比）
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 判断找到的最小值是否需要交换位置
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }
}
