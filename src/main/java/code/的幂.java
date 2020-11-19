package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/10 下午3:55
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-10 15:55
 */
public class 的幂 {
    public boolean isPowerOfThree(int n) {
        if (n<=0)
        {
            return false;
        }

        //如果取余为0，则
        while (n%3==0)
        {
            n/=3;
        }
        if (n==1)
        {
            return true;
        }else
        {
            return false;
        }

    }
}
