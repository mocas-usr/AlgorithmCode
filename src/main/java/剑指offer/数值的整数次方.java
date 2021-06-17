package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午10:51
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 10:51
 */
public class 数值的整数次方 {

    public double Power(double base, int exponent) {

        int t = exponent;
        double x = base;
        if (exponent < 0) {
            t = -exponent;
            x = 1 / x;
        }
        //求x的t次方
        double res = 1;

        while (t != 0) {
            if ((t & 1) == 1) {
                res *= x;
            }
            t >>= 1;
            x *= x;
        }
        return res;
    }

    @Test
    public void test() {
        double base = 2.0;
        int exponent = 3;
        double res = Power(base, exponent);
        System.out.println(res);
    }
}
