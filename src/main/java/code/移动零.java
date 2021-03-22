package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/20 21:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-20 21:39
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }

        int left = 0;
        int right = 0;

        //双指针
        while (right<nums.length)
        {
            if (nums[right]!=0)
            {
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        //第二遍
        for (int i=left;i<nums.length;i++)
        {
            nums[i]=0;
        }

    }
}
