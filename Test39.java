import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 组合总和
// 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。

//  

// 示例 1：

// 输入：candidates = [2,3,6,7], target = 7
// 输出：[[2,2,3],[7]]
// 解释：
// 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
// 7 也是一个候选， 7 = 7 。
// 仅有这两种组合。
// 示例 2：

// 输入: candidates = [2,3,5], target = 8
// 输出: [[2,2,2,2],[2,3,3],[3,5]]
// 示例 3：

// 输入: candidates = [2], target = 1
// 输出: []
//  

// 提示：

// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都 互不相同
// 1 <= target <= 500

public class Test39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {// 回溯法 求解所有组合
        List<List<Integer>> res = new ArrayList<>();// 结果
        if (candidates == null || candidates.length == 0) {// 如果数组为空 或者长度为0 则返回空
            return res;
        }
        Arrays.sort(candidates);// 排序
        dfs(candidates, target, 0, new ArrayList<>(), res);// 回溯法
        return res;
    }
    // 回溯法 求解所有组合 candidates 数组 和 target 目标数字 index 当前指针 list 当前组合 res 结果
    private void dfs(int[] candidates, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {// 如果目标数字为0 则添加结果 并返回
            res.add(new ArrayList<>(list));// 添加结果
            return;
        }
        for (int i = index; i < candidates.length; i++) {// 循环遍历数组
            if (candidates[i] > target) {// 如果当前数字大于目标数字 则跳出循环
                break;
            }
            list.add(candidates[i]);// 添加当前数字
            dfs(candidates, target - candidates[i], i, list, res);// 回溯法
            list.remove(list.size() - 1);// 删除当前数字 回溯 到上一层 并继续循环
        }
    }
    public static void main(String[] args) {
        Test39 test39 = new Test39();
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> res = test39.combinationSum(candidates, target);
        System.out.println(res);
        
    }
}
