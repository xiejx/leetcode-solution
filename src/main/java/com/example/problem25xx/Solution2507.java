package com.example.problem25xx;

/**
 * @author xiejx
 * @date 2024/1/11 20:54
 */
public class Solution2507 {
    public int smallestValue(int n) {
        int temp = n;
        do {
            n = temp;
            temp = calSumOfPrimes(n);
        } while (n != temp);
        return n;
    }

    private int calSumOfPrimes(int n) {
        int temp = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                temp += i;
            }
        }
        if (n >= 2) {
            temp += n;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution2507 test = new Solution2507();
        // 5
        System.out.println(test.smallestValue(15));
        // 3
        System.out.println(test.smallestValue(3));
        // 7
        System.out.println(test.smallestValue(100000));
    }
}
