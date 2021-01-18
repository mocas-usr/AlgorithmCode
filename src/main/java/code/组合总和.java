package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/7 21:25
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-07 21:25
 */
public class 组合总和 {

    //全局变量
    List<List<Integer>> res=new LinkedList<>();
    //变量恢复
    List<Integer> list=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length==0)
        {
            return null;
        }

        //起始搜索路径
        dfs(candidates,target,0);
        return res;
    }

    //回溯,index代表搜索的左边界
    public void dfs(int[] candidates, int target,int index)
    {
        //终止条件,
        if (target<0)
        {
            //恢复现场
//            list.remove(list.size()-1);
            return;
        }
        if (target==0)
        {
            res.add(new LinkedList<>(list));
            //恢复现场
//            list.remove(list.size()-1);
            return;
        }
        //剪枝

        //for 选择列表,只搜寻自己以及右边的数值
        for (int i=index;i<candidates.length;i++)
        {
            //做选择
            list.add(candidates[i]);
            //下一个搜索路径
            dfs(candidates,target-candidates[i],i);
            //恢复现场
            list.remove(list.size()-1);
        }

    }

    @Test
    public void test()
    {
        int [] can={2,3,6,7};
        int targrt=7;
        combinationSum(can,targrt);
        System.out.println(1);
    }
}
