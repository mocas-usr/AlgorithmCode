package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/22 上午10:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-22 10:18
 */
public class 查询带键的排列 {
    public int[] processQueries(int[] queries, int m) {

        //构造p数组
        int[] P=new int[m];
        for (int k=0;k<m;k++)
        {
            P[k]=k+1;
        }
        //记录结果
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<queries.length;i++)
        {
            //i的查询处理
            int t=queries[i];
            for (int j=0;j<m;j++)
            {
                if (P[j]==t)
                {
                    list.add(j);//记录结果
                    //移动位置
                    //换位置，从目标位置的前一个开始移动，一直到第一个位置数字
                    int tep = P[j];
                    for (int k = j - 1; k >= 0; k--) {
                        P[k+1] = P[k];
                    }
                    P[0] = tep;

                }
            }
        }
        //取值
        int[] res=new int[list.size()];
        for (int i=0;i<list.size();i++)
        {
            res[i]=list.get(i);
        }
        return res;


    }


    //定义数组记录顺序
    public int[] processQueries2(int[] queries, int m)
    {

        int[] f=new int[m+1];//f是记录位置，f[res]=i说明res的位置在i位
        //赋值
        for (int i=1;i<=m;i++)
        {
            f[i]=i;
        }

        for (int j=0;j<queries.length;j++)
        {
            //代表q的数值
            int val=queries[j];
            int res=f[val];//说明val在P中的位置是res
            queries[j]=res-1;
            for (int k=1;k<=m;k++)
            {
                if (f[k]<res)
                {
                    f[k]++;
                }

            }

            f[val]=1;
        }
        return queries;
    }

    public int[] processQueries4(int[] queries, int m) {
        TreeMap<Integer, Integer> valPos = new TreeMap<>();
        TreeSet<Integer> posVal = new TreeSet<>();
        int[] result = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++) {
            if(!valPos.containsKey(queries[i])) {
                result[i] = valPos.tailMap(queries[i] + 1).size() + queries[i] - 1;
            }
            else {
                result[i] = posVal.tailSet(valPos.get(queries[i]) + 1).size();
                posVal.remove(valPos.get(queries[i]));
            }
            valPos.put(queries[i], i);
            posVal.add(i);
        }
        return result;
    }


    @Test
    public void test()
    {
        int[] arr={3,1,2,1};
        int m = 5;
        int[] q=processQueries4(arr,m);
        System.out.println(Arrays.toString(q));

    }
}
