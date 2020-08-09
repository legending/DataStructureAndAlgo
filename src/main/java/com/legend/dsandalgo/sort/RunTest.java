package com.legend.dsandalgo.sort;

import java.util.Arrays;

public class RunTest {
    public static void main (String [] args) throws Exception {
        int [] arr = {123, 838, 2, 87, 834949, 6667, -12};
        int [] ret = new RadixSort().sort(arr);
        System.out.println(Arrays.toString(ret));
    }

}