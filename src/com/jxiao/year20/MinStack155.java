package com.jxiao.year20;

import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *     push(x) —— 将元素 x 推入栈中。
 *     pop() —— 删除栈顶的元素。
 *     top() —— 获取栈顶元素。
 *     getMin() —— 检索栈中的最小元素。
 *
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 *
 * 提示：
 *
 *     pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack155 {

    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack155() {
        data=new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {

        data.add(x);
        if(helper.isEmpty() || helper.peek()>=x){
            helper.add(x);
        }
    }

    public void pop() {

        if(!data.isEmpty()){
            int top = data.pop();
            if(top==helper.peek()){
                helper.pop();
            }
        }
    }

    public int top() {

        if (!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {

        if (!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
