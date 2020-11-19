package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 下午2:56
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 14:56
 */
public class 剪绳子2 {
    //大数取余
    public int cuttingRope(int n) {
        if (n<=3)
        {
            return n-1;
        }
        int a=n/3-1;
        int b=n%3;
        long res=1;
        int p = 1000000007;
        //快速幂实现，实现3的n/3-1次方
        long k=1;
        long t=3;
        while(a>0)
        {
            //如果幂是奇数时
            if ((a&1)==1)
            {
                k=(k*t)%p;
            }
            t=(t*t)%p;//底数不断平方
            a>>=1;//幂不断/2

        }
        if (b==0)
        {
           res=k*3%p;

        }
        if (b==1)
        {
            res= k*4%p;
        }
        if (b==2)
        {
            res= k*3*2%p;
        }
        return (int) res;
    }
}
