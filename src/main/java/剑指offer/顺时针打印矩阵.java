package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午4:50
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 16:50
 */
public class 顺时针打印矩阵 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0;
        int right = n - 1;
        int shang = 0;
        int xia = m - 1;

        //上下左右都是没有打印的
        while (true) {
            //从左到右打印
            for (int i = left; i <= right; i++) {
                res.add(matrix[shang][i]);
            }
            //
            if (++shang > xia) {
                break;
            }
            //从上到下
            for (int i = shang; i <= xia; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            //从右往左
            for (int j = right; j >= left; j--) {
                res.add(matrix[xia][j]);
            }
            if (--xia < shang) {
                break;
            }

            //从下往上
            for (int i = xia; i >= shang; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }

        }
        return res;


    }

    @Test
    public void test() {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> res=printMatrix(matrix);
        System.out.println(res);
    }
}
