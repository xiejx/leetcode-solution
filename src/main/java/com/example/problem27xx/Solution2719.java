package com.example.problem27xx;

/**
 * Hard
 * CPU: 5.81% Memory: 5.81%
 * count0使用数位DP的方式
 * CPU: 98.46% Memory: 55.38%
 *
 *
 * @author xiejx
 * @date 2024/1/16 9:37
 */
public class Solution2719 {
    private static final int MOD = 1000000007;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int n2 = num2.length();
        long[][][] dp = new long[max_sum + 1][n2][10];
        for (int i = 0; i <= 9 && i <= max_sum; i++) {
            dp[i][0][i] = 1;
        }
        for (int i = 0; i <= max_sum; i++) {
            for (int j = 1; j < n2; j++) {
                for (int k = 0; k <= 9; k++) {
                    dp[i][j][k] = calSumOfJ(dp, i - k, j - 1);
                }
            }
        }
        // 不包括num1
        long sum1 = calSumWithLimit(dp, num1, min_sum, max_sum);
        // 不包括num2
        long sum2 = calSumWithLimit(dp, num2, min_sum, max_sum);
        int temp = 0;
        for (char ch: num2.toCharArray()) {
            temp += (ch - '0');
        }
        if (temp >= min_sum && temp <= max_sum) {
            sum2 += 1;
        }
        return (int) ((sum2 - sum1 + MOD) % MOD);
    }

    private long calSumOfJ(long[][][] dp, int i, int j) {
        if (i < 0) {
            return 0;
        }
        long sum = 0;
        for (int k = 0; k <= 9; k++) {
            sum = (sum + dp[i][j][k]) % MOD;
        }

        return sum;
    }

    private long calSumWithLimit(long[][][] dp, String limit, int minSum, int maxSum) {
        int n = limit.length();
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 当前字符
            int temp = limit.charAt(n - 1 - i) - '0';
            for (int j = 0; j < temp; j++) {
                for (int k = maxSum; k >= minSum; k--) {
                    if (k < 0) {
                        break;
                    }
                    sum = (sum + dp[k][i][j]) % MOD;
                }
            }
            minSum -= temp;
            maxSum -= temp;
        }
        return sum;
    }

    public int count0(String num1, String num2, int min_sum, int max_sum) {
        int n1 = num1.length();
        int n2 = num2.length();
        char[] numChs1 = num1.toCharArray();
        char[] numChs2 = num2.toCharArray();

        int[][] dp = new int[max_sum + 1][n2];
        for (int i = 0; i <= max_sum; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }
        int b = func(0, n2, min_sum, max_sum, true, numChs2, 0, dp);
        int a = func(0, n1, min_sum, max_sum, true, numChs1, 0, dp);
        int temp = 0;
        for (char ch: numChs1) {
            temp += ch - '0';
        }
        temp = temp >= min_sum && temp <= max_sum ? 1 : 0;
        return (b - a + temp + MOD) % MOD;
    }

    private int func(int i, int n, int minSum, int maxSum, boolean limit, char[] maxNum, int preSum, int[][] cache) {
        if (i == n) {
            return preSum >= minSum && preSum <= maxSum ? 1 : 0;
        }
        if (preSum > maxSum) {
            return 0;
        }
        if (cache[preSum][n - i - 1] != -1 && !limit) {
            return cache[preSum][n - i - 1];
        }
        long result = 0;
        int upper = limit ? maxNum[i] - '0' : 9;
        for (int k = 0; k <= upper; k++) {
            result = (result + func(i + 1, n, minSum, maxSum, limit && k == upper, maxNum, preSum + k, cache)) % MOD;
        }
        if (!limit) {
            cache[preSum][n - i - 1] = (int) result;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution2719 test = new Solution2719();
        long start = System.currentTimeMillis();
        // 10
        System.out.println(test.count("1", "11", 1, 8));
        // 11
        System.out.println(test.count("1", "12", 1, 8));
        // 5
        System.out.println(test.count("1", "5", 1, 5));
        // 99
        System.out.println(test.count("1", "99", 1, 18));
        // 490000
        System.out.println(test.count("1", "10000000000000000000000", 1, 400));
        // 0
        System.out.println(test.count("8990", "9927", 1, 3));
        // 972251498
        System.out.println(test.count("4859473643", "30159981595", 58, 59));
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + " 毫秒");

        start = System.currentTimeMillis();
        // 10
        System.out.println(test.count0("1", "11", 1, 8));
        // 11
        System.out.println(test.count0("1", "12", 1, 8));
        // 5
        System.out.println(test.count0("1", "5", 1, 5));
        // 99
        System.out.println(test.count0("1", "99", 1, 18));
        // 490000
        System.out.println(test.count0("1", "10000000000000000000000", 1, 400));
        // 0
        System.out.println(test.count0("8990", "9927", 1, 3));
        // 972251498
        System.out.println(test.count0("4859473643", "30159981595", 58, 59));
        end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + " 毫秒");
    }
}
