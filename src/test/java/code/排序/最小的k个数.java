package code.排序;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 下午6:12
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-05 18:12
 */
public class 最小的k个数 {
    //快速排序
    public int[] getLeastNumbers(int[] arr, int k) {

        quickSort(arr,0,arr.length-1,k);
        int[] res=new int[k];
        for (int i=0;i<k;i++)
        {
            res[i]=arr[i];
        }
        return res;

    }

    public void quickSort(int[] nums,int left,int right,int key)
    {
        if (left>right)
        {
            return;
        }
        int stand=partion(nums,left,right);
        if (stand==key)
        {
            return;
        }
        quickSort(nums,left,stand-1,key);
        quickSort(nums,stand+1,right,key);

    }
    public int partion(int[] nums,int left,int right)
    {
        int index=left;
        int target=nums[left];

        while (left<right)
        {
            while (left<right&&nums[right]>=target)
            {
                right--;
            }
            while (left<right&&nums[left]<=target)
            {
                left++;
            }
            if (left<right)
            {
                swap(nums,left,right);
            }
        }
        swap(nums,left,index);
        return left;

    }

    //交换
    public void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
