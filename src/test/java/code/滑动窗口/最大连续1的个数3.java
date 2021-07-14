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
        int zero = 0;

        int max = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        //保证[left，right]不超过两个0
        while (right < nums.length) {
            if (nums[right] == 0) {
                zero++;
            }
            //当超过两个零时，缩短左边窗口
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }

            //此时right指向0，left指向1，滑动窗口包含两个0
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;

    }
}
