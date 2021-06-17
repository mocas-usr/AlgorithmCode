package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午10:21
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-15 10:21
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {

        if (n==0)
        {
            return 0;
        }
        if (n==1)
        {
            return 1;
        }

        int num=Fibonacci(n-1)+Fibonacci(n-2);
        return num;
    }
}
