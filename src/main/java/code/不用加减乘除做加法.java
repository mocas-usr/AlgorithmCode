package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/10 下午3:47
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-10 15:47
 */
public class 不用加减乘除做加法 {

    public int add(int a, int b) {
        //如果进位不为0
        while (b!=0)
        {
            //
            int sum=a^b;//不进位的数值
            b=(a&b)<<1;//进位的数值
            a=sum;

        }
        return a;


    }
}
