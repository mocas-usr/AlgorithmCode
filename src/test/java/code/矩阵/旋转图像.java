package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 上午10:26
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-18 10:26
 */
public class 旋转图像 {

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        //左上右下旋转
        for (int i = 0; i < m; i++)
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        //中心线对称
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        return;
    }

    @Test
    public void test()
    {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
