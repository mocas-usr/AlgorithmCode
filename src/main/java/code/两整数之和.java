package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 上午10:42
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-15 10:42
 */
public class 两整数之和 {

    public int getSum(int a, int b) {
        while (b!=0)
        {
            //没有进位的数值
            int temp=a^b;
            b=(a&b)<<1;
            a=temp;
        }
        return a;

    }
}
