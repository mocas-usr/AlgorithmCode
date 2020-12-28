package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/27 下午7:50
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-27 19:50
 */
public class 盛最多水的容器 {

    //双指针
    public int maxArea(int[] height) {
        //s=min（i,j）*(j-i)
        //左右边界
        int i=0;
        int j=height.length-1;
        int s=0;
        int res=0;
        while (i<j)
        {
            s=Math.min(height[i],height[j])*(j-i);//此时面积

            res=Math.max(res,s);

            //边界移动,短板移动
            if (height[i]>height[j])
            {
                j--;
            }else
            {
                i++;
            }
        }
        return res;
    }

    @Test
    public void test()
    {
        int[] height={1,8,6,2,5,4,8,3,7};
        int res=maxArea(height);
    }
}
