package com.example.problem9xx;

/**
 * Medium
 * CPU: 100% Memory: 32.14%
 * @author xiejx
 * @date 2024/1/25 10:58
 */
public class Solution991 {
    public int brokenCalc(int startValue, int target) {
        int result = 0;
        // 目标值小于等于起始值，直接返回差值
        if (target <= startValue) {
            return startValue - target;
        }
        // 从目标值往前推
        while (target > startValue) {
            if ((target & 1) == 0) {
                target >>= 1;
            } else {
                target += 1;
            }
            result += 1;
        }
        return result + startValue - target;
    }
}
