package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/30 下午4:21
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-30 16:21
 */
public class 合并排序的数组 {

    public void merge(int[] A, int m, int[] B, int n) {

        int len1 = m - 1;
        int len2 = n - 1;

        int len = m + n - 1;

        while (len1 >= 0 && len2 >= 0) {
            if (A[len1] > B[len2]) {
                A[len--] = A[len1--];
            } else {
                A[len--] = B[len2--];
            }
        }

        while(len2>=0) A[len--]=B[len2--];

    }

    @Test
    public void test() {
        int[] A = {1, 2, 3, 0, 0,0};
        int m = 3;
        int[] B = {2, 5, 6};
        int n = 3;
        merge(A, m, B, n);
        System.out.println(1);
    }
}
