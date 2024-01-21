package com.example.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiejx
 * @date 2024/1/19 20:56
 */
public class ListUtil {
    public static List<Integer> fromArray(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int num: arr) {
            list.add(num);
        }
        return list;
    }

    public static List<Long> fromArray(long[] arr) {
        List<Long> list = new ArrayList<>(arr.length);
        for (long num: arr) {
            list.add(num);
        }
        return list;
    }
}
