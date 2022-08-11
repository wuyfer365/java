// 下一个排列
// 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。

// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。

// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
// 给你一个整数数组 nums ，找出 nums 的下一个排列。

// 必须 原地 修改，只允许使用额外常数空间。

//  

// 示例 1：

// 输入：nums = [1,2,3]
// 输出：[1,3,2]
// 示例 2：

// 输入：nums = [3,2,1]
// 输出：[1,2,3]
// 示例 3：

// 输入：nums = [1,1,5]
// 输出：[1,5,1]
//  

// 提示：

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 100

public class Test31 {
    public void nextPermutation(int[] nums) {//暴力解法
        int i = nums.length - 2;//从后往前找到第一个降序的数字
        while (i >= 0 && nums[i] >= nums[i + 1]) {//如果i的值大于等于i+1的值，则说明i的值是降序的，因为i的值是从后往前找的，所以i的值一定比i+1的值小
            i--;
        }
        if(i==-1){//如果i的值为-1，说明数组是降序的，那么直接将数组反转即可
            reverse(nums,0);
            return;
        }
        if (i >= 0) {//如果i的值大于等于0，说明i的值是降序的，因为i的值是从后往前找的，所以i的值一定比i+1的值小
            int j = nums.length - 1;//从后往前找到第一个大于i的值
            while (j >= 0 && nums[j] <= nums[i]) {//如果j的值小于等于i的值，则说明j的值是小于等于i的值，因为j的值是从后往前找的，所以j的值一定比i的值大
                j--;
            }
            int temp = nums[i];//交换i和j的值
            nums[i] = nums[j];
            nums[j] = temp;
        }
        reverse(nums, i + 1);//将i+1之后的数字反转
    }
    public void reverse(int[] nums, int start) {//反转数组
        int i = start, j = nums.length - 1;//
        while (i < j) {//交换i和j的值
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Test31 test31 = new Test31();
        int[] nums = {1,2,3};
        test31.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
