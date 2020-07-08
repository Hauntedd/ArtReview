package main.java.learning.LeetCode;

import java.time.format.FormatStyle;
import java.util.Stack;

/*
土木：有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
* */
public class bracketsUseful_20 {
    public boolean isValid(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())//字符数组里面不是左括号，那么把它和stack里面的有括号进行比对，若果匹配就继续，出现不匹配就直接返回false
                return false;
        }
//        if(stack.empty())//顺利比对完成到达这里，说明匹配完成了
//            return true;
//        return false;
        return stack.empty();//是空就说明全部匹配
    }
}
