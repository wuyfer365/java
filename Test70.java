import java.util.Vector;

//爬楼梯
// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

// 示例 1：

// 输入：n = 2
// 输出：2
// 解释：有两种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶
// 2. 2 阶
// 示例 2：

// 输入：n = 3
// 输出：3
// 解释：有三种方法可以爬到楼顶。
// 1. 1 阶 + 1 阶 + 1 阶
// 2. 1 阶 + 2 阶
// 3. 2 阶 + 1 阶

// 提示：

// 1 <= n <= 45

public class Test70 {
    public int climbStairs(int n) {
        Vector<Integer> res=new Vector<Integer>();
        //给res分配n+2个空间
        res.setSize(n+2);
        res.set(1, 1);
        res.set(2, 2);
        for(int i=3;i<=n;i++){
            res.set(i, res.get(i-1)+res.get(i-2));
        }
        return res.get(n);
    }
    public static void main(String[] args) {
        Test70 test70=new Test70();
        int n=3;
        int res=test70.climbStairs(n);
        System.out.println(res);
        System.exit(0);
    }
}
