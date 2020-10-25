package com.legend.dsandalgo.sort;

import java.util.Arrays;

/**
 * 桶排序
 *
 * 因为它底层还要调用其他算法来对每个分区进行排序，所以本质上来说它不算是一种排序算法，顶多是一种用空间换时间的优化
 *
 * 1. 将待排序元素划分到不同的痛。先扫描一遍序列求出最大值 maxV 和最小值 minV ，设桶的个数为 k ，
 *    则把区间 [minV, maxV] 均匀划分成 k 个区间，每个区间就是一个桶。将序列中的元素分配到各自的桶。
 * 2. 对每个桶内的元素进行排序。可以选择任意一种排序算法（这里使用插入排序）。
 * 3. 将各个桶中的元素合并成一个大的有序序列。
 * 4. 假设数据是均匀分布的，则每个桶的元素平均个数为 n/k 。假设选择用快速排序对每个桶内的元素进行排序，
 *    那么每次排序的时间复杂度为 O(n/klog(n/k)) 。总的时间复杂度为 O(n)+O(k)*O(n/klog(n/k)) = O(n+nlog(n/k)) = O(n+nlogn-nlogk)。
 *    当 k 接近于 n 时，桶排序的时间复杂度就可以金斯认为是 O(n) 的。即桶越多，时间效率就越高，而桶越多，空间就越大。
 */
public class BucketSort implements IArraySort {

    private static final InsertSort insertSort = new InsertSort();

    @Override
    public void sort(int[] arr) throws Exception {
        bucketSort(arr, 5);
    }

    private int[] bucketSort(int[] arr, int bucketSize) throws Exception {
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            insertSort.sort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

}
