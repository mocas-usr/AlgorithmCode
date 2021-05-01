package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/13 下午3:41
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-13 15:41
 */
public class 丢失的数字 {

    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum = 0;
        for (int num : nums) {
        sum+=num;
        }
        int temp=(n+1)*n/2;
        int res=temp-sum;
        return res;
    }

    @Test
    public void test()
    {
        int[] nums={0,1,3};

        int res=missingNumber(nums);
        System.out.println(res);
    }
}
