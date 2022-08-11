import java.util.ArrayList;
import java.util.List;

//组合
// 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

// 你可以按 任何顺序 返回答案。

// 示例 1：

// 输入：n = 4, k = 2
// 输出：
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
// 示例 2：

// 输入：n = 1, k = 1
// 输出：[[1]]

// 提示：

// 1 <= n <= 20
// 1 <= k <= n

public class Test77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }
    private void dfs(int start, int n, int k) {
        if (k == 0) {//如果k为0，说明已经组合完成，添加到结果中
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = start; j <= n; j++) {//从start开始，遍历到n
            list.add(j);
            dfs(j + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        Test77 test77 = new Test77();
        System.out.println(test77.combine(4, 2));
    }
}
