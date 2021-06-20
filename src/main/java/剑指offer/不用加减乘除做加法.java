package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午11:23
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 11:23
 */
public class 不用加减乘除做加法 {
    public int Add(int num1, int num2) {
        int a = num1;
        int b = num2;
        int temp = 0;
        //b用来保存进位
        while (b != 0) {
            temp=a^b;//这是不加进位的结果
            b=(a&b)<<1;//进位
            a=temp;//保存结果
        }
        return a;
    }
}
