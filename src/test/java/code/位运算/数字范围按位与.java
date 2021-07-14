package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:16
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 19:16
 */
public class 数字范围按位与 {
    public int rangeBitwiseAnd(int left, int right) {

        //与
        int m=left;
        int n=right;
        //只有后半段不一样
        //求不同的后半段位数
        int num=0;
        while (m<n)
        {
            m>>=1;
            n>>=1;
            num++;
        }
        //此时m==n
        int res=m<<num;
        return res;


    }
}
