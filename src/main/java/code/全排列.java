package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/8 15:59
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-08 15:59
 */

public class 全排列 {
    //全局变量
    List<List<Integer>> res=new LinkedList<>();
    //变量恢复
    List<Integer> list=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        //特殊处理
        if (nums.length==0)
        {
            return null;
        }
        //利用集合
        for (int num:nums)
        {
            list.add(num);
        }

        //起始路径
        dfs(0);
        return res;

    }
    //回溯
    public void dfs(int index)
    {
        //终止条件
        if (index==list.size())
        {
            res.add(new LinkedList<>(list));
            return;
        }
        //剪枝

        //for 选择列表
        //只跟自己右边的数值交换
        for (int i=index;i<list.size();i++)
        {
            //做选择
            swap(i,index);//index这一位上的选择，进行交换
            //下一路径
            dfs(index+1);
            //恢复现场
            swap(i,index);
        }
    }

    public void swap(int i,int j)
    {
       int temp=list.get(i);
       list.set(i,list.get(j));
       list.set(j,temp);
    }

    @Test
    public void test()
    {
        int[] nums={1,2,3};
        permute(nums);
        System.out.println(1);
    }
}
