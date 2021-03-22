package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/25 22:09
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-25 22:09
 */
public class 汉明距离    {
    public int hammingDistance(int x, int y) {
        int sum=0;
        sum=x^y;
        int count=0;
        while (sum!=0)
        {
            //如果是奇数
            if ((sum&1)==1)
            {
                count++;
            }
            sum>>=1;
        }
        return count;

    }

    @Test
    public void test()
    {
        int x=1;
        int y=4;
        int res=hammingDistance(1,4);
        System.out.println(res);
    }
}
