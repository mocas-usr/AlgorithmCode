package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午9:03
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 21:03
 */
public class 字符串的排列 {

    char[] chars;
    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {

        int n = str.length();
        chars = str.toCharArray();

        dfs(0);
        return res;


    }

    public void dfs(int index) {
        //终止条件
        if (index == chars.length-1) {
            res.add(String.valueOf(chars));
            return;
        }
        //for 循环
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {

            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            //当前选择
            //将ch固定在位置上
            swap(i, index);
            //下一路径
            dfs(index + 1);
            //恢复现场
            swap(i, index);
        }


    }

    public void swap(int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }
}
