package com.example.problem26xx;

/**
 * @author xiejx
 * @date 2024/1/11 9:40
 */
public class Solution2645 {
    public int addMinimum(String word) {
        // 在后面补充a,这样就不用额外判断最后一个字符
        word = word + 'a';
        int result = 0;
        int n = word.length();
        char prev = 'c';
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch == 'a') {
                if (prev == 'b') {
                    result += 1;
                } else if (prev == 'a') {
                    result += 2;
                }
            } else if (ch == 'b') {
                if (prev == 'b') {
                    result += 2;
                } else if (prev == 'c') {
                    result += 1;
                }
            } else if (ch == 'c') {
                if (prev == 'a') {
                    result += 1;
                } else if (prev == 'c') {
                    result += 2;
                }
            }
            prev = ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2645 test = new Solution2645();
        // 2
        System.out.println(test.addMinimum("b"));
        // 6
        System.out.println(test.addMinimum("aaa"));
        // 2
        System.out.println(test.addMinimum("abc"));
    }
}
