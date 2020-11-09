package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 下午3:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import javax.print.attribute.standard.NumberUp;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-05 15:46
 */
public class 把数组排成最小的数 {

    public String minNumber(int[] nums) {
        //存储数值
        StringBuilder res=new StringBuilder();
        String[] str=new String[nums.length];
        //快速排序
        quickSort(nums,0,nums.length-1);
        for (int i=0;i<nums.length;i++)
        {
            res.append(nums[i]);
        }

        return res.toString();



    }

    public void quickSort(int[] nums,int left,int right)
    {
        if (left>right)
        {
            return;
        }
        //取标准位
        int stand =partion(nums,left,right);
        quickSort(nums,left,stand-1);
        quickSort(nums,stand+1,right);

    }

    public int partion(int[] nums,int left,int right)
    {
        int k=left;
        if (left>right)
        {
            return -1;
        }
        int temp=nums[left];//定位key
        while (left<right)
        {

            while (left<right && compareNum(nums[right],temp)>=0)
            {

                right--;
            }
            while (left<right && compareNum(nums[left],temp)<=0)
            {
                left++;
            }
            if (left<right)
            {
                swap(nums,left,right);
            }

        }
        //结束之后l=r
        swap(nums,left,k);
        return left;
    }



    public void  swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //比较规则
    public int compareNum(int num1,int num2)
    {
        String str1=String.valueOf(num1);
        String str2=String.valueOf(num2);
        return (str1+str2).compareTo(str2+str1);

    }

    //冒泡排序
    public String minNumber2(int[] nums)
    {
        bubbleSort(nums);
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<nums.length;i++)
        {
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }

    //冒泡排序
    public void bubbleSort(int[] nums)
    {
        //外循环控制循环多少次,每排一次确定一个最大数
        for (int i=0;i<nums.length;i++)
        {
            //内循环控制每一趟排序
            for (int j=0;j<nums.length-1-i;j++)
            {
                if (compareNum(nums[j],nums[j+1])>0)
                {
                    swap(nums,j,j+1);
                }

            }
        }

    }

    //插入排序
    public String minNumber3(int[] nums)
    {
        //
        InsertSort(nums);
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<nums.length;i++)
        {
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }

    //插入排序
    public void InsertSort(int[] nums)
    {
        //// 从数组的第二个元素开始循环将数组中的元素选择插入
        for (int i=1;i<nums.length;i++)
        {
            int temp=nums[i];//要选择插入的数值
            int j=i-1;//开始搜寻起点
            while (j>=0 &&compareNum(temp,nums[j])<0)//如果temp<nums[j],则第j个元素一直向后移
            {
                nums[j+1]=nums[j];
                j--;
            }
            //跳出循环时，temp找到位置，就在j+1这个位置
            nums[j+1]=temp;
        }
    }

    @Test
    public void test()
    {
        int[] nums={3,30,34,5,9};
        int res=compareNum(3,30);
        minNumber(nums);
    }
}
