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

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        boolean flag = false;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid +1;
            } else {
                flag=true;
                right--;
            }
        }
        int leftIndex=-1;
        if (flag)
        {
            leftIndex=left;
        }else
        {
            return new int[]{-1,-1};
        }

        left=0;
        right=n-1;
        while (left<=right)
        {
            mid=left+(right-left)/2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left++;
            }
        }
        int rightIndex=right;
        return new int[]{leftIndex,rightIndex};

    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(res);
    }

}
