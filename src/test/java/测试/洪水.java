package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/1 16:32
 * @email: wangyuhang_mocas@163.com
 */


import code.Trie.实现Trie;

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-01 16:32
 */
public class 洪水 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(
                System.in);
        while (sc.hasNextLine())
        {
            String str=sc.nextLine().trim();
            String[] rainStr=str.substring(1,str.length()-1).split(",");
            int[] rains=new int[rainStr.length];

            for (int i=0;i<rains.length;i++)
            {
                rains[i]=Integer.parseInt(rainStr[i]);
            }
            int[] res=flood(rains);
            System.out.println(Arrays.toString(res));
//            StringBuilder sb=new StringBuilder();
//            sb.append("[");
//            for (int i=0;i<rains.length-1;i++)
//            {
//                sb.append(res[i]);
//                sb.append(",");
//            }
//            sb.append(res[res.length-1]);
//            sb.append("]");
//            System.out.println(Arrays.toString(res));
        }

    }

    public static int[] flood(int[] rains) {
        //结果数组
        int[] ans = new int[rains.length];
        Map<Integer,Integer> waterMap = new HashMap<>();
        StringBuilder S=new StringBuilder();
        BitSet emp = new BitSet();

        int res=0;
        for(int i=0;i<rains.length;++i){
            if(rains[i]>0){
                if(waterMap.get(rains[i])!=null){
                    int next = emp.nextSetBit(waterMap.get(rains[i])+1);
                    if(next!=-1){

                        int one= 1;
                        emp.set(next,false);
                        int nexa=0;
                        ans[next] = rains[i];
                    }else{
                        return new int[0];
                    }
                }
                waterMap.put(rains[i],i);
                ans[i]=-1;
            }else{
                ans[i]=1;
               //
                emp.set(i);
            }
        }
        return ans;
    }
}
