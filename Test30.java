import java.util.ArrayList;
import java.util.List;

// 串联所有单词的子串
// 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。


// 示例 1：

// 输入：s = "barfoothefoobarman", words = ["foo","bar"]
// 输出：[0,9]
// 解释：
// 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
// 输出的顺序不重要, [9,0] 也是有效答案。
// 示例 2：

// 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
// 输出：[]
// 示例 3：

// 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
// 输出：[6,9,12]
//  

// 提示：

// 1 <= s.length <= 10^4
// s 由小写英文字母组成
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 30
// words[i] 由小写英文字母组成

public class Test30 {
    public List<Integer> findSubstring(String s, String[] words) {// 双指针 + 哈希表 
        List<Integer> res = new ArrayList<>();// 存储结果
        if (s == null || words == null || words.length == 0) {// 如果字符串为空或者单词为空，直接返回空
            return res;
        }
        //计算s的长度是单词长度的多少倍，即单词个数
        int len = words[0].length();// 单词长度 
        int num = words.length;// 单词数量
        // 创建列表存储words中的单词，用于查找
        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }
        
        for (int i = 0; i < s.length(); i++) {// 双指针，从左到右遍历字符串
            int left = i;// 左指针
            int count = 0;// 单词个数
            //创建临时列表存储单词，拷贝list中的单词
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                temp.add(list.get(j));
            }

            for (int j = left; j + len <= s.length(); j += len) {// 右指针，遍历字符串
                String word = s.substring(j, j + len);// 取出单词
                //判断temp中是否有word，如果有，则删除，并计数+1，如果没有，则跳出循环
                if (temp.contains(word)) {//删除第一个单词
                    temp.remove(word);//
                    count++;
                    if(count==num){//如果单词个数等于单词数量，则说明找到了
                        res.add(left);
                        break;
                    }
                } else {//如果没有，则重新从左到右遍历字符串，重置指针，重置计数
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Test30 test30 = new Test30();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(test30.findSubstring(s, words));
    }
}
