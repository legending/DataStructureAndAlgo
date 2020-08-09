package com.legend.dsandalgo;

import java.util.Arrays;

public class GetDigitArrFromInt {
    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.toString(getDigit(13464375)));
    }

    private static int[] getDigit(int value) {
        int len = 0;
        if (value == 0) {
            len = 1;
        }
        for (int tmp = value; tmp != 0; tmp /= 10) {
            len++;
        }

        int[] digitArr = new int[len];
        for (int i = 1; i <= len; i++) {
            digitArr[len - i] = value % 10;
            value /= 10;
        }
        return digitArr;
    }
}
