package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午9:42
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 09:42
 */
public class 二进制中1的个数 {
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0)
        {
            //如果末尾与1是1
            if ((n&1)==1)
            {
                count++;
            }
            n>>>=1;

        }
        return count;

    }

    @Test
    public void test()
    {

    }
}
