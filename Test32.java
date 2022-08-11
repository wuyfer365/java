import java.util.Stack;

// 最长有效括号
// 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。


// 示例 1：

// 输入：s = "(()"
// 输出：2
// 解释：最长有效括号子串是 "()"
// 示例 2：

// 输入：s = ")()())"
// 输出：4
// 解释：最长有效括号子串是 "()()"
// 示例 3：

// 输入：s = ""
// 输出：0

// 提示：

// 0 <= s.length <= 3 * 10^4
// s[i] 为 '(' 或 ')'

public class Test32 {
    public int longestValidParentheses(String s) {//暴力解法 O(n^2)
        //定义一个栈
        Stack<Integer> stack = new Stack<>();
        //定义一个变量记录最长长度
        int max = 0;
        //遍历字符串
        for (int i = 0,start=-1; i < s.length(); i++) {
            //如果是左括号，就放入栈中
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //如果是右括号，就判断栈中是否有左括号
                if (!stack.isEmpty()) {
                    //如果有，就将栈中的左括号弹出，并计算长度
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i-start);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }else{
                    //如果没有，就将开始位置设置为当前位置
                    start = i;
                }
            }
        }
        return max;
  }
    public static void main(String[] args) {
        Test32 test32 = new Test32();
        System.out.println(test32.longestValidParentheses("(())"));
    }
    
}
