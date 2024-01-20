package com.example.contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution100164 {
    public int minimumArrayLength(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[0]) {
                count++;
            } else {
                break;
            }
        }
        if (count == n) {
            return (count + 1) / 2;
        }
        if (count <= 2) {
            return 1;
        }
        int temp = nums[0];
        for (int i = count; i < n; i++) {
            if (nums[i] % nums[0] != 0) {
                temp = Math.min(temp, nums[i] % nums[0]);
            }
        }
        if (temp < nums[0]) {
            return 1;
        }
        return (count + 1) / 2;
    }

    public static void main(String[] args) {
        Solution100164 test = new Solution100164();
        // 2
        System.out.println(test.minimumArrayLength(new int[]{3,4,3,4,1,1,1,2}));
        // 1
        System.out.println(test.minimumArrayLength(new int[]{1,4,3,1}));
        // 2
        System.out.println(test.minimumArrayLength(new int[]{5,5,5,10,5}));
        // 1
        System.out.println(test.minimumArrayLength(new int[]{2,3,4}));
    }
}
