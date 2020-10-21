package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/20 下午2:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-20 14:46
 */
public class 爬楼梯 {
    //fx=fx-1+fx-2
    public int climbStairs(int n) {
        if (n==0)
        {
            return 0;
        }
        //初始化
        int x0=0;
        int x1=1;
        int x2=1;
        int step=0;

        for (int i=1;i<=n;i++)
        {
            x2=x1+x0;//n阶的步数
            x0=x1;
            x1=x2;



        }
        return x2;

    }

    @Test
    public void test()
    {
        int n=3;
        int res=climbStairs(3);
        System.out.println(res);
    }
}
