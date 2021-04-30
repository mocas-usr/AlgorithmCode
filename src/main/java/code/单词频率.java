package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/30 下午8:27
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-30 20:27
 */
public class 单词频率 {

    class WordsFrequency {

        Map<String,Integer> map;
        public WordsFrequency(String[] book) {
            map=new HashMap<>();
            for (String b:book)
            {
                if (map.containsKey(b))
                {
                    map.put(b,map.get(b)+1);
                }else
                {
                    map.put(b,1);
                }
            }

        }

        public int get(String word) {

            return map.getOrDefault(word,0);

        }
    }
}
