// 两数相除
// 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

// 返回被除数 dividend 除以除数 divisor 得到的商。

// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

//  

// 示例 1:

// 输入: dividend = 10, divisor = 3
// 输出: 3
// 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
// 示例 2:

// 输入: dividend = 7, divisor = -3
// 输出: -2
// 解释: 7/-3 = truncate(-2.33333..) = -2
//  

// 提示：

// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。

public class Test29 {
    public int divide(int dividend, int divisor) {//暴力解法 比较慢 但是可以通过
        if (dividend == 0) {//判断被除数是否为0 如果是则返回0
            return 0;
        }
        if (divisor == 1) {//判断除数是否为1 如果是则返回被除数
            return dividend;
        }
        if (divisor == -1) {//判断除数是否为-1 如果是则返回被除数的负数 因为负数的计算方式不同 所以要判断是否为负数
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;//判断被除数是否为最小值 如果是则返回最大值 否则返回被除数的负数
        }
        //^表示异或运算 相同为0 不同为1
        boolean isNegative = (dividend < 0) ^ (divisor < 0);//判断被除数和除数是否为负数 如果是则返回true 否则返回false
        long dividendLong = Math.abs((long) dividend);//将被除数转换为long类型 并且转换为绝对值
        long divisorLong = Math.abs((long) divisor);//将除数转换为long类型 并且转换为绝对值
        long result = 0;//定义一个long类型的变量用来存储结果
        while (dividendLong >= divisorLong) {//判断被除数是否大于等于除数
            long temp = divisorLong;//定义一个long类型的变量用来存储除数
            long multiple = 1;//定义一个long类型的变量用来存储倍数
            while (dividendLong >= (temp << 1)) {//判断被除数是否大于等于除数的两倍 如果是则倍数加一 否则跳出循环
                temp <<= 1;//将除数的值乘以2
                multiple <<= 1;//将倍数的值乘以2
            }
            dividendLong -= temp;//将被除数的值减去除数的两倍 即为下一次循环的被除数 如果被除数小于除数的两倍则跳出循环
            result += multiple;//将倍数的值加到结果中
        }
        return isNegative ? -(int) result : (int) result;//判断结果是否为负数 如果是则返回负数 否则返回正数
    }    
}
