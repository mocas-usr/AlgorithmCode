package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/12 下午8:56
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-12 20:56
 */
public class 插入 {
    public int insertBits(int N, int M, int i, int j) {
        int mask = -1 >>> (31 - j) >>> i << i;// 运算结果为 ...000000111111100...
        return N & ~mask | (M << i);

    }
}
