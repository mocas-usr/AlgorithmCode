package code.滑动窗口;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 下午4:33
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 16:33
 */
public class 最短超串 {
    public int[] shortestSeq(int[] big, int[] small) {
        //最小窗口大小
        int minLength = big.length + 1;
        //数组加哈希记录匹配情况
        int[] count = new int[small.length];
        //记录small的每个位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < small.length; i++) {
            map.put(small[i], i);
        }
        //窗口
        int left = 0;
        int right = 0;
        int find = 0;

        int[] res = new int[2];

        while (right < big.length) {
            //扩增窗口
            int rightNum = big[right];
            //如果包含small的数字
            if (map.containsKey(rightNum)) {
                //只有第一次出现rightNum的时候，find++;
                if (count[map.get(rightNum)] == 0) {
                    find++;
                }
                //找到的数字
                count[map.get(rightNum)]++;
            }

            //缩小窗口
            while (find == small.length) {
                //当前操作
                if (right - left + 1 < minLength) {
                    res[0] = left;
                    res[1] = right;
                    minLength = right - left + 1;
                }
                int leftNum = big[left];
                //如果当前数字是small中的
                if (map.containsKey(leftNum)) {
                    count[map.get(leftNum)]--;
                    //如果这个数字没了
                    if (count[map.get(leftNum)]==0)
                    {
                        find--;
                    }
                }
                left++;
            }

            right++;
        }

        if (minLength<=big.length)
        {
            return res;
        }else
        {
            return new int[0];
        }

    }
}
