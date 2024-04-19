package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/31 19:25
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-31 19:25
 */
public class 两数交换 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine())
        {
            String[] str=sc.nextLine().trim().split(" ");
            int n=str.length;
            int[] nums=new int[str.length];
            for (int i=0;i<n;i++)
            {
                nums[i]=Integer.parseInt(str[i]);

            }
            int[] res=findnum(nums);
            for (int i=0;i<2;i++)
            {
                System.out.print(res[i]);
                System.out.print(" ");
            }
        }

    }
    public static int[] findnum(int[] nums)
    {
        int len=nums.length;
        int max=nums[0];
        int min=nums[len-1];
        int end=-1;
        int begin=0;
        //遍历
        //从左到右
        for (int i=0;i<len;i++)
        {
            //如果大于max，则更新max，如果后面是有序的，则一直更新max
            if (nums[i]>=max)
            {
                max=nums[i];
            }else if (nums[i]<max)
            {
                begin=i-1;
                break;
            }

        }

        for (int i=nums.length-1;i>=0;i--)
        {
            if(nums[i] > min){    //从右到左维持最小值，寻找左边界begin

                end=i+1;
                break;
            }else{
                min = nums[i];
            }

        }

        return new int[]{begin+1,end+1};
    }
}
