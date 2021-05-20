package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/19 下午9:13
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-19 21:13
 */
public class n的第k个因子 {

    public int kthFactor(int n, int k) {
        for (int i=1;i<=n;i++)
        {
            if (n%i==0)
            {
                k--;
            }
            if (k==0)
            {
                return i;
            }
        }
        return -1;
    }
}
