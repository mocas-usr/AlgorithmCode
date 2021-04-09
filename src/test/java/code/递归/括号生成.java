package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 下午4:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 16:29
 */
public class 括号生成 {
    //全局变量
    List<String> res = new LinkedList<>();
    char[] chars;

    public List<String> generateParenthesis(int n) {
        chars = new char[2 * n];
        //搜索起点
        dfs(0);
        return res;

    }

    public void dfs(int index) {
        //终止条件
        if (index == chars.length) {
            if (valid(chars)) {
                res.add(String.valueOf(chars));
            }
            return;
        }
        //for循环列表

        //当前选择
        chars[index] = '(';
        //下一路径
        dfs(index + 1);
        // 恢复现场
        chars[index] = ')';
        dfs(index + 1);


    }



    //判断有效
    public boolean valid(char[] chars) {
        int balance = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {
                balance++;
            } else if (chars[i] == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        if (balance == 0) {
            return true;
        } else {
            return false;
        }
    }

    //方法2，回溯
    List<String> ans=new LinkedList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis2(int n) {

        hdfs(n,n);
        return ans;
    }

    //左右两边剩下的括号
    public void hdfs(int left,int right)
    {
        //终止条件
        if (left==0 &&right==0)
        {
            ans.add(sb.toString());
        }
        //剪枝
        if (left>right)
        {
            return;
        }

        if (left>0)
        {
            sb.append('(');
            hdfs(left-1,right);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right>0)
        {
            sb.append(')');
            hdfs(left,right-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    @Test
    public void test() {
        int n = 3;
        generateParenthesis2(n);
        String ss = "abc";

        char[] cc;

        cc = ss.toCharArray();
        String res = new String(cc);
        System.out.println(res);

    }

}
