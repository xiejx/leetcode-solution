package com.example.lcp;

import java.util.PriorityQueue;

/**
 * Medium
 * CPU: 40.00% Memory: 40.00%
 * https://leetcode.cn/problems/p0NxJO/description/?envType=daily-question&envId=2024-02-06
 */
public class Lcp30 {
    public int magicTower(int[] nums) {
        int result = 0;
        long cur = 0;
        long adjust = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums) {
            if (num < 0) {
                queue.add(num);
            }
            cur += num;
            while (cur < 0 && !queue.isEmpty()) {
                int temp = queue.poll();
                adjust += temp;
                result += 1;
                cur -= temp;
            }
            if (cur < 0) {
                return -1;
            }
        }
        if (cur + adjust < 0) {
            return -1;
        }
        return result;
    }
}
