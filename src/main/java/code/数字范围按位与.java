package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/13 下午4:39
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-13 16:39
 */
public class 数字范围按位与 {

    public int rangeBitwiseAnd(int left, int right) {

        int m=left;
        int n=right;
        int move=0;
        //寻找公共前缀
        while (m<n)
        {
            m>>=1;
            n>>=1;
            move++;
        }
        int res=m<<move;
        return res;

    }
    @Test
    public void test()
    {
        int res=rangeBitwiseAnd(5,7);
        System.out.println(res);
    }
}
