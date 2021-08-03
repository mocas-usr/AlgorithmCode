package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 上午11:02
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-07 11:02
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {


    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }


        int res = -1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        int leftIndex = 0;
        if (res != -1) {
            leftIndex = res;
        } else {
            return new int[]{-1, -1};
        }
        int rightIndex = leftIndex;

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }

        return new int[]{leftIndex, res};

    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(res);
    }

}
