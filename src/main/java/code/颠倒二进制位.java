package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/21 下午4:45
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-21 16:45
 */
public class 颠倒二进制位 {
    // you need treat n as an unsigned value
    //取模求和
    //n是整数，不是二进制数
    public int reverseBits(int n) {
        //复制数值
        int res=0;
        //循环移动32位
        for (int i=0;i<32;i++)
        {
            //最后一位是最重要的，而本质是最后一位移动32次，就是最终位置
            res=(n&1)+res<<1;//res左移动一位，加上原本的最后一位
            n=n>>1;//
        }
        return res;
    }

    //按位翻转
    public int reverseBits2(int n)
    {
        int res=0;//存储结果
        int temp=0;

        //实现了如果i位是1，则31-i位是1
        for (int i=0;i<32;i++)
        {
            //如果第i位是0
            if ((n&(1<<i))==0)
            {
                temp=0;
            }
            else
            {
                temp=1<<(31-i);
            }
            //0 | 0是0,0|1是1，
            res=res|temp;
        }
        return res;
    }

    @Test
    public void test()
    {
        int n=43261596;
        int res=reverseBits(n);
        System.out.println(res);
    }
}
