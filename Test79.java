//单词搜索
// 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

// 示例 1：

// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// 输出：true
// 示例 2：

// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// 输出：true
// 示例 3：

// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// 输出：false

// 提示：

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成

public class Test79 {
    // 定义四个方向dx,dy
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, -1, 0, 1 };

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {// 遍历每一行
            for (int j = 0; j < board[0].length; j++) {// 遍历每一列 每一行的每一列
                if (dfs(board, word, i, j, 0)) {// 如果找到了，返回true
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {// 如果当前字符不等于word的第k个字符，返回false
            return false;
        }
        if (k == word.length()-1) {// 如果已经找到了word的长度，返回true
            return true;
        }        
        // 将当前字符替换为'.'字符，避免重复使用
        char temp = board[i][j];
        board[i][j] = '.';
        for (int k1 = 0; k1 < 4; k1++) {// 遍历四个方向
            int x = i + dx[k1];// x方向的坐标
            int y = j + dy[k1];// y方向的坐标
            if (x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]=='.') {// 如果x,y坐标不在范围内，或者当前字符为'.'，则跳过
                continue;
            }
            if (dfs(board, word, x, y, k + 1)) {// 如果x,y坐标在范围内，则返回true
                return true;
            }
        }
        board[i][j] = temp;// 恢复原来的字符
        return false;
    }
    public static void main(String[] args) {
        Test79 test79 = new Test79();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(test79.exist(board, word));
    }
}
