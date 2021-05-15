package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 下午4:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-01 16:19
 */
public class 字母与数字 {
    public String[] findLongestSubarray(String[] array) {
        //key是前缀和，val是index
        Map<Integer, Integer> indexMap = new HashMap<>();
        int preSum = 0;
        indexMap.put(0, -1);
        int start = 0;
        int end = -1;
        int max = 0;

        //遍历数组
        for (int i = 0; i < array.length; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                preSum += 1;
            } else {
                preSum+=-1;
            }
            //如果已经拥有这个前缀和
            if (indexMap.containsKey(preSum))
            {
                int left=indexMap.get(preSum);
                if (i-left>max)
                {
                    max=i-left;
                    start=left;

                }

            }else
            {
                indexMap.put(preSum,i);
            }


        }

        return Arrays.copyOfRange(array, start + 1, start + 1 + max);
    }

    @Test
    public void test() {
        String[] array = {"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"};
        String[] res = findLongestSubarray(array);
        System.out.println(res);
    }


}
