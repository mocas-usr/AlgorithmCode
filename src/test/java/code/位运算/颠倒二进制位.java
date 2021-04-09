package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午9:52
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-14 09:52
 */
public class 颠倒二进制位 {
    public int reverseBits(int n) {
        int res = 0;

        //如果末位是1
        for (int i = 0; i < 32; i++) {
            res = res << 1;
            //末位加1
            int t=n & 1;
            res = res | t;
            n>>=1;


        }
        return res;

    }

    public int reverseBits2(int n)
    {
        int res=0;

        for (int i=0;i<32;i++)
        {
            int t=0;
            if ((n&1)==1)
            {
                t=1<<(31-i);
            }

            res=res|t;
            n>>=1;

        }
        return res;
    }

}
