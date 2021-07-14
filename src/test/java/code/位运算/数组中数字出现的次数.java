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

        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }

        int x = 1;
        while ((sum & x) == 0) {
            x <<= 1;
        }
        //x可以作为分界

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & x) !=0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        return new int[]{num1, num2};

    }

    @Test
    public void test() {
        int[] nums = {6, 2, 3, 3};
        int[] res = singleNumbers(nums);
        System.out.println(res);
    }
}
