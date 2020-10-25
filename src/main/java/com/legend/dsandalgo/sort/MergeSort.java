package com.legend.dsandalgo.sort;

/**
 * 归并排序
 * 写递归的思路是把大规模的计算分解为小规模的计算，直到可以直接计算，是从外到内一层层细分，而计算时则是从内往外一层层计算
 * 注意
 * （1）这里是有等于号的：help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
 * （2）遍历赋值是用help来遍历而不是arr：for (int i=0; i < help.length; i++) arr[L+i] = help[i];
 * （3）考虑更周全一些应该加上arr=null或只有一个元素的情况
 * */

public class MergeSort implements IArraySort {

    @Override
    public  void sort (int [] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    public static void process (int [] arr, int L, int R) {
        if (L == R) return;
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    public static void merge (int [] arr, int L, int M, int R) {
        if (L == R) return;
        int p1 = L, p2 = M + 1;
        int [] help = new int[R - L + 1];
        int index = 0;
        while (p1 <= M && p2 <= R) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++]; //条件是arr[p1] <= arr[p2]
        }
        while (p1 <= M) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i=0; i < help.length; i++) arr[L+i] = help[i]; //注意这里是用help来做遍历，且下标是（L+i）
    }

}
