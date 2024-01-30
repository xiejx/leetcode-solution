package com.example.problem28xx;

/**
 * Easy
 * CPU: 100% Memory: 13.63%
 * @author xiejx
 * @date 2024/1/30 20:07
 */
public class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int curPos = 0;
        int other = 0;
        for (char ch: moves.toCharArray()) {
            switch (ch) {
                case 'L':
                    curPos--;
                    break;
                case 'R':
                    curPos++;
                    break;
                default:
                    other++;
            }
        }
        return Math.abs(curPos) + other;
    }
}
