package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/23 下午8:47
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-23 20:47
 */
public class 寻找两个正序数组的中位数 {
    //双指针
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int len=nums1.length+nums2.length;
        double total=0;
        int cur=1;//现在处于第几个数
        double temp=0;
        //双指针
        while (cur<=len/2+1)
        {
            //如果j走完，或者s1<s2;temp为其中的小数
            if (  j==nums2.length || (i<nums1.length && nums1[i]<nums2[j]))
            {
                temp=nums1[i];
                i++;

            }else
            {
                temp=nums2[j];
                j++;

            }
            //如果是偶数
            if (len%2==0)
            {
                if (cur==len/2 || cur==len/2+1)
                {
                    temp=temp/2;
                    total+=temp;
                }
            }
            else
            {
                if (cur==len/2+1)
                total=temp;
            }


            cur++;

        }
        return total;
    }

    @Test
    public void test()
    {
        int[] nums1 ={0,0};
        int[] nums2={0,0};
        double res=findMedianSortedArrays(nums1,nums2);
        System.out.println(res);

    }
}
