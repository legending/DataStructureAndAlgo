package com.legend.dsandalgo.sort;

import java.util.Arrays;

public class RunTest {

    public static void main (String [] args) throws Exception {
        //利用对数器证明排序方法的正确性
        int tryTimes = 1000000;
        boolean isAllPassed = true;
        for (int i = 0; i < tryTimes; i++) {
            int maxSize = 200;
            int maxValue = 1234567;
            int [] arr1 = generateRandomArr(maxSize, maxValue);
            int [] arr2 = copyArray(arr1);
            //System.out.println("arr1 before: " + Arrays.toString(arr1));
            //System.out.println("arr2 before: " + Arrays.toString(arr2));
            //System.out.println("before：arr1 is " + (isEqual(arr1,arr2) ? "" : "not") + " equal to arr2");
            new QuickSort().sort(arr1);
            rightSort(arr2);
            //System.out.println("arr1 after: " + Arrays.toString(arr1));
            //System.out.println("arr2 after: " + Arrays.toString(arr2));
            boolean isEqual = isEqual(arr1, arr2);
            //System.out.println("final: arr1 is " + (isEqual? "" : "not") + " equal to arr2");
            if (!isEqual) {
                System.out.println("Not equal happened!!!!!!!!!!!!!!");
                isAllPassed = false;
                break;
            }
        }
        if (isAllPassed) System.out.println("All passed");
    }

    //对数器
    public static void rightSort(int [] arr) {
        Arrays.sort(arr);
    }

    public static boolean isEqual(int[] a, int[] b) {
        if (a == null && b == null) return true;
        if (a == null && b != null || a != null && b == null || a.length != b.length) return false;
        boolean isEqual = true;
        for (int i = 0; i < a.length; i++) {
            if(a[i] != b[i]) isEqual=false;
        }
        return isEqual;
    }

    public static int[] generateRandomArr(int maxSize, int maxValue) {
        int len = (int) (Math.random()*(maxSize+1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random()*(maxValue+1)) - (int)(Math.random()*maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] retArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            retArr[i] = arr[i];
        }
        return retArr;
    }
}