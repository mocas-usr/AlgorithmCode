package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/31 上午9:57
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-31 09:57
 */
public class 二维区域和检索矩阵不可变 {
    int[][] matrixs;
    public void NumMatrix(int[][] matrix) {
        matrixs=matrix;
    }

    //暴力解法

    public int sumRegion2(int row1, int col1, int row2, int col2) {
        int ans=0;
        for (int i=row1;i<=row2;i++)
            for (int j=col1;j<=col2;j++)
            {
                ans+=matrixs[i][j];
            }
        return ans;
    }


    //动态规划
    public int sumRegion(int row1, int col1, int row2, int col2)
    {
        int ans=0;
        if (row1>row2 || col1>col2)
        {
            return ans;
        }else
        {
            ans=ans+matrixs[row1][col1];
            ans=ans+sumRegion(row1+1,col1,row2,col2)+sumRegion(row1,col1+1,row2,col2);
            return ans;
        }

    }

    @Test
    public void test(){
        int[][] matrix={{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        NumMatrix(matrix);
        sumRegion(2, 1, 4, 3);



    }
}
