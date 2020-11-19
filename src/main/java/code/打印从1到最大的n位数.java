package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 下午2:33
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 14:33
 */
public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        if (n==0)
        {
            return new int[0];
        }
        int index=1;
        int i=0;
        while (i<n)
        {
            index*=10;
            i++;
        }
        int[] result=new int[index-1];
        for (int j=0;j<index-1;j++)
        {
            result[j]=j+1;
        }

        return result;


    }

    @Test
    public void test()
    {
        int n=1;
        printNumbers(n);
    }
}
