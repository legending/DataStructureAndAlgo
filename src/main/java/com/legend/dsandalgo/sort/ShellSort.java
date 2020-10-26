package com.legend.dsandalgo.sort;

/**
 * 希尔排序
 * 实质上是一种分组增量插入排序
 * <p>
 * （1）第一层循环，将数组分割为间隔为gap的分区，直到gap=1
 * （2）第二层循环，在某个gap下，依次从下标gap到arr.length-1，以gap为前进单位
 * （3）在数组下标不断往前走的过程中，不断寻找间隔为gap的数组成一个组，并排序
 *
 * 注意：gap/=2，gap必须是每次除2，否则会出问题
 *
 * 对有序序列插入有交换法和移动法，交换法效率较低，容易理解。移动法效率较高，不好理解。
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 */
public class ShellSort implements IArraySort {

    public static void main(String[] args) {
        int[] arr = {14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        new ShellSort().sort(arr);
    }

    //希尔排序 针对有序序列在插入时采用交换法
    public void sort(int[] arr) {
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++) {
                System.out.print("gap=" + gap + ",i=" + i + ":");
                int j = i;
                while (j - gap >= 0 && arr[j] < arr[j - gap]) {//在某个gap下，分在一组里面的数，在同一组下如何保证这些分组的数不重复？->组与组之间的数是可以重复的
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