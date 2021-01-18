package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/18 15:39
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-18 15:39
 */
public class LRU缓存机制 {
    class LRUCache {
        //链表+map
        Map<Integer,Integer> map;
        Queue<Integer> queue;
        int capacity;

        //
        public LRUCache(int capacity) {
            this.map= new HashMap<>();
            this.queue=new LinkedList<>();
            this.capacity=capacity;
        }

        //取数据保持最上面的
        public int get(int key) {
            //如果包含数据
            if (queue.contains(key))
            {
                //保持用的是新的
                queue.remove(key);
                //加入到双向链表的末端
                queue.add(key);
                return map.get(key);
            }
            else{
                return -1;
            }
        }

        //
        public void put(int key, int value) {
            if (queue.contains(key))
            {
                queue.remove(key);
                queue.add(key);
                map.put(key,value);
            }
            else if (capacity==0)
            {
                //移除队列头部，不常用的
                map.remove(queue.poll());
                queue.add(key);
                map.put(key, value);

            } else
            {
                queue.add(key);
                map.put(key, value);
                capacity--;
            }

        }
    }
}
