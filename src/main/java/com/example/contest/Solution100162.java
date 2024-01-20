package com.example.contest;

import java.util.List;

/**
 * 第380场周赛
 */
public class Solution100162 {
    public int maxFrequencyElements(int[] nums) {
        int[] bucket = new int[101];
        for (int num: nums) {
            bucket[num] += 1;
        }
        int maxFreq = 0;
        for (int num: bucket) {
            maxFreq = Math.max(num, maxFreq);
        }
        int result = 0;
        for (int num: bucket) {
            if (num == maxFreq) {
                result += num;
            }
        }
        return result;
    }
}
