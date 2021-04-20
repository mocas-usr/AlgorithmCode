package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 下午6:47
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-18 18:47
 */
public class 递归乘法 {
    public int multiply(int A, int B) {
        //终止条件
        if (B==1)
        {
            return A;
        }

        //剪枝
        //for 循环列表
        //当前选择
        // 下一路径
        int sum=multiply(A,B-1);
        sum=sum+A;
        return sum;


        //恢复现场

    }

    @Test
    public void test()
    {
        int A = 1;
        int B = 10;
        int res=multiply(A,B);
        System.out.println(res);
    }
}
