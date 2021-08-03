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
import java.util.Set;

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

        dfs(0);
        String[] ans=new String[res.size()];
        for (int i=0;i<res.size();i++)
        {
            ans[i]=res.get(i);
        }
        return ans;
    }

    public void dfs(int index) {
        if (index == chars.length) {
            res.add(String.valueOf(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        //for循环列表
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            //当前选择
            swap(i, index);
            dfs(index + 1);
            //恢复现场
            swap(i, index);

        }
    }

    public void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    @Test
    public void test() {
        String s = "abc";
        String[] res = permutation(s);
        System.out.println(res);
    }
}

