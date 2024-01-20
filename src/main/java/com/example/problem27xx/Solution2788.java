package com.example.problem27xx;

import java.util.ArrayList;
import java.util.List;

/**
 * Easy
 * CPU: 83.04% Memory:20.47%
 */
public class Solution2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> resultList = new ArrayList<>();
        for (String word: words) {
            int start = 0;
            boolean flag = false;
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == separator) {
                    if (flag) {
                        flag = false;
                        resultList.add(new String(chs, start, i - start));
                    }
                } else if (!flag) {
                    flag = true;
                    start = i;
                }
            }
            if (flag) {
                resultList.add(new String(chs, start, chs.length - start));
            }
        }
        return resultList;
    }
}
