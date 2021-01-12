package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/10 19:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-10 19:29
 */
public class 接雨水 {

    //按列求
    public int trap2(int[] height) {
        int sum=0;

        //两端不考虑，只考虑中间每一列积累的多少水
        //i代表列
        for (int i=1;i<height.length-1;i++)
        {

            int maxLeft=0;//左边最高
            for (int j=i-1;j>=0;j--)
            {
                maxLeft= Math.max(maxLeft,height[j]);

            }
            int maxRight=0;
            for (int j=i+1;j<height.length;j++)
            {
                maxRight=Math.max(maxRight,height[j]);
            }
            //判断此列与两边的关系
            int rowHeight=Math.min(maxLeft,maxRight);//较小的高度
            //如果此列的高度<较小的情况下，才有水
            if (height[i]<rowHeight)
            {
                sum+=rowHeight-height[i];
            }


        }
        return sum;

    }

    //动态规划
    public int trap3(int[] height)
    {
        //
        int sum=0;
        int len=height.length;
        int[] maxLeft=new int[height.length];
        int[] maxRight=new int[height.length];

        //maxleft[i]代表左边最高
        //左边最高就等于前一个左边最高与左边数值的较大值
        for (int j=1;j<len;j++)
        {
            maxLeft[j]=Math.max(height[j-1],maxLeft[j-1]);
        }
        //右边最高就等于右边一个最高与右边数值的较大值比较
        for (int j=len-2;j>=0;j--)
        {
            maxRight[j]=Math.max(height[j+1],maxRight[j+1]);
        }

        for (int i=1;i<len-1;i++)
        {
            int heigh=Math.min(maxLeft[i],maxRight[i]);
            if (height[i]<heigh)
            {
                sum+=heigh-height[i];
            }

        }
        return sum;
    }

    //短板效应，双指针
    public int trap(int[] height) {
        int len=height.length;
        int left=1;
        int right=len-2;
        int maxLeft=0;
        int maxRight=0;
        int sum=0;
        int min=0;
        for (int i=1;i<len-1;i++)
        {
            //如果左短板
            if (height[left-1]<height[right+1])
            {
                //这个时候left位置的maxleft<maxright
                maxLeft=Math.max(maxLeft,height[left-1]);
                min=maxLeft;
                if (min>height[left])
                {
                    sum+=maxLeft-height[left];
                }

                left++;
            }else //右短板
            {
                maxRight=Math.max(maxRight,height[right+1]);
                min=maxRight;
                if (min>height[right])
                {
                    sum+=maxRight-height[right];
                }

                right--;
            }
        }


        return sum;
    }


    @Test
    public void test()
    {
        int[] nums={0,1,0,2,1,0,1,3,2,1,2,1};
        int sum=trap(nums);
        System.out.println(sum);
    }
}
