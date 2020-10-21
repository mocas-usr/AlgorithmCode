package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/13 上午8:54
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-13 08:54
 */
/*
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
*/

public class solution3 {

    public int removeDuplicates(int[] nums) {
        //排除空元素
        if (nums.length == 0) {
            return 0;
        }
        //双指针
        int i = 0;
        //数组保持在nums
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                //往后移动，保存数组
                i++;
                nums[i] = nums[j];
            } else //如果相等，默认已经存储，无需改变
            {

            }
        }

        return i + 1;
    }

    @Test
    public void test() {
        int[] nums = {2, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int t = removeDuplicates(nums);
        System.out.println(t);
    }
}
