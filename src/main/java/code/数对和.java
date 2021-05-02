package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午3:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 15:27
 */
public class 数对和 {
    public List<List<Integer>> pairSums(int[] nums, int target) {

        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] == target) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                res.add(list);
                left++;
                right--;
            }
        }
        return res;

    }

    @Test
    public void test() {
        int[] nums = {5, 6, 5};
        int target = 11;
        List<List<Integer>> res = pairSums(nums, target);
        System.out.println(res);
    }
}
