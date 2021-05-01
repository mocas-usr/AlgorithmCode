package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午8:34
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 20:34
 */
public class 搜索二维矩阵2 {

    //标志位法
    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0;
        int j = matrix[0].length-1;

        while (i<matrix.length && j >=0) {
            if (matrix[i][j]>target)
            {
                j--;
            }else if (matrix[i][j]<target)
            {
                i++;
            }else if (matrix[i][j]==target)
            {
                return true;
            }
        }
        return false;
    }
}
