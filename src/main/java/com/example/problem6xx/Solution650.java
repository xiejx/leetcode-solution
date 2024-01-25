package com.example.problem6xx;

/**
 * Medium
 * CPU: 100% Memory: 59.01%
 * @author xiejx
 * @date 2024/1/25 11:10
 */
public class Solution650 {
    public int minSteps(int n) {
        int result = 0;
        int i;
        for (i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                result += i;
                n /= i;
            }
        }
        if (n != 1) {
            result += n;
        }
        return result;
    }
}
