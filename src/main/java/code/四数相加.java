package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 上午10:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 10:04
 */
public class 四数相加 {

    int res;
    int sum;

    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        res = 0;
        sum = 0;
        dfs(nums1, nums2, nums3, nums4, 0);
        //终止条件
        return res;
    }

    public void dfs(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int k) {
        //终止条件
        if (k == 4) {
            if (sum == 0) {
                res++;
            }
            return;
        }
        //剪枝

        //for 循环列表
        int num;
        for (int i = 0; i < nums1.length; i++) {
            //当前选择
            if (k == 0) {
                num = nums1[i];
            } else if (k == 1) {
                num = nums2[i];
            } else if (k == 2) {
                num = nums3[i];
            } else {
                num = nums4[i];
            }
            sum += num;
            //下一路径
            //恢复现场
            dfs(nums1, nums2, nums3, nums4, k + 1);
            sum -= num;
        }


    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        for (int num1:nums1)
        {
            for (int num2:nums2)
            {
                map.put(num1+num2,map.getOrDefault(num1+num2,0)+1);
            }
        }

        for (int num1:nums3)
        {
            for (int num2:nums4)
            {
                int sum=num1+num2;
                if (map.containsKey(-sum))
                {
                    res+=map.get(-sum);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        int res = fourSumCount(A, B, C, D);
        System.out.println(res);
    }
}
