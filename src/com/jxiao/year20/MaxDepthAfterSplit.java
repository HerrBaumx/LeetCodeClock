package com.jxiao.year20;

import java.util.Stack;

public class MaxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int idx = 0;
        for (char c : seq.toCharArray()) {
            ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
        }
        return ans;


        int len = seq.length();
        int[] res = new int[len];
        // 嵌套深度，栈的当前高度
        int depth = 0;
        // 在 Java 里，seq.charAt(i) 函数会做下标越界检查，
        // 因此先转换成字符数组是常见的做法
        char[] charArray = seq.toCharArray();
        for (int i = 0; i < len; i++) {
            // 遍历到左括号，连续括号个数加 1，
            if (charArray[i] == '(') {
                depth++;
                // % 2 也可以写成 & 1，为了保证语义清楚，写 % 2
                //
                res[i] = depth % 2;
            } else {
                // 遍历到右括号，与当前栈顶左括号分在一组，因此先取模，再 --
                // 这一步希望大家多体会，很有意思
                res[i] = depth % 2;
                depth--;
            }
        }
        return res;


            if (seq == null || seq.equals("")) return new int[0];
            Stack<Character> stack = new Stack<>();
            int[] res = new int[seq.length()];
            //遍历
            for (int i = 0; i < seq.length(); i++) {
                char c = seq.charAt(i);
                if (c == '(') {
                    //入栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
                    res[i] = stack.size() % 2;
                    stack.push(c);
                } else {
                    //出栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
                    stack.pop();
                    res[i] = stack.size() % 2;
                }
            }
            return res;
    }
}



    }


            }
