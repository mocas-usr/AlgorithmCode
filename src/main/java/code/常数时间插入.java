package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午8:50
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-15 20:50
 */
public class 常数时间插入 {
    class RandomizedSet {

        List<Integer> list=new LinkedList<>();
        Map<Integer, Integer> map=new HashMap<>();
        Random random=new Random();


        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val))
            {
                return false;
            }
            //插入
            list.add(val);
            //数值，位置
            map.put(val,list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val))
            {
                return false;
            }
            //交换位置
            int last=list.get(list.size()-1);
            int lastIndex=list.size()-1;
            int index=map.get(val);
            map.put(last,index);
            map.remove(val);
            list.set(index,last);
            list.remove(list.size()-1);
            return true;

        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
