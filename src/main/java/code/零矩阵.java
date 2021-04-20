package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 上午10:37
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.xml.internal.txw2.annotation.XmlNamespace;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-18 10:37
 */
public class 零矩阵 {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[] x = new int[m];
        int[] y = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    x[i] =1;
                    y[j] = 1;
                }
            }
        }


        for (int i = 0; i < m; i++) {
            if (x[i] == 1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (y[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }


    }
}
