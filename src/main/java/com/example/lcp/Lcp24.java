package com.example.lcp;

import com.example.common.ListUtil;

import java.util.*;

/**
 * Hard
 * https://leetcode.cn/problems/5TxKeK/description/?envType=daily-question&envId=2024-02-01
 * CPU: 31.03% Memory: 17.24%
 * @author xiejx
 * @date 2024/2/1 17:52
 */
public class Lcp24 {

    public int[] numsGame(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] -= i;
        }
        int[] result = new int[n];
        long sum1 = nums[0];
        // 较小那部分之和
        long sum2 = 0;
        // 较大的，从小到大
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
        priorityQueue1.add(nums[0]);
        // 较小的，从大到小
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < n; i++) {
            if (priorityQueue1.size() > priorityQueue2.size()) {
                // 需要
                int a = priorityQueue1.peek();
                int c = nums[i];
                // a > b, 需要最大的放在priorityQueue1，其余的放在priorityQueue2
                if (c > a) {
                    priorityQueue2.add(a);
                    sum2 += a;
                    priorityQueue1.poll();
                    priorityQueue1.add(c);
                    sum1 = sum1 + c - a;
                } else {
                    priorityQueue2.add(c);
                    sum2 += c;
                }
                result[i] = (int) ((sum1 - sum2) % mod);
            } else {
                // 相同
                int b = priorityQueue2.peek();
                int c = nums[i];
                // a > b, 需要最小的放在priorityQueue2，其余的放在priorityQueue1
                if (c < b) {
                    priorityQueue1.add(priorityQueue2.poll());
                    priorityQueue2.add(c);
                    sum1 += b;
                    sum2 = sum2 - b + c;
                } else {
                    priorityQueue1.add(c);
                    sum1 += c;
                }
                result[i] = (int) ((sum1 - sum2 - priorityQueue1.peek()) % mod);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Lcp24 test = new Lcp24();
        // [0,0,0,5,6,7]
        System.out.println(ListUtil.fromArray(test.numsGame(new int[]{3,4,5,1,6,7})));
        // [0,0,0,0,0]
        System.out.println(ListUtil.fromArray(test.numsGame(new int[]{1,2,3,4,5})));
        // [0,1,2,3,3,3]
        System.out.println(ListUtil.fromArray(test.numsGame(new int[]{1,1,1,2,3,4})));
    }
}
