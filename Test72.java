import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

//编辑距离
// 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

// 你可以对一个单词进行如下三种操作：

// 插入一个字符
// 删除一个字符
// 替换一个字符

// 示例 1：

// 输入：word1 = "horse", word2 = "ros"
// 输出：3
// 解释：
// horse -> rorse (将 'h' 替换为 'r')
// rorse -> rose (删除 'r')
// rose -> ros (删除 'e')
// 示例 2：

// 输入：word1 = "intention", word2 = "execution"
// 输出：5
// 解释：
// intention -> inention (删除 't')
// inention -> enention (将 'i' 替换为 'e')
// enention -> exention (将 'n' 替换为 'x')
// exention -> exection (将 'n' 替换为 'c')
// exection -> execution (插入 'u')

// 提示：

// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成

public class Test72 {
    public int minDistance(String a, String b) {
        int n = a.length();
        int m = b.length();
        a=" "+a;
        b=" "+b;
        Vector<Vector<Integer>> res=new Vector<Vector<Integer>>();
        //给res分配n+1个空间,给每个空间分配m+1个空间,并且初始化为整数最大值
        res.setSize(n+1);
        for(int i=0;i<=n;i++){
            //初始化res每个元素
            res.set(i, new Vector<Integer>());
            res.get(i).setSize(m+1);
            for(int j=0;j<=m;j++){
                res.get(i).set(j, Integer.MAX_VALUE);
            }
        }
        for(int i=0;i<=n;i++){
            res.get(i).set(0, i);//每一行第一列 初始化为i
        }
        for(int i=0;i<=m;i++){
            res.get(0).set(i, i);//每一列第一行 初始化为i
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a.charAt(i)==b.charAt(j)){
                    res.get(i).set(j, res.get(i-1).get(j-1));
                }else{
                    res.get(i).set(j, Math.min(res.get(i-1).get(j), Math.min(res.get(i).get(j-1), res.get(i-1).get(j-1)))+1);
                }
            }
        }
        return res.get(n).get(m);
    }
    public static void main(String[] args) {
        Test72 test72=new Test72();
        System.out.println(test72.minDistance("horse", "ros"));
        Vector<Vector<Integer>> res2=new Vector<Vector<Integer>>();
        //Stream流初始化res2为3行3列,并且初始化为整数最大值
        res2.setSize(3);        
        AtomicInteger my_index = new AtomicInteger();
        res2.stream().forEach(e->{
            AtomicInteger my_index2 = new AtomicInteger();
            int i=my_index.getAndIncrement();
            res2.set(i, new Vector<Integer>());
            res2.get(i).setSize(3);
            res2.get(i).stream().forEach(f->{
                int j=my_index2.incrementAndGet()-1;
                // res2.get(i).set(j,Integer.MAX_VALUE);
                res2.get(i).set(j,i*j);
            });
        });
        // 打印res2
        res2.stream().forEach(e->{
            e.stream().forEach(f->{
                System.out.print(f+" ");
            });
            System.out.println();
        });

    }
}
