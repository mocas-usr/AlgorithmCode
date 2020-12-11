package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 上午10:30
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-07 10:30
 */
public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        while (left<=right)
        {
            int mid=left+(right-left)/2;
            if (target>nums[mid])
            {
                left=mid+1;
            }else if (target<nums[mid])
            {
                right=mid-1;
            }
            else if (target==nums[mid])
            {
                return mid;
            }

        }
        return left;



    }
}
