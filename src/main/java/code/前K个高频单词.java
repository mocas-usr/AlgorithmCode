package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 下午4:48
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 16:48
 */
public class 前K个高频单词 {

    Map<String, Integer> map = new HashMap<>();
    public List<String> topKFrequent(String[] words, int k) {


        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }

        Queue<String> queue=new PriorityQueue<>((o1,o2)->{
            Integer o1Count = map.get(o1);
            Integer o2Count = map.get(o2);
            if (o1Count.equals(o2Count)) {
                return o2.compareTo(o1);
            } else {
                return o1Count - o2Count;
            }
        });


        for (String s:map.keySet())
        {
            queue.offer(s);
            if (queue.size()>k)
            {
                queue.poll();
            }

        }


        List<String> res=new LinkedList<>();

        for (int i=0;i<k;i++)
        {
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }


}
