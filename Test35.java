// 搜索插入位置
// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

// 请必须使用时间复杂度为 O(log n) 的算法。

//  

// 示例 1:

// 输入: nums = [1,3,5,6], target = 5
// 输出: 2
// 示例 2:

// 输入: nums = [1,3,5,6], target = 2
// 输出: 1
// 示例 3:

// 输入: nums = [1,3,5,6], target = 7
// 输出: 4
//  

// 提示:

// 1 <= nums.length <= 10^4
// -10^4 <= nums[i] <= 10^4
// nums 为 无重复元素 的 升序 排列数组
// -10^4 <= target <= 10^4

public class Test35 {
    public int searchInsert(int[] nums, int target) {//二分查找
        int left = 0;//左边界
        int right = nums.length - 1;//右边界
        while (left <= right) {//二分查找
            int mid = left + (right - left) / 2;//中间位置
            if (nums[mid] == target) {//如果中间位置的值等于目标值，则返回中间位置
                return mid;//返回中间位置
            } else if (nums[mid] < target) {//如果中间位置的值小于目标值，则将左边界移动到中间位置
                left = mid + 1;//左边界移动到中间位置
            } else {
                right = mid - 1;//右边界移动到中间位置
            }
        }
        return left;//如果没有找到目标值，则返回左边界的位置
    }
    public static void main(String[] args) {
        Test35 test35 = new Test35();
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(test35.searchInsert(nums, target));
    }
}
