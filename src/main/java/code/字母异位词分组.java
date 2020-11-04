package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/31 下午3:16
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-31 15:16
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams2(String[] strs) {
        //存放结果
        List<List<String>> res=new ArrayList<>();
        int index=0;
        HashMap<HashSet<String>,Integer> map=new HashMap<>();
        //遍历字符串数组
        for (String temp:strs)
        {
            List<String> strings=new ArrayList<>();
            HashSet<String> set=new HashSet<>();
            char[] chars=temp.toCharArray();
            //将字符串分割存储，无序状态
            for (char ch:chars)
            {
                String key=String.valueOf(ch);
                set.add(key);
            }
            //如果已经存在无序状态的字符数组
            List<String> liststring=new ArrayList();
            if (!map.containsKey(set))
            {
                map.put(set,index);
                liststring.add(temp);
                res.add(liststring);
                index++;

            }else
            {
                int t=map.get(set);
                liststring=res.get(t);
                liststring.add(temp);
                res.set(t,liststring);

            }

        }
        return res;


    }

    //另一种
    public List<List<String>> groupAnagrams(String[] strs)
    {
        //string作为特异性字符，val作为结果集
        HashMap<String, ArrayList<String>> map=new HashMap<>();

        for (String str:strs)
        {
            //包含的所有字符
            char[] chars=str.toCharArray();
            //排序，如果字符一样，排序也是一样
            Arrays.sort(chars);
            String key=String.valueOf(chars);
            //如果不包含，则说明没有重复的
            if (!map.containsKey(key))
            {
                map.put(key,new ArrayList<>());
                map.get(key).add(str);
            }else
            {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    @Test
    public void test()
    {
        String[] strings={"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }
}
