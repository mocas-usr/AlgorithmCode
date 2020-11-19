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
    public List<String> generateParenthesis(int n) {
        //  存放结果
        ArrayList<String> res=new ArrayList<>();

        generateAll(new char[2*n],0,res);
        return res;



    }
    public void generateAll(char[] chars, int num, ArrayList<String> res)
    {
        //这里不能用stringbuilder，不利于回溯
        if (chars.length==num)//当生成2*n个括号
        {
            if (valid(new String(chars)))
            {
                res.add(new String(chars));
            }

        }else
        {
            //回溯
            chars[num]='(';
            generateAll(chars,num+1,res);
            chars[num]=')';
            generateAll(chars,num+1,res);

        }
    }

    public boolean valid(String string)
    {
        int balance=0;
        for (int i=0;i<string.length();i++)
        {
            if (string.charAt(i)=='(')
            {
                balance++;
            }
            else if (string.charAt(i)==')')
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
