package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/31 上午11:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-31 11:04
 */
public class 二维区域和检索矩阵不可变2 {
    public int[][] matrixs;
    //动态规划
    public void NumMatrix(int[][] matrix) {
        if (matrix.length==0)
        {
            return;
        }
        matrixs=new int[matrix.length+1][matrix[0].length+1];
        //行列
        int sum=0;
        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[0].length;j++)
            {
                //左下角的和
                matrixs[i+1][j+1]=matrix[i][j]+matrixs[i][j+1]+matrixs[i+1][j]-matrixs[i][j];
            }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrixs[row2+1][col2+1]-matrixs[row1][col2+1]-matrixs[row2+1][col1]+matrixs[row1][col1];
    }

    @Test
    public void test(){
        int[][] matrix={{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        NumMatrix(matrix);
        sumRegion(2, 1, 4, 3);



    }
}
