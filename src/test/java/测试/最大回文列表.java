package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/11 21:41
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-11 21:41
 */
public class 最大回文列表 {

    public static void main(String args[] )
    {
        // Write your code here
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext())
        {
            int n=sc.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++)
            {
                nums[i]=sc.nextInt();
            }


            int left=0;
            int right=n-1;
            while(left<right)
            {
                if (nums[left]==nums[right])
                {

                    left++;
                    right--;
                }else if(nums[left]<nums[right])
                {
                    left++;
                    nums[left]+=nums[left-1];
                    nums[left-1]=0;

                }else
                {
                    right--;
                    nums[right]+=nums[right+1];
                    nums[right+1]=0;
                }
                int count=0;
                for(int i=0;i<nums.length;i++)
                {
                    if(nums[i]==0)
                    {
                        count++;
                    }
                }

                int index=0;
                int[] ans=new int[nums.length-count];
                for(int i=0;i<nums.length;i++)
                {
                    if(nums[i]!=0)
                    {
                        ans[index++]=nums[i];
                    }

                }

                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i]+" ");
                }


            }
        }
        //git@gitee.com:sand_in_rainy_night/springboot001.git

    }
}
