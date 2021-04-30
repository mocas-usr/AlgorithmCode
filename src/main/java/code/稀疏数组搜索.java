package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/30 下午3:24
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-30 15:24
 */
public class 稀疏数组搜索 {

    public int findString2(String[] words, String s) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                map.put(words[i], i);
            }

        }

        int res = map.getOrDefault(s, -1);
        return res;

    }


    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (words[mid].equals("")) {
                if (words[right].compareTo(s)==0) {
                    return right;
                }else
                {
                    right=right-1;
                }
            }else if (words[mid].compareTo(s)>0)
            {
                right=mid-1;
            }else if (words[mid].compareTo(s)<0)
            {
                left=mid+1;
            }else {
                return mid;
            }

        }
        return -1;
    }
}
