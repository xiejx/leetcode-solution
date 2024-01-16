package com.example.problem3xx;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Medium
 * 我的思路有问题。应该使用Map + List
 * Map存储元素和下标（添加和删除），List存储元素（用于随机访问）。
 * 新增时在Map和List同时新增，删除时用Map中找到下标，然后在List中交换下标和最后一个元素，最后删除最后一个元素
 * 获取时随机从List中获取元素
 * CPU: 42.17% Memory: 35.55%
 * @author xiejx
 * @date 2024/1/16 10:03
 */
public class Solution380 {
}

class RandomizedSet {
    Set<Integer> set;
    Integer[] array;
    Random random;
    boolean flag;

    public RandomizedSet() {
        set = new HashSet<>();
        array = new Integer[0];
        flag = false;
        random = new Random();
    }

    public boolean insert(int val) {
        flag = false;
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        flag = false;
        return set.remove(val);
    }

    public int getRandom() {
        int index = random.nextInt(set.size());
        if (!flag) {
            array = set.toArray(array);
            flag = true;
        }
        return array[index];
    }
}
