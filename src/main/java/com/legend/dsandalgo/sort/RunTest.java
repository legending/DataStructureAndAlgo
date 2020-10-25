package com.legend.dsandalgo.sort;

import java.util.Arrays;

public class RunTest {
    public static void main (String [] args) {
        int [] arr = {123, 838, 2, 87, 834949, 0, 6667, 11, 101, 555, 12, 87, 45};
        new ShellSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}