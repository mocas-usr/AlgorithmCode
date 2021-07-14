package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午3:31
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 15:31
 */
public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[2];
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }

        }
        return new int[2];
    }
}
