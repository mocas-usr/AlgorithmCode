package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/14 下午4:48
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-14 16:48
 */
public class LRU缓存 {
    class LRUCache {

        //记录数值
        Map<Integer, Integer> map;
        //记录使用顺序,头部最老，尾部最新
        Deque<Integer> list;
        //记录容量
        int room;

        public LRUCache(int capacity) {
            this.list = new LinkedList<>();
            this.map = new HashMap<>();
            this.room = capacity;

        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.remove(key);
                list.add(key);
                return map.get(key);

            } else {
                return -1;

            }
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {
                list.remove(key);
                list.add(key);
                map.put(key,value);

            } else {
                if (room<=0)
                {
                    map.remove(list.removeFirst());
                    list.add(key);
                }else
                {
                    list.add(key);
                    room--;
                }
                map.put(key,value);

            }


        }
    }
}
