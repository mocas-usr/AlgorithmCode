package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/27 下午5:01
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-27 17:01
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {

        //特殊情况处理
        if (nums.length==0)
        {
            return -1;
        }
        if (nums.length==1)
        {
            if (target==nums[0])
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }

        int left=0;
        int right=nums.length-1;
        int n= nums.length;
        int mid=0;
        //二分查找
        while (left<=right)
        {

            mid=(left+right)/2;
            if (nums[mid]==target)
            {
                return mid;
            }

            //mid 在左半边
            if (nums[0]<=nums[mid])
            {
                //target在左半边的 0 mid之间
                if (target>=nums[0] &&target<=nums[mid])
                {
                    right=mid-1;
                }
                else //target在mid之后
                {
                    //调整mid
                    left=mid+1;
                }

            }
            else //mid在右半边
            {
                //target在mid n之间
                if (target>=nums[mid] &&target<=nums[n-1])
                {
                    left=mid+1;
                }
                else
                {
                    //调整mid左移动
                    right=mid-1;
                }
            }



        }
        return -1;


    }
    @Test
    public void test()
    {
        int[] nums={4,5,6,7,0,1,2};
        int target=3;

    }
}
