package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/14 上午9:58
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-14 09:58
 */
public class 数字流的秩 {
    class StreamRank {

        int[] count;

        public StreamRank() {
            count = new int[50002];

        }

        public void track(int x) {

            ++x;
            //大于x的count 要+1
            for (int i = x; i < count.length-1; i+=i&(-i)) {
                count[i]++;
            }

        }

        public int getRankOfNumber(int x) {

            int res = 0;

            for (int i=x;i>0;i-=i&(-i))
            {
                res+=count[i];
            }
            return res;
        }
    }
}
