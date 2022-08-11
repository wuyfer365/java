// 实现 strStr()
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。

// 说明：

// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

//  

// 示例 1：

// 输入：haystack = "hello", needle = "ll"
// 输出：2
// 示例 2：

// 输入：haystack = "aaaaa", needle = "bba"
// 输出：-1
//  

// 提示：

// 1 <= haystack.length, needle.length <= 10^4
// haystack 和 needle 仅由小写英文字符组成

public class Test28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {//如果needle为空，返回0
            return 0;
        }
        int i = 0;//i为haystack的下标
        int j = 0;//j为needle的下标
        while (i < haystack.length()) {//遍历haystack
            if (haystack.charAt(i) == needle.charAt(j)) {//如果haystack的下标与needle的下标相等，则j++ 并且i++
                i++;
                j++;
                if (j == needle.length()) {//如果j等于needle的长度，则返回i-j
                    return i - j;
                }
            } else {//如果haystack的下标与needle的下标不相等，则j重置为0，i++
                i=i-j+1;//i为haystack的下标 
                j=0;//j重置为0
            }
        }
        return -1;//如果没有找到，返回-1
    }
    public static void main(String[] args) {
        Test28 test28 = new Test28();
        System.out.println(test28.strStr("mississippi", "issip"));
    }
}
