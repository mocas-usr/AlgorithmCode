package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 上午9:06
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-13 09:06
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


    //分段二分查找
    public int search2(int[] nums, int target)
    {
        //特殊处理
        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }
        //分段二分
        int left=0;
        int right=nums.length-1;
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            if (target==nums[mid])
            {
                return mid;
            }
            //mid在右半边递增上
            if (nums[mid]<nums[right])
            {
                if (target>nums[mid] &&target<=nums[right])
                {
                    //说明目标在左半边递增区间
                    left=mid+1;
                }else
                {
                    right=mid-1;
                }
            }
            else if (nums[mid]>nums[right])//mid在左半边
            {
                //确定在左半边的递增区间
                if (target<nums[mid] &&target>=nums[left])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }else{
                //跳出右边边界
                right--;
            }
        }
        return -1;
    }

    @Test
    public void test()
    {
        int[] nums={4,5,6,7,0,1,2};
        int k=3;
        search2(nums,3);
    }
}
