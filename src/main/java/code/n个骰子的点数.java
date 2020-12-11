package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/9 下午9:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-09 21:17
 */
public class n个骰子的点数 {

    public double[] dicesProbability(int n) {
        //初始化第一个筛子
        double[] pre=new double[]{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        //代表多少个筛子，进行动态规划
        for (int i=2;i<=n;i++)
        {
            //共有5*i+1的概率数值
            double[] tmp=new double[5*i+1];
            //分成n-1与1个筛子
            for (int j=0;j<pre.length;j++)
            {
                //从0开始，代表最小数值，其实意义是1
                for (int k=0;k<6;k++)
                {
                    tmp[j+k]+=pre[j]/6;
                }
            }
            //对象指针转移
            pre=tmp;
        }

        return pre;
    }


    @Test
    public void test()
    {

    }
}
