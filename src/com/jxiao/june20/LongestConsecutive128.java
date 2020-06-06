package com.jxiao.june20;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutive128 {

    public int longestConsecutive(int[] nums) {

        Set<Integer> nums_set = new HashSet<>();
        for (int num : nums) {
            nums_set.add(num);
        }
        int longCurrentStreak = 0;
        for (Integer num : nums_set) {

            if (!nums_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (nums_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longCurrentStreak = Math.max(currentStreak, longCurrentStreak);
            }
        }

        return longCurrentStreak;
    }
}
