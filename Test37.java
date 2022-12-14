// 解数独
// 编写一个程序，通过填充空格来解决数独问题。
// 数独的解法需 遵循如下规则：

// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
// 数独部分空格内已填入了数字，空白格用 '.' 表示。

//  

// 示例 1：


// 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
// 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：


//  

// 提示：

// board.length == 9
// board[i].length == 9
// board[i][j] 是一位数字或者 '.'
// 题目数据 保证 输入数独仅有一个解

public class Test37 {
    //定义行/列/宫的数组，用来记录每一行/列/宫是否有数字1-9
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] box = new boolean[3][3][9];
    public void solveSudoku(char[][] board) {
        //初始化行/列/宫的数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3][j / 3][num] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }
    //定义dfs函数，用来求解数独,参数为board和当前要填入的位置，返回值为是否求解成功
    public boolean dfs(char[][] board, int x, int y) {
        //如果当前位置已经是最后一个位置，则到下一行,列置为0
        if (y == 9) {
            x++;
            y = 0;
        }
        //如果到达最后一行，则返回true
        if (x == 9) {
            return true;
        }
        //如果当前位置已经有数字，则继续往右走
        if (board[x][y] != '.') {
            return dfs(board, x, y + 1);
        }
        //枚举当前位置可以填的数字,如果对应的行/列/宫没有重复数字，则填入，否则回溯
        for (int i = 0; i < 9; i++) {
            if (!row[x][i] && !col[y][i] && !box[x / 3][y / 3][i]) {//如果当前行/列/宫没有重复数字
                board[x][y] = (char) (i + '1');//填入数字
                row[x][i] = true;//记录行已有数字
                col[y][i] = true;//记录列已有数字
                box[x / 3][y / 3][i] = true;//记录宫已有数字
                if (dfs(board, x, y + 1)) {//递归调用，继续求解 如果求解成功，则返回true
                    return true;
                }
                row[x][i] = false;//求解失败，回溯，撤销填入的数字
                col[y][i] = false;//撤销填入的数字
                box[x / 3][y / 3][i] = false;//撤销填入的数字
                board[x][y] = '.';//撤销填入的数字
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        Test37 test37 = new Test37();
        test37.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
