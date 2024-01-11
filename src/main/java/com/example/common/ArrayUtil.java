package com.example.common;

import java.util.Random;

/**
 * @author xiejx
 * @date 2024/1/10 19:51
 */
public class ArrayUtil {
    public static int[] geneRandomArray(int n, int start, int end, int seed) {
        Random random = new Random(seed);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = start + random.nextInt(end - start);
        }
        return result;
    }

    public static int[] geneSeqArray(int n, int init) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + init;
        }
        return res;
    }
}
