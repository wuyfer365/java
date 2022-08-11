import java.util.ArrayList;
import java.util.List;

//括号生成
// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
// 示例 1：
// 输入：n = 3
// 输出：["((()))","(()())","(())()","()(())","()()()"]
// 示例 2：
// 输入：n = 1
// 输出：["()"]
// 提示：
// 1 <= n <= 8

public class Test22 {
    public static void main(String[] args) {
        List<String> list = new Test22().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        return generate(res, "", 0, 0, n);//调用递归函数 生成括号 并返回结果 res 中 括号的集合  左括号的数量  右括号的数量  总的括号的数量 

    }

    private List<String> generate(List<String> res, String string, int i, int j, int n) {
        if (string.length() == 2 * n) {//判断是否已经生成了所有的括号
            res.add(string);//添加到结果集   
            return res;//返回结果集
        }
        if (i < n) {//判断左括号还没有生成完
            generate(res, string + "(", i + 1, j, n);//生成左括号
        }
        if (j < i) {//判断右括号还没有生成完
            generate(res, string + ")", i, j + 1, n);//生成右括号
        }
        return res;//返回结果集
    }
}
