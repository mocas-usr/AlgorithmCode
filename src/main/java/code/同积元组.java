package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 下午2:37
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-31 14:37
 */
public class 同积元组 {

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int res=0;
        for (int i=0;i<nums.length;i++)
            for (int j=i+1;j<nums.length;j++)
            {
                int sum=nums[i]*nums[j];
                res+=map.getOrDefault(sum,0);
                map.put(sum,map.getOrDefault(sum,0)+1);

            }
        return res*8;

    }
}
