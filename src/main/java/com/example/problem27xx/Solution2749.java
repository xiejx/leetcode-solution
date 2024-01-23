package com.example.problem27xx;

/**
 * Medium
 * CPU: 67.65% Memory: 11.76%
 * @author xiejx
 * @date 2024/1/22 17:52
 */
public class Solution2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        long n1 = num1;
        long n2 = num2;
        if (n2 == 0) {
            if (n1 < 0) {
                return -1;
            } else {
                return Long.bitCount(n1);
            }
        } else if (n2 > 0) {
            int count = 0;
            while (n1 > 0) {
                n1 -= n2;
                count += 1;
                int temp = Long.bitCount(n1);
                if (count <= n1 && count - temp >= 0 && temp != 0) {
                    return count;
                }
            }
            return -1;
        } else {
            // num2 < 0
            int count = 0;
            while (true) {
                n1 -= n2;
                count++;
                int temp = Long.bitCount(n1);
                if (count - temp >= 0) {
                    return count;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution2749 test = new Solution2749();
        // 3
        System.out.println(test.makeTheIntegerZero(3, -2));
        // -1
        System.out.println(test.makeTheIntegerZero(5,7));
        // 19
        System.out.println(test.makeTheIntegerZero(1000000000, 1));
        // 16
        System.out.println(test.makeTheIntegerZero(1000000000, -1));
        // -1
        System.out.println(test.makeTheIntegerZero(110, 55));
        // 2
        System.out.println(test.makeTheIntegerZero(3, -3));
        // -1
        System.out.println(test.makeTheIntegerZero(85, 42));
    }
}

// 优雅的解法
/*
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long k = 1; k <= num1 - num2 * k; k++)
            if (k >= Long.bitCount(num1 - num2 * k))
                return (int) k;
        return -1;
    }
}
*/
