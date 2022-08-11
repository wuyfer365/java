import java.util.HashMap;
import java.util.Map;

//最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

// 注意：

// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。

// 示例 1：

// 输入：s = "ADOBECODEBANC", t = "ABC"
// 输出："BANC"
// 示例 2：

// 输入：s = "a", t = "a"
// 输出："a"
// 示例 3:

// 输入: s = "a", t = "aa"
// 输出: ""
// 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
// 因此没有符合条件的子字符串，返回空字符串。

// 提示：

// 1 <= s.length, t.length <= 10^5
// s 和 t 由英文字母组成

// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？

public class Test76 {
    public String minWindow(String s, String t) {
        //定义两个map,hs,ht,用于记录s和t中的字符出现的次数
        Map<Character,Integer> hs=new HashMap<>();
        Map<Character,Integer> ht=new HashMap<>();
        //遍历t中的字符，记录每个字符出现的次数
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(ht.containsKey(c)){
                ht.put(c,ht.get(c)+1);
            }else{
                ht.put(c,1);
            }
        }
        String res="";
        for(int i=0,j=0,cnt=0;i<s.length();i++){
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0)+1);//记录s中的字符出现的次数 +1
            if(hs.getOrDefault(s.charAt(i), 0)<=ht.getOrDefault(s.charAt(i), 0)){//如果s中的字符出现的次数小于等于t中的字符出现的次数，则cnt加1
                cnt++;
            }
            while(hs.getOrDefault(s.charAt(j), 0)>ht.getOrDefault(s.charAt(j), 0)){
                hs.put(s.charAt(j), hs.getOrDefault(s.charAt(j), 0)-1);//hs中s.charAt(j)字符的次数减1
                j++;
                if(j>=s.length()){
                    break;
                }
            }
            //如果cnt等于t中的字符的个数，则说明s中的字符出现的次数等于t中的字符的个数，则记录最小子串
            if(cnt==t.length()){
                if(res.equals("")||res.length()>i-j+1){
                    res=s.substring(j,i+1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Test76 test76=new Test76();
        System.out.println(test76.minWindow("a","b"));
    }
}
