package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/16 上午10:33
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-16 10:33
 */
public class 消失的两个数字 {


    public int[] missingTwo(int[] nums) {

        int n = nums.length + 2;
        int sum = 0;
        //不缺少的情况下的和
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }
        //得到a^b的数值
        for (int num:nums)
        {
            sum^=num;
        }
        //得到a^b的不同位
        int flag=sum&(-sum);
        //分类相异或
        int a=0;
        int b=0;
        for (int i=1;i<=n;i++)
        {
            if ((i&flag)!=0)
            {
                a^=i;
            }else
            {
                b^=i;
            }
        }

        for (int num:nums)
        {
            if ((num&flag)!=0)
            {
                a^=num;
            }else
            {
                b^=num;
            }
        }

        return new int[]{a,b};


    }

    @Test
    public void test()
    {
        int[] nums={1};
        int[] res=missingTwo(nums);
        System.out.println(res);
    }
}
