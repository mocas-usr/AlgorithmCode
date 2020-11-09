package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 上午10:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-07 10:23
 */
public class 中缺失的数字 {
    //二分查找
    public int missingNumber(int[] nums) {

        int num=search(nums,0,nums.length-1);
        return num;
    }

    public int search(int[] nums,int left,int right)
    {
        if (left>right)
        {
            return -1;
        }

        while (left<=right)
        {
            int mid=left+(right-left)/2;
            //正常情况下nums[mid]=mid,此时说明0 mid正常
            if (nums[mid]==mid)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }

        return right+1;
    }

    @Test
    public void test()
    {
        int[] nums={0,1,2,3,4,5,6,7,9};
        missingNumber(nums);
    }
}
