package com.example.problem24xx;

/**
 * @author xiejx
 * @date 2024/1/11 20:07
 */
public class Solution2401 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int result = 1;
        int start = 0;
        int countOne = nums[0];
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            // 如果存在相同位置都为1的情况，则减去最先的
            while ((countOne & cur) > 0) {
                countOne -= nums[start];
                start++;
            }
            countOne += cur;
            result = Math.max(i - start + 1, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2401 test = new Solution2401();
        // 3
        System.out.println(test.longestNiceSubarray(new int[]{1,3,8,48,10}));
        // 1
        System.out.println(test.longestNiceSubarray(new int[]{3,1,5,11,13}));
        // 8
        System.out.println(test.longestNiceSubarray(new int[]{1,2,4,8,16,32,64,128}));
    }
}
