package com.legend.dsandalgo.sort;

/**
 * 快速排序
 * 随机快排的时间复杂度分析
 * 1）通过分析知道，划分值越靠近中间，性能越好;越靠近两边，性能越差
 * 2) 随机选一个数进行划分的目的就是让好情况和差情况都变成概率事件
 * 3）把每一种情况都列出来，会有每种情况下的时间复杂度，但概率都是1/N
 * 4) 那么所有情况都考虑，时间复杂度就是这种概率模型下的长期期望!
 * 时间复杂度O(N*logN)，额外空间复杂度O(logN)都是这么来的。
 */
public class QuickSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int L, int R) {
        if (L >= R) return;
        int M = partition(arr, L, R);
        quickSort(arr, L, M - 1);
        quickSort(arr, M + 1, R);
    }

    private int partition(int[] arr, int L, int R) {
        //默认基准值为arr[R]
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
