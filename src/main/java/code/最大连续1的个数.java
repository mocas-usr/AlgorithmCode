package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/12 下午9:07
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-12 21:07
 */
public class 最大连续1的个数 {

    public int findMaxConsecutiveOnes(int[] nums) {

        int left = 0;
        int right = 0;
        int n = nums.length;
        int res = 0;
        while (right < n) {
            if (nums[right] == 1) {
                left++;
            }else
            {
                left=0;
            }
            right++;

            res = Math.max(res, left);
        }


        return res;

    }

    @Test
    public void test() {
        int[] nums={1,1,0,1,1,1};
        int res=findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }
}
