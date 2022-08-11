import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 组合总和 II
// 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

// candidates 中的每个数字在每个组合中只能使用 一次 。

// 注意：解集不能包含重复的组合。 

// 示例 1:

// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
// 输出:
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// 示例 2:

// 输入: candidates = [2,5,2,1,2], target = 5,
// 输出:
// [
// [1,2,2],
// [5]
// ]

// 提示:

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();// 结果 
        if (candidates == null || candidates.length == 0) {// 如果 candidates 为空，直接返回空
            return res;
        }
        Arrays.sort(candidates);// 排序 
        backtrack(candidates, target, 0, new ArrayList<Integer>(), res);// 回溯
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {// 如果 target 为 0，直接添加 list 到 res 中
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {// 回溯 
            if (i > start && candidates[i] == candidates[i - 1]) {// 如果 i 不是第一个元素，且和前一个元素相同，则跳过
                continue;
            }
            if (candidates[i] > target) {// 如果 candidates[i] 大于 target，则跳过
                break;
            }
            list.add(candidates[i]);// 添加 candidates[i] 到 list 中
            backtrack(candidates, target - candidates[i], i + 1, list, res);// 回溯 
            list.remove(list.size() - 1);// 删除 list 最后一个元素
        }
    }
    public static void main(String[] args) {
        Test40 test = new Test40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = test.combinationSum2(candidates, target);
        System.out.println(res);
    }
}
