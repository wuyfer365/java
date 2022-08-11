// 搜索二维矩阵
// 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。

// 示例 1：


// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// 输出：true
// 示例 2：


// 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// 输出：false

// 提示：

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10^4 <= matrix[i][j], target <= 10^4

public class Test74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //折半查找第一列中大于等于target的最小行号
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        //第一列中大于等于target的最小行号
        int row=right;
        if(row<0){
            return false;
        }
        if(matrix[row][0]>target){//如果第一列中大于等于target的最小行号不存在，则直接返回false
            return false;
        }
        //折半查找第row行
        left=0;
        right=m-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(matrix[row][mid]==target){
                return true;
            }else if(matrix[row][mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] matrix={{1},{2},{4}};
        int target=2;
        Test74 test74=new Test74();
        System.out.println(test74.searchMatrix(matrix,target));
    }
}
