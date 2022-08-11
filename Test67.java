//二进制求和
// 给你两个二进制字符串，返回它们的和（用二进制表示）。

// 输入为 非空 字符串且只包含数字 1 和 0。

// 示例 1:

// 输入: a = "11", b = "1"
// 输出: "100"
// 示例 2:

// 输入: a = "1010", b = "1011"
// 输出: "10101"

// 提示：

// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。

public class Test67 {
    public String addBinary(String a, String b) {
        int len1=a.length();//获取字符串a的长度
        int len2=b.length();//获取字符串b的长度
        int len=Math.max(len1,len2);//获取字符串a和字符串b的最大长度
        StringBuilder sb=new StringBuilder();
        int carry=0;//进位
        for(int i=0;i<len;i++){
            int ai=i<len1?a.charAt(len1-i-1)-'0':0;//获取字符串a的最后一位 如果i<len1 则获取字符串a的最后一位 否则获取0
            int bi=i<len2?b.charAt(len2-i-1)-'0':0;//获取字符串b的最后一位 如果i<len2 则获取字符串b的最后一位 否则获取0
            int sum=ai+bi+carry;//获取字符串a和字符串b的最后一位的和
            sb.append(sum%2);//将字符串a和字符串b的最后一位的和添加到字符串中
            carry=sum/2;//获取字符串a和字符串b的最后一位的和的进位
        }
        if(carry==1){
            sb.append(1);//将字符串a和字符串b的最后一位的和的进位添加到字符串中
        }
        return sb.reverse().toString();//将字符串反转并返回

    }
    public static void main(String[] args) {
        Test67 test67=new Test67();
        String a="11";
        String b="1";
        System.out.println(test67.addBinary(a,b));
    }
}
