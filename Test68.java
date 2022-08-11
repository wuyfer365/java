import java.util.ArrayList;
import java.util.List;

//文本左右对齐
// 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

// 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。

// 注意:

// 单词是指由非空格字符组成的字符序列。
// 每个单词的长度大于 0，小于等于 maxWidth。
// 输入单词数组 words 至少包含一个单词。

// 示例 1:

// 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
// 输出:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// 示例 2:

// 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
// 输出:
// [
//   "What   must   be",
//   "acknowledgment  ",
//   "shall be        "
// ]
// 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//      因为最后一行应为左对齐，而不是左右两端对齐。       
//      第二行同样为左对齐，这是因为这行只包含一个单词。
// 示例 3:

// 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
// 输出:
// [
//   "Science  is  what we",
//   "understand      well",
//   "enough to explain to",
//   "a  computer.  Art is",
//   "everything  else  we",
//   "do                  "
// ]

// 提示:

// 1 <= words.length <= 300
// 1 <= words[i].length <= 20
// words[i] 由小写英文字母和符号组成
// 1 <= maxWidth <= 100
// words[i].length <= maxWidth

public class Test68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();

        // 遍历并看当前单词能否加入当前行
        for (int i = 0, currWidth = 0; i < words.length; i++) {
            if (currWidth + words[i].length() + line.size() <= maxWidth) {// 当前单词能加入当前行
                currWidth += words[i].length();// 当前行的宽度加上当前单词的宽度
                line.add(words[i]);// 加入当前行
            } else {
                // 当前行不能加入当前单词，则把当前行填充空格后加入结果集
                res.add(fillSpace(line, maxWidth, false));
                // 重置当前行数组为当前单词 并且当前行的宽度为当前单词的宽度
                line = new ArrayList<>();
                currWidth = words[i].length();
                line.add(words[i]);
            }
        }
        // 添加最后一行 并且填充空格
        res.add(fillSpace(line, maxWidth, true));
        return res;
    }

    String fillSpace(List<String> words, int maxWidth, boolean last) {
        int curWidth = 0;
        for (int i = 0; i < words.size(); i++) {
            // 如果不是最后一个单词，则当前单词加上一个空格
            if (i != words.size() - 1) {
                words.set(i, words.get(i) + " ");
            }
            curWidth += words.get(i).length();// 当前行的宽度加上当前单词的宽度
        }
        // 如果是最后一行,或者当前行只有一个单词，则空格全部加上
        if (last || words.size() == 1) {
            // 计算空格数量
            int spaceNum = maxWidth - curWidth;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < spaceNum; j++) {
                sb.append(" ");
            }
            words.set(words.size() - 1, words.get(words.size() - 1) + sb.toString());
        } else {// 从前向后循环添加空格 
            for (int j = 0; curWidth++ < maxWidth; j = (j + 1) % (words.size() - 1)) {// 每次循环添加一个空格
                words.set(j, words.get(j) + " ");
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Test68 test68 = new Test68();
        String[] words = { "What","must","be","acknowledgment","shall","be" };
        int maxWidth = 16;
        List<String> res = test68.fullJustify(words, maxWidth);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
