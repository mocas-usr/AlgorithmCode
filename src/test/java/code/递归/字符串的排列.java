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
    char[] chars;
    List<String> res = new LinkedList<>();

    public String[] permutation(String s) {

        chars = s.toCharArray();
        int n = s.length();
        dfs(0);
        String[] ans=new String[res.size()];

        for (int i=0;i<res.size();i++)
        {
            ans[i]=res.get(i);
        }
        return ans;

    }


    public void dfs(int index) {
        //终止条件
        if (index == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }

        //for 循环列表
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            //
            //当前选择
            if (set.contains(chars[i]))
            {
                continue;
            }
            set.add(chars[i]);
            swap(index, i);
            //下一路径
            dfs(index + 1);
            //恢复现场
            swap(index, i);
        }

    }

    public void swap(int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    @Test
    public void test() {
        String s = "abc";
        String[] res = permutation(s);
        System.out.println(res);
    }
}

