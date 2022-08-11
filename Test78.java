import java.util.ArrayList;
import java.util.List;

//子集
// 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

// 示例 1：

// 输入：nums = [1,2,3]
// 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 示例 2：

// 输入：nums = [0]
// 输出：[[],[0]]

// 提示：

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// nums 中的所有元素 互不相同

public class Test78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {//1 << n表示2的n次方 
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {//j表示二进制的第j位
                if ((i & (1 << j)) > 0) {//如果i的第j位是1，说明该位置上有数字
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
    public static void main(String[] args) {
        Test78 test78 = new Test78();
        int[] nums = {1,2,3};
        System.out.println(test78.subsets(nums));
    }

    
}
