package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/10 下午7:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-10 19:29
 */
public class 螺旋矩阵 {


    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;//行数
        if (row == 0) {
            return new LinkedList<>();
        }
        int col = matrix[0].length;//列数
        List<Integer> res = new LinkedList<>();

        int left = 0, right = col - 1, top = 0, bottom = row - 1;

        while (true) {
            //从左到右打印
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom) {
                break;
            }
            //从上到下打印
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            //从右向左打印
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top) {
                break;
            }
            //从下到上打印
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left>right)
            {
                break;
            }
        }
        return res;

    }

    @Test
    public void test()
    {
        int[][] arrs={ {1,2,3},{4,5,6}};
        List<Integer> res=spiralOrder(arrs);
        System.out.println(res);
    }


}
