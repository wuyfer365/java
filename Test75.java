//颜色分类
// 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

// 必须在不使用库的sort函数的情况下解决这个问题。

// 示例 1：

// 输入：nums = [2,0,2,1,1,0]
// 输出：[0,0,1,1,2,2]
// 示例 2：

// 输入：nums = [2,0,1]
// 输出：[0,1,2]
//  

// 提示：

// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2

// 进阶：

// 你可以不使用代码库中的排序函数来解决这道题吗？
// 你能想出一个仅使用常数空间的一趟扫描算法吗？

public class Test75 {
    public void sortColors(int[] nums) {
        //快速排序nums
        int left=0;
        int right=nums.length-1;
        int mid=0;
        while(mid<=right){//mid<=right
            if(nums[mid]==0){//如果mid是0，则交换mid和left，left向右移动一位，mid向右移动一位
                int temp=nums[left];
                nums[left]=nums[mid];
                nums[mid]=temp;
                left++;
                mid++;
            }else if(nums[mid]==1){//如果mid是1，则mid向右移动一位
                mid++;
            }else{//如果mid是2，则交换mid和right，right向左移动一位，mid向左移动一位
                int temp=nums[mid];
                nums[mid]=nums[right];
                nums[right]=temp;
                right--;
            }
        }

    }
    public static void main(String[] args) {
        int[] nums={2,0,2,1,1,0};
        Test75 test75=new Test75();
        test75.sortColors(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
}
