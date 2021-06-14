package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 上午9:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-05 09:23
 */
public class 数字序列中某一位的数字 {

    public int findNthDigit(int n) {
        if (n==0)
        {
            return 0;
        }
        StringBuilder str=new StringBuilder();
        //字符串
        for (int i=0;i<n+1;i++)
        {
            str.append(i);
        }

        char num=str.charAt(n);
        return Integer.valueOf(num);

    }

    public int findNthDigit2(int n) {
       int digit=1;
       long start=1;
       long count=9;//初始化的数值
        //如果大于位数的最大值，即n数值大于90个，则说明是三位数
        while (n>count)
        {
            //此时，n从start开始计数
            n-=count;//代表减去原有位数的个数
            digit=digit+1;//位数增加
            start=start*10;
            //代表几位数的占了多少位，比如两位数占了9*2*10
            count=9*digit*start;

        }
        //结束之后，n变成从start开始n位的数值
        long num=start+(n-1)/digit;//num代表n位所在数值
        int res=Long.toString(num).charAt((n-1)%digit)-'0';
        return res;

    }


    @Test
    public void test()
    {
        int n=3;
        findNthDigit2(11);
    }
}
