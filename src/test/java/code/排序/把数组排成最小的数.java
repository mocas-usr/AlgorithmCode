package code.排序;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 下午6:11
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-05 18:11
 */
public class 把数组排成最小的数 {


    public String minNumber(int[] nums) {

        if (nums.length == 0) {
            return "";
        }

        quickSort(nums, 0, nums.length - 1);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(String.valueOf(num));
        }
        return sb.toString();

    }

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        int stand = partion(nums, left, right);
        quickSort(nums, left, stand - 1);
        quickSort(nums, stand + 1, right);
    }

    public int partion(int[] nums, int left, int right) {

        int index = left;
        int target = nums[left];

        while (left < right) {
            while (left < right && comparNum(target, nums[right]) <= 0) {
                right--;
            }

            while (left < right && comparNum(target, nums[left]) >= 0) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }

        //
        swap(nums, left, index);
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int comparNum(int num1, int num2) {
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);
        return (s1 + s2).compareTo(s2 + s1);

    }

    @Test
    public void test() {
        int[] nums = {3, 30, 34, 5, 9};
        String res = minNumber(nums);
        System.out.println(res);
    }
}
