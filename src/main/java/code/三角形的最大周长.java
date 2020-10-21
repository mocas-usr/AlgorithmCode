package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/13 上午10:40
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-13 10:40
 */
/*给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

        如果不能形成任何面积不为零的三角形，返回 0。*/
public class 三角形的最大周长 {
    public int largestPerimeter(int[] A) {
        //自带库排序，从小到大
        Arrays.sort(A);

        //循环遍历
        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] + A[i + 1] > A[i + 2])//排序过后必须是滑动窗口进行，可以证明
            {
                int sum = A[i] + A[i + 1] + A[i + 2];
                return sum;
            }
        }
        //如果没组成，则返回0
        return 0;


    }
}
