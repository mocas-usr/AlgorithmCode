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

        int left = 0;
        int right = 0;
        int n = nums.length - 1;
        List<List<Integer>> res = new LinkedList<>();//
        //
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            left = i + 1;
            right = n;
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> ans;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];

                if (total > 0) {
                    right--;
                } else if (total < 0) {
                    left++;

                } else {

                    ans = new LinkedList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    res.add(ans);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //
                    right--;
                    left++;
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
