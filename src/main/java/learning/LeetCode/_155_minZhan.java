package main.java.learning.LeetCode;

import java.util.Stack;

/*
最小栈:这题的逻辑思路可以学习一下，挺好的
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
* */
public class _155_minZhan {

    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    /** initialize your data structure here. */
    public _155_minZhan() {//构造函数
        stack = new Stack<>();
        min_stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }

    public void pop() {//删除栈顶元素
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();//取值并删除
    }

    public int top() {
        return stack.peek();//取栈顶值但不删除
    }

    public int getMin() {
        return min_stack.peek();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
