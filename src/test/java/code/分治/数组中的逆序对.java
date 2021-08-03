package code.分治;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 下午4:42
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-08 16:42
 */
public class 数组中的逆序对 {

    int count = 0;

    public int reversePairs(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        merge(nums,0,nums.length-1);
        return count;

    }

    public void merge(int[] nums,int left,int right)
    {
        //终止条件
        if (left>=right)
        {
            return;
        }
        int mid=left+(right-left)/2;
        //下一路径，分
        merge(nums,left,mid);
        merge(nums,mid+1,right);
        //当前操作，治
        //上面两个数组合并
        mergeSort(nums,left,mid,right);



    }

    public void mergeSort(int[] nums,int left,int mid,int right)
    {
        //合并两个数组
        int a=left;
        int b=mid+1;

        int[] temp=new int[right-left+1];
        int index=0;

        while (a<=mid && b<=right)
        {
            if (nums[a]<=nums[b])
            {
                temp[index++]=nums[a++];
            }else
            {
                count+=mid-a+1;
                temp[index++]=nums[b++];
            }

        }

        while (a<=mid)
        {
            temp[index++]=nums[a++];
        }
        while (b<=right)
        {
            temp[index++]=nums[b++];
        }
        for (int i=left;i<=right;i++)
        {
            nums[i]=temp[i-left];
        }

    }

    @Test
    public void test() {
        int[] nums = new int[]{7, 5, 6, 4};
        int res = reversePairs(nums);
        System.out.println(res);

    }
}
