package code.哈希;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午5:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 17:15
 */
public class T9键盘 {

    public List<String> getValidT9Words(String num, String[] words) {

        //电话本
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        boolean flag = false;
        char[] nums = num.toCharArray();
        List<String> res=new LinkedList<>();
        for (String word : words) {
            char[] str = word.toCharArray();
            for (int i = 0; i < str.length; i++) {
                String s = map.get(nums[i] - '0');
                if (!s.contains(String.valueOf(str[i]))) {
                    flag = false;
                    break;
                }
                if (i == str.length - 1) {
                    flag = true;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;


    }

    @Test
    public void test()
    {
        String num = "8733";
        String[] words = {"tree", "used"};
        List<String> res=getValidT9Words( num, words);
        System.out.println(res);
    }
}
