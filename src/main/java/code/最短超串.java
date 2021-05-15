package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 下午4:24
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 16:24
 */
public class 最短超串 {
    public int[] shortestSeq(int[] big, int[] small) {
        //最短窗口大小
        int minLength = big.length + 1;
        //数组＋哈希表记录匹配情况
        int[] count = new int[small.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < small.length; i++) {
            map.put(small[i], i);
        }

        //窗口左右边界
        int left = 0;
        int right = 0;
        //用find记录匹配的个数
        int find = 0;
        int[] res = new int[2];
        // 扩展右边界
        while (right < big.length) {
            int rightNum = big[right];
            if (map.containsKey(rightNum)) {
                count[map.get(rightNum)]++;
                if (count[map.get(rightNum)] == 1) {
                    find++;
                }
            }

            //缩小左边界
            while (find == small.length) {
                if (right - left + 1 < minLength) {
                    res[0] = left;
                    res[1] = right;
                    minLength = right - left + 1;
                }
                int leftNum = big[left];
                if (map.containsKey(leftNum)) {
                    count[map.get(leftNum)]--;
                    if (count[map.get(leftNum)]==0)
                    {
                        find--;
                    }
                }
                left++;
            }
            right++;

        }

        return minLength <= big.length ? res : new int[0];
    }
}
