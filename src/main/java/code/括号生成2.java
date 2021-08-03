package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/27 上午10:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-27 10:31
 */
public class 括号生成2 {
    public static void main(String[] args) {
        int[] k=new  int[1];
        try {
            k[0]=1;
            throw new NullPointerException("1");
        }catch (Exception e)
        {k[0]=2;}
        finally {
            k[0]=3;
        }
        System.out.println(k[0]);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    //回溯算法
    public List<String> generateParenthesis2(int n)
    {
        //结果存放
        List<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        hdfs("",n,n,res);
        return res;
    }

    //回溯
    //left,right分别代表剩余的左右括号
    public void hdfs(String str,int left,int right,List<String> res)
    {
        if (left==0&&right==0)
        {
            res.add(str);
//            str.setLength(0);
            return;
        }
        //左边大于右边，不能递归
        if (left>right)
        {
            return;
        }

        if (left>0)
        {
//           str.append('(');
           hdfs(str+'(',left-1,right,res);//递归处理
        }
        if (right>0)
        {
//            str.append(')');
            hdfs(str+')',left,right-1,res);
        }
    }
    @Test
    public void test()
    {
        int n=3;
        generateParenthesis2(n);

    }
}
