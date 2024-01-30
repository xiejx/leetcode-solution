package com.example.problem6xx;

/**
 * Easy
 * CPU: 98.10% Memory: 6.97%
 * @author xiejx
 * @date 2024/1/30 19:56
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        for (char ch: moves.toCharArray()) {
            switch (ch) {
                case 'U':
                    col -= 1;
                    break;
                case 'D':
                    col += 1;
                    break;
                case 'L':
                    row -= 1;
                    break;
                case 'R':
                    row += 1;
                    break;
                default:
                    break;
            }
        }
        return row == 0 && col == 0;
    }
}
