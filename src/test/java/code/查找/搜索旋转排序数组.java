package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 上午9:06
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-13 09:06
 */
public class 搜索旋转排序数组 {
    //空间复杂度o(1),时间复杂度o（n）
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }
        //
        int index = 0;
        //寻找转折点
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                index = i;
            }
        }
        //找到分界数值
        int max = nums[index];
        int min = nums[index + 1];
        if (target <= max && target >= nums[0]) {
            return searchBinary(nums, 0, index, target);
        } else if (target >= min && target <= nums[nums.length - 1]) {
            return searchBinary(nums, index + 1, nums.length - 1, target);
        } else {
            return -1;
        }

    }

    //二分查找
    public int searchBinary(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                return mid;
            }
        }
        return -1;
    }

    //分段二分
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //mid在左半边,right在右半边
            if (nums[mid] > nums[right]) {
                //[left,mid]是有序的
                if (target >= nums[left] && nums[mid] > target) {
                    right = mid - 1;
                } else //[mid,right]是无序的
                {
                    left = mid + 1;
                }


            } else if (nums[mid] < nums[right]) {
                //[mid,right]是有序的
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else //[left,mid]不一定是有序的
                {
                    right = mid - 1;
                }

            } else {
                right--;
            }
        }
        return -1;

    }

    //
    public int search3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //在左半边上
            if (target >= nums[0]) {
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            //经过以上。则保持nums[mid]<nums[right]
            if (target < nums[mid]) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int k = 0;
        int res = search2(nums, 0);
        System.out.println(res);
    }
}
