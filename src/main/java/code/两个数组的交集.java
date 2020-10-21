package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/20 上午9:40
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-20 09:40
 */
public class 两个数组的交集 {
    //Set
    public int[] intersection(int[] nums1, int[] nums2) {
        //考虑为空
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //创建set
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        //先将num1赋值
        for (int num:nums1)
        {
            set1.add(num);
        }
        //之后遍历nums2，赋值结果set
        for (int num:nums2)
        {
            if (set1.contains(num))
            {
                set2.add(num);
            }
        }
        //间接转数组
        int[] arr=new int[set2.size()];
        int index=0;
        for (int val:set2)
        {
            //不断赋值
            arr[index++]=val;
        }

        return arr;



    }

    //双指针
    public int[] intersection2(int[] nums1, int[] nums2)
    {
        //考虑为空
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1=0;
        int l2=0;
        //初始化方便
        HashSet<Integer> setArr=new HashSet();
        //l1
        while(l1<nums1.length && l2<nums2.length)//
        {
            //如果相等
            if (nums1[l1]==nums2[l2])
            {
                //
                setArr.add(nums1[l1]);
                l1++;
                l2++;
            }
            //从小到大遍历两个数组
            else if (nums1[l1]<nums2[l2])
            {
                //左边指针移动
                l1++;

            }
            else
            {
                l2++;
            }
        }
        //将set转换成数组
        int[] result=new int[setArr.size()];
        int index=0;
        for (int val:setArr)
        {
            //赋值
            result[index++]=val;
        }
        return result;
    }

    //二分查找方法
    public int[] intersection3(int[] nums1, int[] nums2)
    {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int target:nums1)
        {
            //判断是否能在nums2找到target
            if(binarySort(nums2,target))//
            {
                set.add(target);
            }
        }
        //将set转换成数组
        int[] result=new int[set.size()];
        int index=0;
        for (int val:set)
        {
            //赋值
            result[index++]=val;
        }
        return result;

    }

    //二分查找
    public boolean binarySort(int[] nums2,int target)
    {
        int left=0,right=nums2.length-1;
        //二分查
        while(left<=right)
        {
            int mid=(right-left)/2+left;
            if (target>nums2[mid])
            {
                left=mid+1;
            }
            else if (target<nums2[mid])
            {
                right=mid-1;
            }else
            {
                return true;
            }
        }
        return false;


    }
}
