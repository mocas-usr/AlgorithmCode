package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/21 下午8:00
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-21 20:00
 */
public class 链路 {
////    public static void main(String[] args) {
////
////        Scanner sc=new Scanner(System.in);
////
////        while (sc.hasNext())
////        {
////            Map<Integer, Set<Integer>> map=new HashMap<>();
////            while (sc.hasNextLine())
////            {
////
////
////                if (map.containsKey())
////                map.containsKey()
////            }
////        }
////    }
//
//    public int convert(int[][] nums)
//    {
//
//        Map<Integer, Set<Integer>> map=new HashMap<>();
//
//        int m=nums.length;
//
//        for (int i=0;i<nums.length;i++)
//        {
//            int num=nums[i][0];
//            if (!map.containsKey(num))
//            {
//                map.put(num,new HashSet<>());
//            }
//            map.get(num).add(nums[i][1]);
//
//        }
//
//        //遍历哪条路径最长
//        for (Map.Entry entry:map.entrySet())
//        {
//            dfs((Integer) entry.getKey(),1,map);
//        }
//
//
//
//    }
//
//    public int  dfs(int index,int val, Map<Integer, Set<Integer>> map)
//    {
//        //终止条件
//        if (map.get(index).size()==0)
//        {
//
//            return 0;
//        }
//
//        //当前操作
//        int len=1;
//        for (Integer path:map.get(index)) {
//           len =Math.max(len,dfs(path,val,map)) ;
//        }
//
//    }





}
