//矩阵置零
// 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。

// 示例 1：


// 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
// 输出：[[1,0,1],[0,0,0],[1,0,1]]
// 示例 2：


// 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

// 提示：

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -2^31 <= matrix[i][j] <= 2^31 - 1

public class Test73 {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean rowZero=false;
        boolean colZero=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){//如果矩阵中有0，则行和列都设置为0
                    if(i==0){//如果是第一行，则行设置为0
                        rowZero=true;
                    }
                    if(j==0){//如果是第一列，则列设置为0
                        colZero=true;
                    }
                    matrix[i][0]=0;//将该行的第一个元素设置为0
                    matrix[0][j]=0;//将该列的第一个元素设置为0
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){//如果该行或该列的第一个元素为0，则该行或该列的所有元素都设置为0
                    matrix[i][j]=0;
                }
            }
        }
        if(rowZero){//如果行第一个元素为0，则将该行设置为0
            for(int i=0;i<m;i++){
                matrix[0][i]=0;
            }
        }
        if(colZero){//如果列第一个元素为0，则将该列设置为0
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix={{1,1,1},{1,0,1},{1,1,1}};
        Test73 test73=new Test73();
        test73.setZeroes(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
