package com.example.problem21xx;

/**
 * Medium
 * CPU:94.64% Memory:41.07%
 */
public class Solution2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        // 统计各个字符的数量
        int[] countChs = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            countChs[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int cur = 25;
        while (cur >= 0) {
            // 寻找当前大于0的字符
            while (cur >= 0 && countChs[cur] == 0) {
                cur--;
            }
            if (cur < 0) {
                break;
            }
            char ch1 = (char) (cur + 'a');
            int n1 = countChs[cur];
            // 小于等于限制，全部添加
            if (n1 <= repeatLimit) {
                for (int j = 0; j < n1; j++) {
                    sb.append(ch1);
                }
                countChs[cur] = 0;
                cur--;
                continue;
            }
            // 大于限制，添加repeatLimit个字符，之后添加下一个字符
            for (int j = 0; j < repeatLimit; j++) {
                sb.append(ch1);
            }
            int temp = cur - 1;
            // 寻找当前大于0的字符
            while (temp >= 0 && countChs[temp] == 0) {
                temp--;
            }
            if (temp < 0) {
                break;
            }
            char ch2 = (char) (temp + 'a');
            sb.append(ch2);
            countChs[cur] -= repeatLimit;
            countChs[temp] -= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2182 test = new Solution2182();
        System.out.println(test.repeatLimitedString("aababab", 2));
    }
}
