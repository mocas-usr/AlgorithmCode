package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/31 上午9:25
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-31 09:25
 */
public class 区域和检索数组不可变 {
    int[] arr;
    public void NumArray(int[] nums) {
        int n=nums.length;//数组长度
        if (n==0)
        {
            arr=new int[0];
            return;
        }
        arr=new int[n];
        //赋值
        for (int i=0;i<n;i++)
        {
            arr[i]=nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int n=arr.length;
        if (i<0 || i>=n || j<0 || j>=n ||i>j)
        {
            return 0;
        }
        int sum=0;
        for (int k=i;k<=j;k++)
        {
            sum=sum+arr[k];
        }
        return sum;
    }


    //sum解法
    public int[] sum;
    public void NumArray2(int[] nums) {
        int n=nums.length;
        sum=new int[n+1];
        sum[0]=0;
        for (int i=0;i<n;i++)
        {
            //sum等于之前的数列之和，不包括当前
            sum[i+1]=sum[i]+nums[i];
        }

    }

    public int sumRange2(int i, int j) {

        return sum[j+1]-sum[i];
    }
}
