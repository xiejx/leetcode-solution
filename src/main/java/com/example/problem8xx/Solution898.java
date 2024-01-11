package com.example.problem8xx;

import com.example.common.ArrayUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiejx
 * @date 2024/1/10 19:27
 */
public class Solution898 {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;

        set.add(arr[0]);
        int temp = 0;
        for (int i = 1; i < n; i++) {
            set.add(arr[i]);
            for (int j = i - 1; j >= temp; j--) {
                if (((arr[j] | arr[i]) == arr[j])) {
                    break;
                }
                arr[j] |= arr[i];
                set.add(arr[j]);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        Solution898 test = new Solution898();
        // 1
        System.out.println(test.subarrayBitwiseORs(new int[]{0}));
        // 3
        System.out.println(test.subarrayBitwiseORs(new int[]{1,1,2}));
        // 6
        System.out.println(test.subarrayBitwiseORs(new int[]{1,2,4}));
        int[] arr = ArrayUtil.geneRandomArray(50000, 0, 1000000000, 0);
        int[] arr1 = ArrayUtil.geneSeqArray(50000, 0);
        long start = System.currentTimeMillis();
        // 129099
        System.out.println(test.subarrayBitwiseORs(arr));
        // 50003
        System.out.println(test.subarrayBitwiseORs(arr1));
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + " 毫秒");
    }
}
