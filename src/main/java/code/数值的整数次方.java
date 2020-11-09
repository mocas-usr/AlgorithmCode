package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 上午10:13
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-05 10:13
 */
public class 数值的整数次方 {
    //非递归，快速幂
    public double myPow1(double x, int n) {
       if (x==0)
       {
           return 0;
       }
        if (n==0)
       {
           return 1;
       }
        //转换数值范围
        long b=n;
        //处理小于0情况，是取倒数
        if (b<0)
        {
            //实现倒数
            b=-b;
            x=1/x;
        }
        double res=1.0;
        //遍历
        while (b>0)
        {
            //如果b是奇数，必须加括号
            if ((b&1)==1)
            {
                //在幂相乘的时候，加上一个x
                res=res*x;
            }
            //不停的降幂，升x，最终幂会降到1,0，
            x=x*x;
            b=b>>1;//整数/2

        }
        return res;

    }

    //递归实现快速幂
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n==-1)
        {
            return 1/x;
        }
        double res=1.0;
        //递归
        if ((n&1)==1)
        {
            //如果是个奇数
            res= x*myPow(x*x,n>>1);
        }else
        {
            res= myPow(x*x,n>>1);
        }
        return res;

    }

    @Test
    public void test(){
        myPow(2.00,-2);
    }

}
