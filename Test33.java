// 搜索旋转排序数组
// 整数数组 nums 按升序排列，数组中的值 互不相同 。

// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。


// 示例 1：

// 输入：nums = [4,5,6,7,0,1,2], target = 0
// 输出：4
// 示例 2：

// 输入：nums = [4,5,6,7,0,1,2], target = 3
// 输出：-1
// 示例 3：

// 输入：nums = [1], target = 0
// 输出：-1

// 提示：

// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10^4 <= target <= 10^4

public class Test33 {
    public int search(int[] nums, int target) {//二分查找
        int left = 0;//左边界
        int right = nums.length - 1;//右边界
        while (left <= right) {//当左边界小于等于右边界时，进行二分查找
            int mid = (left + right) / 2;//中间值
            if (nums[mid] == target) {//如果中间值等于目标值，返回中间值下标
                return mid;
            }
            if (nums[left] <= nums[mid]) {//如果左边界小于等于中间值，则目标值可能在左边界和中间值之间
                if (nums[left] <= target && target < nums[mid]) {//如果目标值在左边界和中间值之间，则在左边界中进行二分查找
                    right = mid - 1;
                } else {//如果目标值不在左边界和中间值之间，则在右边界中进行二分查找
                    left = mid + 1;
                }
            } else {//如果左边界大于中间值，则目标值可能在中间值和右边界之间
                if (nums[mid] < target && target <= nums[right]) {//如果目标值在中间值和右边界之间，则在右边界中进行二分查找
                    left = mid + 1;
                } else {//如果目标值不在中间值和右边界之间，则在左边界中进行二分查找
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Test33 test33 = new Test33();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(test33.search(nums, target));
    }
}
