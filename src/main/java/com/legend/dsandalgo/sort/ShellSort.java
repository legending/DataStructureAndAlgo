package com.legend.dsandalgo.sort;

/**
 * 希尔排序
 *  实质上是一种分组插入方法
 *  步骤
 * （1）第一层循环，将数组分割为间隔为gap的分区，直到gap=1
 * （2）每个固定的gap，依次次从下标gap到arr.length-1，以gap为前进单位
 * （3）判断是否需要交换
 *
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 */
public class ShellSort implements IArraySort {

    //希尔排序 针对有序序列在插入时采用交换法
    public void sort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 3; gap > 0; gap /= 3) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {
                    //插入排序采用交换法
                    swap(arr, j, j - gap);
                    j -= gap;
                }
            }
        }
    }

    //希尔排序 针对有序序列在插入时采用移动法
    public void sort1(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动法
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}