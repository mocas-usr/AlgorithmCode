package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/13 上午9:16
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-13 09:16
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {

        //二分查找，左右边界
        int left = 0;
        int right = nums.length - 1;

        while (left <= right)//循环终止条件
        {
            int mid = (right - left) / 2 + left;
            if (target > nums[mid])//大于中间值
            {
                left = mid + 1;

            } else {
//                left=left+1;
                right = mid - 1;
            }

        }
        return left;

    }

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        int t = 5;
        int s = searchInsert(nums, 5);
        System.out.println(s);

    }
}
