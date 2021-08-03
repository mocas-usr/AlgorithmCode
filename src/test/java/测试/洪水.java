package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/1 下午4:31
 * @email: wangyuhang_mocas@163.com
 */

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-01 16:31
 */
public class 洪水 {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Map<Integer,Integer> waterMap = new HashMap<>();
        BitSet empty = new BitSet();
        for(int i=0;i<rains.length;++i){
            if(rains[i]>0){
                if(waterMap.get(rains[i])!=null){
                    int next = empty.nextSetBit(waterMap.get(rains[i])+1);
                    if(next!=-1){
                        empty.set(next,false);
                        ans[next] = rains[i];
                    }else{
                        return new int[0];
                    }
                }
                waterMap.put(rains[i],i);
                ans[i]=-1;
            }else{
                ans[i]=1;
                empty.set(i);
            }
        }
        return ans;
    }
}
