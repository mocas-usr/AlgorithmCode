package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/24 上午11:14
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import javax.print.DocFlavor;
import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-24 11:14
 */
public class 除法求值 {
    //并查集方法
    static Map<String, String> parents;
    static Map<String, Double> val;


    //压缩路径
    public String find(String x) {

        if (!x.equals(parents.get(x)))//如果不相等，说明不是root
        {
            String tmpParent=parents.get(x);//往下查找
            String root=find(tmpParent);//回溯查找
            //往上回溯
            double oldVal=val.get(x);//原本的相对于下一级的val
            val.put(x,oldVal*val.get(tmpParent));
            parents.put(x,root);//更新为相对于root的val

        }
        //此时，回溯深度查询到root
        return parents.get(x);

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        parents = new HashMap<>();
        val = new HashMap<>();
        //
        int i=0;
        //建立关系
        for (List<String> equation:equations)
        {
            //[a,b]
            String from=equation.get(0);
            String to=equation.get(1);
            double cur=values[i];
            //parent[a] = b，即让b成为a的父亲，同时让val[a] = 3。
            //如果从来没出现过这两个的关系，
            if (!parents.containsKey(from)&&!parents.containsKey(to))
            {
                parents.put(from,to);
                val.put(from,cur);//被除数的
                parents.put(to,to);
                val.put(to,1.0);

            }
            //包含其中一个to
            else if (!parents.containsKey(from))
            {
                //不用更新to to，
                parents.put(from,to);
                val.put(from,cur);
            }
            //只包含from，说明原本已经存在
            //保险起见，from作为to放入，目的是为了让一个除数，一直是除数
            else if (!parents.containsKey(to))
            {
                parents.put(to,from);
                val.put(to,1/cur);
            }
            else //如果除数被除数都已经出现，压缩路径
            {
                String pa=find(from);
                String pb=find(to);
                if (!pa.equals(pb))
                {
                    //两个集合不存在交集，但是需要合并
                    parents.put(pa,pb);
                    val.put(pa,cur*val.get(to)/val.get(from));
                }

            }
            //目的是更新val数值
            i++;
        }

        i=0;
        double[] res=new double[queries.size()];
        //记录结果
        for (List<String> query:queries)
        {
            String from=query.get(0);
            String to=query.get(1);
            //存在没有定义关系的字符，则返回-1
            if (!parents.containsKey(from)||!parents.containsKey(to))
            {
                res[i++]=-1;
                continue;
            }
            //如果没有共同的root，则没有关系，返回-1
            String pa=find(from);
            String pb=find(to);
            if (!pa.equals(pb))
            {
                res[i]=-1;

            }
            else
            {
                res[i]=val.get(from)/val.get(to);

            }

            i++;
        }
        return res;

    }

    @Test
    public void test()
    {
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list2.add("b");
        list2.add("c");

        List<List<String>> equations=new ArrayList<>();
        equations.add(list1);
        equations.add(list2);
        double[] values={2.0,3.0};
        List<List<String>> queries=new ArrayList<>();
        List<String> list3=new ArrayList<>();
        list3.add("a");
        list3.add("c");
        queries.add(list3);
        List<String> list4=new ArrayList<>();
        list4.add("b");
        list4.add("a");
        queries.add(list4);
        List<String> list5=new ArrayList<>();
        list5.add("a");
        list5.add("e");
        queries.add(list5);
        List<String> list6=new ArrayList<>();
        list6.add("a");
        list6.add("a");
        queries.add(list6);
        List<String> list7=new ArrayList<>();
        list7.add("x");
        list7.add("x");
        queries.add(list7);
        double[] res=calcEquation(equations,values, queries);
        System.out.println(Arrays.toString(res));

    }
}
