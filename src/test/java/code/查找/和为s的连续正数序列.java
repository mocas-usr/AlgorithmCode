package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午3:34
 * @email: wangyuhang_mocas@163.com
 */


import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 15:34
 */
public class 和为s的连续正数序列 {

    public int[][] findContinuousSequence(int target) {


        List<int[]> res=new LinkedList<>();
        //初始化窗口
        int left = 1;
        int right = 1;
        int sum = 0;
        while (right < target) {

            if (sum > target) {
                sum -= left;
                left++;
            }else if (sum<target)
            {
                sum+=right;
                right++;
            }
            else
            {
                int[] arr=new int[right-left];
                for (int i=left;i<right;i++)
                {
                    arr[i-left]=i;
                }
                res.add(arr);
                sum+=right;
                right++;


            }


        }

        return  res.toArray(new int[res.size()][]);

    }

    public int[][] findContinuousSequence2(int target) {

        int preSum = 0;

        //前缀和一定要注意初始化
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for (int i = 1; i < target; i++)
        {
            preSum+=i;
            map.put(preSum,i);

        }

        int sum=0;
        List<int[]> res=new LinkedList<>();
        for (int i=0;i<target;i++)
        {
            sum+=i;

            //说明存在连续数列
            if (map.containsKey(sum+target))
            {
                int j=map.get(sum+target);

                int[] arr=new int[j-i];
                for (int k=i+1;k<=j;k++)
                {
                    arr[k-i-1]=k;
                }
                res.add(arr);
            }
        }
        return res.toArray(new int[res.size()][]);


    }

    @Test
    public void test()
    {
        int[][] res=findContinuousSequence2(15);
        System.out.println(res);
    }
}
