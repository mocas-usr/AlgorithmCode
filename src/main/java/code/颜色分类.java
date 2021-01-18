package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/11 11:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-11 11:04
 */
public class 颜色分类 {
    public void sortColors2(int[] nums) {

        int[] count=new int[3];
        int zero=0;
        int one=0;
        int two=0;

        //计数
        for (int num:nums)
        {
            if (num==0)
            {
                zero++;
            }else if (num==1)
            {
                one++;
            }else if (num==2)
            {
                two++;
            }

        }

        for (int i=0;i<nums.length;i++)
        {
            if (zero!=0)
            {
                nums[i]=0;
                zero--;
            }else if (one!=0)
            {
                nums[i]=1;
                one--;
            }else
            {
                nums[i]=2;
            }
        }
        return;




    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len=nums.length;
        //左右查询起点,left表示0的排布，表示
        int left=0;
        int right=len-1;
        int i=left;
        //只要排好前两个数就行
        while (i<=right)
        {
            if (nums[i]==1)
            {
                //往右走，不变，left不变
                i++;
            }else if (nums[i]==0)
            {
                //等于0，要把数值部署到left位置
                swap(nums,i,left);
                //这里是因为left一定不大于i，所以i++
                left++;
               i++;
            }else if (nums[i]==2)
            {
                swap(nums,i,right);
                right--;
            }
        }



    }

    //交换
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }


    @Test
    public void test()
    {
        int[] nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(1);
    }
}
