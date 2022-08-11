//x 的平方根 
// 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

// 示例 1：

// 输入：x = 4
// 输出：2
// 示例 2：

// 输入：x = 8
// 输出：2
// 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

// 提示：

// 0 <= x <= 2^31 - 1

public class Test69 {
    public int mySqrt(int x) {
        int left=0;//左边界
        int right=x;//右边界
        while(left<right){//左右边界相遇就是答案
            int mid=left+(right-left)/2+1;//中间值
            if((long)((long)mid*(long)mid)<=x){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return right;
    }
    public static void main(String[] args) {
        Test69 test69=new Test69();
        int x=17;
        int res=test69.mySqrt(x);
        System.out.println(res);
        System.exit(0); 
    }
}
