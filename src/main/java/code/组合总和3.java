package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 上午10:23
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-25 10:23
 */
public class 组合总和3 {

    List<List<Integer>> res=new LinkedList<>();
    List<Integer> list=new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {


        dfs(1,k,n,0);
        return res;

    }

    public void dfs(int index,int k,int n,int sum)
    {
        //终止条件
        if (sum>n)
        {
            return;
        }
        if (sum==n &&list.size()==k)
        {
            res.add(new LinkedList<>(list));
            return;
        }

        //for循环列表
        for (int i=index;i<10;i++)
        {
            //当前选择
            list.add(i);
            sum+=i;
            dfs(i+1,k,n,sum);
            sum-=i;
            list.remove(list.size()-1);
        }

    }
}
