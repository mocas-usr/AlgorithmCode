package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午10:43
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 10:43
 */
public class 二进制中1的个数 {

    public int NumberOf1(int n) {

        int res = 0;

        while (n != 0) {
            n=n&(n-1);
            res++;
        }
        return res;
    }

    @Test
    public void test() {
        int res = NumberOf1(10);
        System.out.println(res);
    }
}
