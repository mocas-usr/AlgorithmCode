package code.前缀和;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 上午9:41
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 09:41
 */
public class 字母与数字 {

    public String[] findLongestSubarray(String[] array) {

        int preSum = 0;

        //代表key代表数字比字符多的个数，val代表当前位
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int len=0;
        int start=0;
        for (int i = 0; i < array.length; i++) {
            //如果是数字

            if (Character.isDigit(array[i].charAt(0))) {
                preSum++;
            } else {
                preSum--;
            }

            if (map.containsKey(preSum)) {

                if (len<i-map.get(preSum))
                {
                    start=map.get(preSum)+1;
                    len=i-map.get(preSum);
                }

            }else
            {
                map.put(preSum,i);
            }

        }

        String[] res=new String[len];

        for (int i=start;i<start+len;i++)
        {
            res[i-start]=array[i];
        }
        return res;
    }

    @Test
    public void test()
    {
        String[] array=new String[]{"A","1","B","C","D","2","3","4","E","5","F",
                "G","6","7","H","I","J","K","L","M"};
        String[] res=findLongestSubarray(array);
        System.out.println(array);
    }
}
