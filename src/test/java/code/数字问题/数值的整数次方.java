package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午10:02
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 10:02
 */
public class 数值的整数次方 {
    public double myPow(double x, int n) {
        if(x==0)
        {
            return 0;
        }
        if (n==0)
        {
            return 1;
        }
        double res=1;
        //避免达到最大值
        long t=n;
        if (n<0)
        {
            x=1/x;
            t=-t;
        }

        while (t>0)
        {
            if (t%2==1)
            {
                res=res*x;
            }
            t>>=1;//不停/2
            x=x*x;
        }
        return res;


    }

    @Test
    public void test()
    {
        myPow(2.0000,-2147483648);
    }
}
