package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/8 18:20
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-08 18:20
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;//多少行

        //n*n的矩阵，最后一行不要翻转
        //左上右下
        for (int i=0;i<n-1;i++)
        {
            for (int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //中心翻转
        int mid=n>>1;//中点
        for (int i=0;i<n;i++)
            for (int j=0;j<mid;j++)
            {
                //每行中心交换
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=temp;
            }

        return;

    }


}
