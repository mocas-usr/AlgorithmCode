package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/14 上午10:11
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-14 10:11
 */
public class 乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }
        int sum = 1;
        int res = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            int right = i;
            sum *= nums[right];

            while (sum >= k) {
                sum/=nums[left];
                left++;
            }
            //[left,right]内，以right结尾的子数组个数
            res += (right - left + 1);
        }
        return res;
    }


}
