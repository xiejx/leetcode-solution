package com.example.problem5xx;

import javafx.util.Pair;

import java.util.*;

/**
 * Hard
 * CPU: 9.01% Memory: 5.27%
 * @author xiejx
 * @date 2024/1/29 9:45
 */
public class Solution514 {
    private Map<Character, List<Integer>> charIndexes;
    private Map<Pair<Integer, Integer>, Integer> cacheMap;
    public int findRotateSteps(String ring, String key) {
        charIndexes = new HashMap<>(26);
        cacheMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            charIndexes.put((char) ('a' + i), new ArrayList<>());
        }
        int n = ring.length();
        for (int i = 0; i < n; i++) {
            char ch = ring.charAt(i);
            charIndexes.get(ch).add(i);
        }
        return dfs(ring, key, 0, 0) + key.length();
    }

    private int dfs(String ring, String key, int curIndex, int targetIndex) {
        if (targetIndex >= key.length()) {
            return 0;
        }
        Pair<Integer, Integer> pair = new Pair<>(curIndex, targetIndex);
        if (cacheMap.containsKey(pair)) {
            return cacheMap.get(pair);
        }
        int n = ring.length();
        // 目标字符
        char ch = key.charAt(targetIndex);
        // 目标字符在ring中的位置
        List<Integer> indexes = charIndexes.get(ch);
        int min = Integer.MAX_VALUE;
        for (Integer nextIndex: indexes) {
            int step = Math.min((curIndex + n - nextIndex) % n, (nextIndex + n - curIndex) % n);
            int temp = dfs(ring, key, nextIndex, targetIndex + 1) + step;
            min = Math.min(temp, min);
        }
        cacheMap.put(pair, min);
        return min;
    }

    public static void main(String[] args) {
        Solution514 test = new Solution514();
        // 4
        System.out.println(test.findRotateSteps("godding", "gd"));
        // 13
        System.out.println(test.findRotateSteps("godding", "godding"));
        // 17
        System.out.println(test.findRotateSteps("ababcab", "acbaacba"));
        char[] chs = new char[100];
        Random random = new Random(1L);
        for (int i = 0; i < 100; i++) {
            int next = random.nextInt(26);
            chs[i] = (char) (next + 'a');
        }
        String ring = String.valueOf(chs);
        Long start = System.currentTimeMillis();
        // 199
        System.out.println(test.findRotateSteps(ring, ring));
        Long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + " 毫秒");
    }
}
