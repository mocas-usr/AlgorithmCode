package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/27 下午9:02
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
 * @create: 2020-12-27 21:02
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length == 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();


        Arrays.sort(nums);

        int n = nums.length;
        //去重是重点
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = n - 1;
            //已经以这个为起点计算过了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);

                    res.add(new LinkedList<>(list));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }


        }
        return res;


    }

    @Test
    public void test() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res);
    }
}
