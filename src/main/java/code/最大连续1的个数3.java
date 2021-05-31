package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 下午2:59
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-31 14:59
 */
public class 最大连续1的个数3 {

    
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;

        while (right < n) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
