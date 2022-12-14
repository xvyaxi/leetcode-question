//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics字符串 | 动态规划 
//
// 👍 5965, 👎 0bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.xyx.leetcode.editor.cn;

public class Q5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Q5LongestPalindromicSubstring().new Solution();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 以s[i]为中心的回文串
                String s1 = palindrome(s, i, i);
                // 以s[i]和s[i+1]为中心的回文串
                String s2 = palindrome(s, i, i + 1);
                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }
            return res;
        }

        // 在s中寻找以s[l]和s[r]为中心的最长回文串
        public String palindrome(String s, int l, int r) {
            // 防止索引越界
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                // 双指针，项两边展开
                l--;
                r++;
            }
            // 返回以s[l]和s[r]为中心的最长回文串
            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}