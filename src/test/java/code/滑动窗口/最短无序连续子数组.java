package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/17 20:42
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-17 20:42
 */
public class 最短无序连续子数组 {
    //两次遍历
    public int findUnsortedSubarray(int[] nums) {

        int start = 0;
        int end = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        //寻找结束的点
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }

        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                start = i;
            }
        }

        if (end - start > 0) {
            return end - start + 1;
        } else {
            return 0;
        }
    }
}
