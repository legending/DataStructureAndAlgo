package com.legend.dsandalgo;

/*
* partition算法的应用
* （1）荷兰国旗
* （2）寻找第K大值
* */

import java.util.Arrays;

public class PartitionAlgos {
    public static void main(String[] args) {
        int [] arr = {11, 6, 8, 10, 7, 9, 1, 7};

        /*int ret = partition(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach((x) -> System.out.print(x + ","));
        System.out.println("lessEqual: " + ret + ",arr[" + ret + "]=" + arr[ret]);*/

        /*int [] ret = netherlandsFlag(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach((x) -> System.out.print(x + ","));
        System.out.println("less:" + ret[0] + ",more:" + ret[1]);*/

        int ret = findK(arr, 0, arr.length-1, 4);
        System.out.println(ret);
    }

    public static void swap(int [] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //分区算法
    public static int partition(int [] arr, int L, int R) {
        if(L>R) return -1;
        if(L == R) return L;
        int lessEqual = L-1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);//循环结束后，来到最后一个值，因为它是分界值，所以要把它移动到中间位置
        //以下步骤与上面步骤等价，为什么？因为最后一个作为分界值，一定会进入swap逻辑，所以是一样的
        /*while(index <= R) {
            if(arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);//这一步很关键，保证了小于分界值一定在lessEqual左边
            }
            index++;
        }*/
        return lessEqual;
    }

    //拓展荷兰国旗问题：给定一个整数数组，给定一个值K(这里先暂定为arr[R])，这个值在原数组中一定存在，
    //要求把数组中小于K的元素放到数组的左边，大于K的元素放到数组的右边，等于K的元素放到数组的中间，
    //最终返回一个整数数组，其中只有两个值，分别是等于K的数组部分的左右两个下标值
    public static int [] netherlandsFlag(int [] arr, int L, int R) {
        if(L>R) return new int[]{-1, -1};
        if(L == R) return new int[]{L, L};
        int less = L - 1; // < 区 右边界
        int more = R;     // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);//把分界值移动到右边分界点，其实你要愿意也可以移动到左分界值处，结果是一样的
        return new int[] { less + 1, more };//因为less在while循环最后的值是当arr[index]<arr[R]的下标，less+1才是分界值的下标，而more的位置是直接交换得到的所以不用加
    }

    //求第K大的值
    //https://www.jianshu.com/p/33ee33ce8699
    public static int findK(int[] arr, int left, int right, int k) {
        int i = partition(arr, left, right);
        if (i == k - 1) {
            return arr[k - 1];
        } else if (i > k - 1) {
            return findK(arr, left, i - 1, k);
        } else if (i < k - 1) {
            return findK(arr, i + 1, right, k);
        }
        return 0;
    }

}
