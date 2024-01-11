package com.example.problem25xx;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xiejx
 * @date 2024/1/11 21:05
 */
public class Solution2521 {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            for (int j = 2; j * j <= temp; j++) {
                while (temp % j == 0) {
                    temp /= j;
                    set.add(j);
                }
            }
            if (temp >= 2) {
                set.add(temp);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution2521 test = new Solution2521();
        System.out.println(test.distinctPrimeFactors(new int[]{100}));
    }
}
