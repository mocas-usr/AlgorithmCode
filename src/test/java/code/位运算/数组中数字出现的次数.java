package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/12 下午2:52
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-12 14:52
 */
public class 数组中数字出现的次数 {

    //位运算
    public int[] singleNumbers(int[] nums) {

        int sum=0;
        //a^b的数值
        for (int num:nums)
        {
            sum^=num;
        }

        //ab不同的位
        int flag=sum&(-sum);

        int a=0;
        int b=0;
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
    public void test() {
        int[] nums = {6, 2, 3, 3};
        int[] res = singleNumbers(nums);
        System.out.println(res);
    }
}
