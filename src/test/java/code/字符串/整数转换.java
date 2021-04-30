package code.字符串;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 下午5:16
 * @email: wangyuhang_mocas@163.com
 */

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 17:16
 */
public class 整数转换 {
    public int convertInteger(int A, int B) {

        int sum=0;
        sum=A^B;
        int res=0;
        while (sum!=0)
        {
            if ((sum&1)==1)
            {
                res++;
            }
            sum>>=1;
        }
        return res;

    }
}
