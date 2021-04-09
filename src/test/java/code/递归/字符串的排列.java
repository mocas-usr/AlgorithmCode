package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/9 下午4:05
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-09 16:05
 */
public class 字符串的排列 {
    List<String> res = new LinkedList();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();

        if (s.length() == 0) {
            return new String[0];
        }
        //搜索起点
        dfs(0);
        return res.toArray(new String[res.size()]);


    }

    public void dfs(int index) {
        //终止条件
        if (index == chars.length) {
            res.add(String.valueOf(chars));
            return;
        }
        //剪枝
        //for 循环列表
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            // 当前选择

            char ch = chars[i];
            //去重
            if (set.contains(ch)) {
                continue;
            }
            set.add(ch);
            //做选择
            swap(i, index);
            // 下一路径
            //恢复现场
            dfs(index + 1);
            swap(i, index);


        }


    }

    public void swap(int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    @Test
    public void test() {
        String s = "abbc";
        String[] res = permutation(s);
        System.out.println(res);
    }
}

