package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/20 14:38
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-20 14:38
 */
public class 第k大的数 {

    //
    public int findNum(int[] nums, int k) {

        if (k > nums.length) {
            return -1;
        }

        quickSort(nums, 0, nums.length - 1, k-1);
        return nums[k-1];

    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left > right) {
            return;
        }
        int stand = partion(nums, left, right);
        //
        if (stand > k) {
            quickSort(nums, left, stand - 1, k);
        } else if (stand < k) {
            quickSort(nums, stand + 1, right, k);
        } else {
            return;
        }
    }

    public int partion(int[] nums, int left, int right) {
        int index = left;
        int target = nums[index];

        while (left < right) {

            while (left < right && nums[right] <= target) {
                right--;
            }
            while (left < right && nums[left] >= target) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        //left==right
        swap(nums, left, index);
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test()
    {
        int[] nums={1,2,3,4,5,6,7};
        int res=findNum(nums,2);
        System.out.println(res);
    }

}
