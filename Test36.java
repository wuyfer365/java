// 有效的数独
// 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//  

// 注意：

// 一个有效的数独（部分已被填充）不一定是可解的。
// 只需要根据以上规则，验证已经填入的数字是否有效即可。
// 空白格用 '.' 表示。
// 示例 1：


// 输入：board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// 输出：true
// 示例 2：

// 输入：board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// 输出：false
// 解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
//  
// 提示：
// board.length == 9
// board[i].length == 9
// board[i][j] 是一位数字（1-9）或者 '.'
public class Test36 {
    public boolean isValidSudoku(char[][] board) {
        //定义9个元素boolean数组，用于判断每个数字是否出现过
        boolean[] row = new boolean[9];
        //循环遍历每一行
        for (int i = 0; i < 9; i++) {
            //循环遍历每一行的每一个元素
            for (int j = 0; j < 9; j++) {
                //如果当前元素不是空格，则判断是否出现过
                if (board[i][j] != '.') {
                    //如果出现过，则返回false
                    if (row[board[i][j] - '1']) {
                        return false;
                    }
                    //如果没有出现过，则将其设置为true
                    row[board[i][j] - '1'] = true;
                }
            }
            //将row数组元素重置为false
            for (int j = 0; j < 9; j++) {
                row[j] = false;
            }
        }
        //循环遍历每一列
        for (int i = 0; i < 9; i++) {
            //循环遍历每一列的每一个元素
            for (int j = 0; j < 9; j++) {
                //如果当前元素不是空格，则判断是否出现过
                if (board[j][i] != '.') {
                    //如果出现过，则返回false
                    if (row[board[j][i] - '1']) {
                        return false;
                    }
                    //如果没有出现过，则将其设置为true
                    row[board[j][i] - '1'] = true;
                }
            }
            //将row数组元素重置为false
            for (int j = 0; j < 9; j++) {
                row[j] = false;
            }
        }
        //遍历每一个3x3宫内
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                //循环遍历每一个3x3宫内的每一个元素
                for (int k = 0; k < 9; k++) {
                    //如果当前元素不是空格，则判断是否出现过
                    if (board[i + k / 3][j + k % 3] != '.') {
                        //如果出现过，则返回false
                        if (row[board[i + k / 3][j + k % 3] - '1']) {
                            return false;
                        }
                        //如果没有出现过，则将其设置为true
                        row[board[i + k / 3][j + k % 3] - '1'] = true;
                    }
                }
                //将row数组元素重置为false
                for (int k = 0; k < 9; k++) {
                    row[k] = false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Test36 test36 = new Test36();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(test36.isValidSudoku(board));
    }
    
}