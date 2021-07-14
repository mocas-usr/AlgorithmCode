package code.单调栈;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/30 上午11:59
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-30 11:59
 */
public class LRU {
    class LRUCache {
        //双向链表+map
        Map<Integer, Integer> map;
        Deque<Integer> queue;
        int capacity;//容量

        public LRUCache(int capacity) {
            map = new HashMap<>();
            queue = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                queue.remove(key);
                queue.add(key);
                return map.get(key);
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {

            //如果包含，则直接取，更新位置
            if (map.containsKey(key)) {
                queue.remove(key);
                queue.add(key);
                map.put(key, value);
                return;
            } else if (capacity == 0) {
                //这时容量为0
                //删除最不常用的数据
                map.remove(queue.poll());
                queue.add(key);
                map.put(key, value);
            } else {
                //如果容量还有
                queue.add(key);
                map.put(key, value);
                capacity--;
            }
        }
    }
}
