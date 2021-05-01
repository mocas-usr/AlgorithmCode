package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 上午11:03
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-01 11:03
 */
public class 不用加号的加法 {

    public int add(int a, int b) {

        while (b!=0)
        {
            int temp=a^b;//没有进位的和
            b=(a&b)<<1;//进位
            a=temp;
        }
        return a;
    }
}
