package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/12 下午9:21
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-12 21:21
 */
public class 配对交换 {

    public int exchangeBits(int num) {

        int left=num<<1;
        int right=num>>1;
        int l=2;
        int r=1;
        for (int i=0;i<16;i++)
        {
            int temp=l<<2;
            l |=temp;
            temp=r<<2;
            r|=temp;
        }

        left=left &l;
        right=right &r;
        return left |right;


    }

    @Test
    public void test()
    {
        int res=exchangeBits(2);
        System.out.println(res);
    }
}
