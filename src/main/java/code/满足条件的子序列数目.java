package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/13 下午7:06
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-13 19:06
 */
public class 满足条件的子序列数目 {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        List<int[]> lst = new ArrayList<int[]>();
        int pre = -1;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] != pre) {
                lst.add(new int[] {nums[i], i});
            } else {
                lst.get(lst.size() - 1)[1] = i;
            }
            pre = nums[i];
        }
        int total = 0;
        for(int i = 0; i < nums.length; i ++) {
            int j = binsearch(lst, 0, lst.size() - 1, target - nums[i]);
            if(j != -1) {
                int x = lst.get(j)[1];
                // System.out.println(i + " " + x);
                if(x >= i)
                    total = (total + power(x - i)) % 1000000007;
                // System.out.println("total = " + total);
            }
        }
        return total;
    }

    public int binsearch(List<int[]> lst, int left, int right, int target) {
        if(right < left)
            return -1;
        int l = left, r = right, m;
        while(l < r - 1) {
            m = (l + r) / 2;
            if(lst.get(m)[0] > target)
                r = m - 1;
            else
                l = m;
        }
        if(lst.get(r)[0] <= target)
            return r;
        else if(lst.get(l)[0] <= target)
            return l;
        else
            return -1;
    }

    public int power(int n) {
        long x = 2, ans = 1;
        for(int i = n; i > 0; i = i / 2) {
            if(i % 2 > 0) {
                ans *= x;
                ans %= 1000000007;
            }
            x *= x;
            x %= 1000000007;
        }
        return (int)ans;
    }
}
