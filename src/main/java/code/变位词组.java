package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/29 下午7:09
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-29 19:09
 */
public class 变位词组 {

    public List<List<String>> groupAnagrams(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        //map中key存储的是字符串中字母排序后新的字符串
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            //排序
            Arrays.sort(chars);
            //
            String keyStr = String.valueOf(chars);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr,new ArrayList<>());

            }

            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());


    }
}
