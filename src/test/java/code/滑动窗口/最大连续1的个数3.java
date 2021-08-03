package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 下午3:47
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-31 15:47
 */
public class 最大连续1的个数3 {


    public int longestOnes(int[] nums, int k) {

        int zeros = 0;
        int left = 0;
        int right = 0;

        int res = 0;
        while (right < nums.length) {
            //扩增窗口
            if (nums[right]==0)
            {
                zeros++;
            }
            //缩减窗口
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            //当前选择
            res = Math.max(res, right - left + 1);
            right++;

        }
        return res;
    }
}
