package com.example.problem27xx;

import java.util.HashSet;
import java.util.Set;

/**
 * Easy
 * CPU:41.18% Memory:34.56%
 * @author xiejx
 * @date 2024/1/17 9:37
 */
public class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int result = 0;
        Set<String> set = new HashSet<>();
        for (String word: words) {
            String reverse = new StringBuffer(word).reverse().toString();
            if (set.contains(reverse)) {
                set.remove(reverse);
                result += 1;
            } else {
                set.add(word);
            }
        }
        return result;
    }
}
