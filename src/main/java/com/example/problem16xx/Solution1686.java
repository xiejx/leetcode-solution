package com.example.problem16xx;

import java.util.Arrays;

/**
 * Medium
 * 由于aliceValues和bobValues的取值范围为1~100，因此排序使用计数排序会更快
 * 除此之外 ，values也可以令values为一维数组，values[i]=i，排序时根据aliceValues[i]+bobValues[i]
 * CPU: 24.46% Memory: 77.17%
 * @author xiejx
 * @date 2024/2/2 9:31
 */
public class Solution1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] values = new int[n][2];
        for (int i = 0; i < n; i++) {
            values[i][0] = aliceValues[i] + bobValues[i];
            values[i][1] = aliceValues[i];
        }
        Arrays.sort(values, (arr1, arr2) -> arr1[0] == arr2[0] ? arr2[1] - arr1[1] : arr2[0] - arr1[0]);
        int sumOfA = 0;
        int sumOfB = 0;
        for (int i = 0; i < n; i+=2) {
            sumOfA += values[i][1];
        }
        for (int i = 1; i < n; i += 2) {
            sumOfB += values[i][0] - values[i][1];
        }
        if (sumOfA == sumOfB) {
            return 0;
        } else if (sumOfA > sumOfB) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution1686 test = new Solution1686();
        // 1
        System.out.println(test.stoneGameVI(new int[]{1,3}, new int[]{2,1}));
        // 0
        System.out.println(test.stoneGameVI(new int[]{1,2}, new int[]{3,1}));
        // -1
        System.out.println(test.stoneGameVI(new int[]{2,4,3}, new int[]{1,6,7}));
        // 1
        System.out.println(test.stoneGameVI(new int[]{2,1,6,5,3,7}, new int[]{1,3,7,2,8,4}));
    }
}
