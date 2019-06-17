package com.cyd.leecode.module1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Question3 {
    public static void main(String[] args) {
        String s = " ";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i = 0; i <s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                if(isUnion(s,i,j)) {
                    maxLength = Math.max(maxLength,j-i);
                }
            }
        }
        return maxLength;
    }

    public static boolean isUnion(String s,int i,int j){
        Set<Character> set = new HashSet<>();
        for(int k = i; k < j; k++){
            char chas;
            if(set.contains((chas =s.charAt(k)))){
                return false;
            }
            set.add(chas);
        }
        return true;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>(100);
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
