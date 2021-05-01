package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/19 下午8:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-19 20:27
 */
public class 下一个数 {
    public int[] findClosedNumbers(int num) {


        int num1=num<<1;
        int num2=num>>1;
        if (num1>2147483647)
        {
            num1=-1;
        }
        if (num2<1)
        {
            num2=-1;
        }
        return new int[]{num1,num2};

    }

    @Test
    public void test()
    {
        int num=1;
        int[] res=findClosedNumbers(num);
        System.out.println(res);
    }
}
