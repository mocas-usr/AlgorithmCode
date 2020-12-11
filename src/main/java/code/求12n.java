package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/10 下午3:25
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-10 15:25
 */
public class 求12n {
    public int sumNums2(int n) {
        int sum=0;
        sum=SumNum(n);
        return sum;
    }

    public int SumNum(int num)
    {
        if (num==1)
        {
            return 1;
        }
        int sum=num+SumNum(num-1);
        return sum;
    }

    public int sumNums(int n)
    {
        int sum=n;
        Boolean flag=(n>0) &&(sum+=sumNums(n-1))>0;
        return sum;
    }

    @Test
    public void test()
    {
        sumNums(3);
    }
}
