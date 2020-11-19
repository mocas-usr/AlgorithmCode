package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/17 下午6:42
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-17 18:42
 */
public class 和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        //左右两边的数值
        int left=1;
        int right=1;

        int sum=0;
        //存放结果
        List<int[]> res=new LinkedList<>();

        while (left<=target/2)
        {
            //如果小于
            if (sum<target)
            {
                //则右指针移动
                sum+=right;
                right++;

            }
            //如果小于，则左指针移动
            else if (sum>target)
            {
                sum-=left;
                left++;
            }else if (sum==target)
            {
                //存放此次满足的条件的
                int[] arr=new int[right-left];
                for (int i=left;i<right;i++)
                {
                    arr[i-left]=i;
                }
                res.add(arr);//记录结果
                //左边界移动
                sum-=left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
