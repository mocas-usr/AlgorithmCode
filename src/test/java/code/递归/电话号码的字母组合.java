package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/28 下午6:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-28 18:46
 */
public class 电话号码的字母组合 {
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new LinkedList<>();
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        char[] chars = digits.toCharArray();
        dfs(0, chars, map);
        return res;
    }

    public void dfs(int index, char[] chars, Map<Integer, String> map) {
        //z终止条件
        if (index == chars.length) {
            res.add(sb.toString());
            return;
        }

        //当前选择
        //当前数字
        int num = chars[index]-'0';
        //数字的字符
        char[] s = map.get(num).toCharArray();
        //for循环选择
        for (int i = 0; i < s.length; i++) {
            //当前选择
            sb.append(s[i]);
            //下一路径
            dfs(index+1,chars,map);
            //恢复现场
            sb.deleteCharAt(sb.length()-1);
        }
    }


    @Test
    public void test() {
        List<String> res = letterCombinations("23");
        System.out.println(res);
    }

}
