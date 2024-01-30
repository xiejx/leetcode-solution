package com.example.problem21xx;

/**
 * Medium
 * CPU: 99.27% Memory: 81.45%
 * @author xiejx
 * @date 2024/1/30 19:51
 */
public class Solution2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] result = new int[m];
        char[] chs = s.toCharArray();
        for (int i = 0; i < m; i++) {
            int curX = startPos[0];
            int curY = startPos[1];
            boolean flag = true;
            for (int j = i; j < m; j++) {
                switch (chs[j]) {
                    case 'L':
                        curY--;
                        break;
                    case 'R':
                        curY++;
                        break;
                    case 'U':
                        curX--;
                        break;
                    case 'D':
                        curX++;
                        break;
                }
                if (curX < 0 || curX >= n || curY < 0 || curY >= n) {
                    result[i] = j - i;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[i] = m - i;
            }
        }
        return result;
    }
}
