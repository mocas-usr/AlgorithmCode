package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/21 下午3:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-21 15:18
 */
public class 旋转数组 {
    //暴力解法
    public void rotate(int[] nums, int k) {

        //旋转k次
        for(int i=0;i<k;i++)
        {
            //每次旋转的结果,从高位旋转
            int pre=nums[nums.length-1];
            for (int j=0;j<nums.length;j++)
            {
                //交换七次，完成一次旋转
                int temp=nums[j];
                nums[j]=pre;
                pre=temp;
            }
        }

    }

    //使用额外的数组
    public void rotate2(int[] nums, int k)
    {
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
        {
            res[(i+k)%n]=nums[i];
        }
        for (int i=0;i<n;i++)
        {
            nums[i]=res[i];
        }

    }

    //使用反转
    public void rotate3(int[] nums, int k)
    {
        k %= nums.length;
        int n=nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }
    public void reverse(int[] nums,int i,int j)
    {
        //反转
        while (i<j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            j--;
            i++;
        }
    }





    @Test
    public void test()
    {
        int[] nums={1,2,3,4,5,6,7};
        int  k = 3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
