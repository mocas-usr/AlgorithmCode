package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 19:11
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-14 19:11
 */
/*

P P C P
C P C C
C P P P
P C P C
 */
public class 网络节点 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext())
        {
            int n=sc.nextInt();
            int k=sc.nextInt();

            Map<Integer, Set<Integer>> graph=new HashMap<>();
            for (int i=0;i<n-1;i++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                //初始化图
                if (!graph.containsKey(a))
                {
                    graph.put(a,new HashSet<>());
                }
                //图构建
                graph.get(a).add(b);
                if (!graph.containsKey(b))
                {
                    graph.put(b,new HashSet<>());
                }
                graph.get(b).add(a);
            }

            Map<Integer,Integer> map=new HashMap<>();
            for (int i=0;i<n;i++)
            {
                map.put(i, (int) Math.pow(2,i));
            }


            System.out.println(n-k);




        }

    }
}
