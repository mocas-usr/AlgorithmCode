package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 下午7:45
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-18 19:45
 */
public class 有重复字符串的排列组合 {
    char[] str;
    List<String> list;

    public String[] permutation(String S) {
        str = S.toCharArray();
        list=new LinkedList<>();
        dfs(0);
        String[] res=new String[list.size()];
        int i=0;
        for (String s:list)
        {
            res[i++]=s;
        }
        return res;

    }

    public void dfs(int index) {
        //终止条件
        if (index == str.length) {
            list.add(String.valueOf(str));
            return;
        }
        Set<Character> set=new HashSet<>();
        //选择列表
        for (int i = index; i < str.length; i++) {
            if (set.contains(str[i]))
            {
                continue;
            }
            set.add(str[i]);
            //当前选择
            swap(i, index);
            //下一路径
            dfs(index + 1);
            //恢复现场
            swap(i, index);
        }
    }

    public void swap(int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
