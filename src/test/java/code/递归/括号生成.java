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
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-03 16:29
 */
public class 括号生成 {
    //全局变量
    List<String> res=new LinkedList<>();//返回结果
    //存储现场变量
    char[] str;
    public List<String> generateParenthesis(int n) {

        str=new char[n*2];//一共有2n个括号
        //启示搜索路径
        dfs(0,n);//从0开始搜索,n搜索结束
        return res;


    }

    //搜索
    public void dfs(int index,int n)
    {
        //终止条件，搜索结束

        if (index==2*n)
        {
            if (valid(str))
            {
                //如果搜索到最后一个字符
                res.add(String.valueOf(str));
            }
            return;
        }
        //剪枝

        //for 选择列表
        //做选择
        str[index]='(';
        //下一搜索路径
        dfs(index+1,n);
        //恢复现场,下一选择
        str[index]=')';
        dfs(index+1,n);

    }

    public boolean valid(char[] chars)
    {
        int balance=0;
        for (char ch:chars)
        {
            if (ch=='(')
            {
                balance++;
            }else if (ch==')')
            {
                balance--;
            }
            if (balance<0)
            {
                return false;
            }
        }
        if (balance==0)
        {
            return true;
        }else
        {
            return false;
        }

    }

    //方法2，回溯


    @Test
    public void test()
    {
        int n=3;
        generateParenthesis(n);
        String ss="abc";

        char[] cc;

        cc=ss.toCharArray();
        String res=new String(cc);
        System.out.println(res);

    }

}
