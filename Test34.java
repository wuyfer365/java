// 在排序数组中查找元素的第一个和最后一个位置
// 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

// 如果数组中不存在目标值 target，返回 [-1, -1]。

// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。


// 示例 1：

// 输入：nums = [5,7,7,8,8,10], target = 8
// 输出：[3,4]
// 示例 2：

// 输入：nums = [5,7,7,8,8,10], target = 6
// 输出：[-1,-1]
// 示例 3：

// 输入：nums = [], target = 0
// 输出：[-1,-1]
//  

// 提示：

// 0 <= nums.length <= 10^5
// -10^9 <= nums[i] <= 10^9
// nums 是一个非递减数组
// -10^9 <= target <= 10^9

public class Test34 {
    public int[] searchRange(int[] nums, int target) {//二分查找
        int[] res = new int[2];//[-1,-1]
        res[0] = -1;
        res[1] = -1;
        if (nums.length == 0) {//如果数组为空，返回[-1,-1]
            return res;
        }
        int left = 0;//左边界
        int right = nums.length - 1;//右边界
        while (left < right) {//二分查找
            int mid = left+(right-left)/2;//中间位置
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            } 
        }
        if(nums[left] != target){//如果没有找到，返回[-1,-1]
            return res;
        }
        res[0] = left;//找到了，返回左边界
        left = 0;//重置左边界
        right = nums.length - 1;//重置右边界
        while (left < right) {//二分查找
            int mid = left+(right-left)/2+1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        res[1] = right;//找到了，返回右边界
        return res;
    }
    
    public static void main(String[] args) {
        Test34 test = new Test34();
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        int[] res = test.searchRange(nums, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
