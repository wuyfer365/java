import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//滑动窗口实现
public class Test30_1 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();//存储结果
        if(words.length == 0) return res;//如果没有单词，直接返回空列表
        int n=s.length();//字符串长度
        int m=words.length;//单词个数
        int w=words[0].length();//单词长度
        //调用一个map来存储words中的单词
        Map<String,Integer> total = new HashMap<>();//存储单词个数
        //map中的key是单词，value是单词出现的次数 使用方法
        //put(key,value)：如果key存在，则更新value，如果key不存在，则插入key-value对
        //value+1
        for(String word:words){
            total.put(word,total.getOrDefault(word,0)+1);
        }
        for(int i=0;i<w;i++){//遍历字符串s中的每个字符 
            Map<String,Integer> window = new HashMap<>();//存储窗口中的单词个数
            int cnt=0;//记录窗口中单词个数
            for(int j=i;j+w<=n;j+=w){//遍历窗口中的每个单词 
                if(j-i>=m*w){//如果窗口中的单词个数大于单词个数，说明窗口中的单词已经超过了单词个数，需要将窗口左边的单词减去一个单词，并将窗口左边的单词的个数减一
                    String word = s.substring(j-m*w,j-m*w+w);//获取窗口左边的单词
                    window.put(word,window.getOrDefault(word,0)-1);//将窗口左边的单词的个数减一
                    if(window.getOrDefault(word,0)<total.getOrDefault(word,0)){//如果窗口左边的单词的个数小于单词个数，总单词数量减一 
                        cnt--;
                    }
                }
                String word = s.substring(j,j+w);//获取窗口中的单词
                window.put(word,window.getOrDefault(word,0)+1);//将窗口中的单词加一
                if(window.getOrDefault(word,0)<=total.getOrDefault(word,0)){
                    cnt++;
                }
                if(cnt==m){
                    res.add(j-m*w+w);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Test30_1 test = new Test30_1();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(test.findSubstring(s,words));
       
        
    }
    
}
