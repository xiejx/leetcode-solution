package com.example.problem27xx;

import java.util.HashMap;
import java.util.Map;

/**
 * Medium
 * CPU: 65.36% Memory: 47.71%
 */
public class Solution2767 {
    private String[] validString = new String[]{"1", "101", "11001", "1111101", "1001110001", "110000110101", "11110100001001"};
    private Map<Integer, Integer> map;
    public int minimumBeautifulSubstrings(String s) {
        map = new HashMap<>();
        int temp = dfs(s.toCharArray(), 0);
        return temp == Integer.MAX_VALUE ? -1 : temp;
    }

    private int dfs(char[] chs, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        if (start == chs.length) {
            return 0;
        }
        if (chs[start] == '0') {
            return -1;
        }
        int temp = -1;
        for (String str: validString) {
            int len = str.length();
            if (start + len > chs.length) {
                break;
            }
            String tempStr = new String(chs, start, len);
            if (str.equals(tempStr)) {
                int tempSize = dfs(chs, start + len);
                if (tempSize != -1) {
                    if (temp != -1) {
                        temp = Math.min(temp, tempSize + 1);
                    } else {
                        temp = tempSize + 1;
                    }
                }
            }
        }
        map.put(start, temp);
        return temp;
    }

    public static void main(String[] args) {
        Solution2767 test = new Solution2767();
        // 2
        System.out.println(test.minimumBeautifulSubstrings("1011"));
        // 3
        System.out.println(test.minimumBeautifulSubstrings("111"));
        // -1
        System.out.println(test.minimumBeautifulSubstrings("0"));
        // 5
        System.out.println(test.minimumBeautifulSubstrings("101101110011101"));
        // 2
        System.out.println(test.minimumBeautifulSubstrings("1100001101011"));
    }
}
