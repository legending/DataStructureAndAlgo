package com.legend.dsandalgo.sort;

/*
 * 堆排序
 * (1)构造大根堆
 * (2)每一次取出堆顶元素，然后把最后的元素交换到堆顶，然后heapSize--，然后重新heapify，重复该步骤，直至取出所有的元素
 *
 * 最大的优点是：空间复杂度为O(1)
 *
 * 注意： int bigger = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1 : left;
 * */
public class HeapSort implements IArraySort {

    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        //build maxHeap
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        //排序
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);//交换减heapSize(heapify之前必做动作)
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) { //判断是否还有下一层，注意：要有left子节点来判断，而不是right（想一想就知道了）
            int bigger = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1 : left;
            //注意：要同时保证右节点存在才能做判断，而且上面语句中的三元判断必须是：arr[left+1] > arr[left]，因为这个同样符合没有右孩子的情况，如果换成是下面的就会出错
            //int bigger = left + 1 < heapSize && arr[left] > arr[left+1] ? left : left+1;//注意：要同时保证右节点存在才能做判断
            System.out.print(bigger + " ");
            bigger = arr[bigger] > arr[index] ? bigger : index;
            if (bigger == index) break;
            swap(arr, bigger, index);
            index = bigger;
            left = 2 * index + 1;//用于循环
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
