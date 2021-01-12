package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/9 19:06
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-09 19:06
 */
public class 合并区间 {
    //排序算法的应用
    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);//实现降序
        //行不确定，列确定
        int[][] res=new int[intervals.length][2];

        int index=-1;
        //interval头部已经按照顺序排列好
        for (int[] nums:intervals)
        {
            //此时三种情形
            //第一个或者满足第一种情形
            if (index==-1||nums[0]>res[index][1])
            {
                //此时加入结果
                res[++index]=nums;
            }else if (nums[0]<=res[index][1] &&nums[1]>res[index][1])
            {
                //合并
                res[index][1]=nums[1];
            }else if (nums[0]<=res[index][1] &&nums[1]<=res[index][1])
            {
                //不作处理
                continue;
            }


        }

        return Arrays.copyOf(res,index+1);


    }


    @Test
    public void test()
    {
        int[][] ints={ {1,3},{2,6},{8,10},{15,18}};
        merge(ints);
        System.out.println(1);
    }
}
