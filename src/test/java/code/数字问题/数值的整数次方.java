package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午10:02
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-14 10:02
 */
public class 数值的整数次方 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long t=n;
        if (n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res=1;
        while (t>0)
        {
            if ((t&1)==1)
            {
                res= res*x;
            }
            t>>=1;
            x=x*x;
        }
        return res;

    }

    @Test
    public void test() {
        myPow(2.0000, -2147483648);
    }
}
