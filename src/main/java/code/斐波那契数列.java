package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午3:10
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-04 15:10
 */
public class 斐波那契数列 {
    public int fib(int n) {
        if (n==0)
        {
            return 0;
        }
        if (n==1)
        {
            return 1;
        }
        int p=0;
        int q=1;
        int r=1;
        for (int i=1;i<n;i++)
        {
            r=(p+q)%1000000007;
            p=q;
            q=r;

        }
        return r;

    }
}
