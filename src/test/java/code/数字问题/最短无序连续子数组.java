package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/27 下午9:03
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-27 21:03
 */
public class 最短无序连续子数组 {
    //两次遍历
    public int findUnsortedSubarray(int[] nums) {

        int end = -1;
        int begin = 0;
        int max = nums[0];
        int min = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            //应该是一直上升的
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                end = i;
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                begin = i;
            }
        }

        if (end > begin) {
            return end - begin + 1;
        } else {
            return 0;
        }
    }
}
