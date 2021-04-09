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

    //二分逼近
    public int[] searchRange(int[] nums, int target) {
        //
        int left = 0;
        int right = nums.length - 1;
        int leftIndex = -1;
        int rightIndex = -1;
        boolean flag = false;
        int mid = 0;
        //左边界
        while (left <= right) {
            //二分
            mid = left + (right - left) / 2;
            //先找左边界
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                flag = true;
                right = mid - 1;
            }

        }
        if (!flag) {
            return new int[]{-1, -1};
        } else {
            leftIndex = left;
        }

        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            //二分
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {

                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = left + 1;
            }

        }
        rightIndex = right;
        return new int[]{leftIndex, rightIndex};
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res=searchRange(nums, target);
        System.out.println(res);
    }

}
