package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/27 上午9:21
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-27 09:21
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        //结果存放
        List<String> combinations = new ArrayList<String>();
        //初始化一个空的字符集合
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    //暴力列举
    public void generateAll(char[] current, int pos, List<String> result) {

        //暴力的终止条件
        if (current.length==pos)
        {
            if (valid(current))
            {
                result.add(current.toString());//把满足条件的字符串添加
            }
        }
        else
        {
            //暴力列举
            current[pos]='(';
            generateAll(current,pos+1,result);//向后列举
            current[pos]=')';//第二种情况
            generateAll(current,pos+1,result);//继续向后列举
        }
    }

    public boolean valid(char[] current) {
        int balance=0;
        for (int i=0;i<current.length;i++)
        {
            if (current[i]=='(')
            {
                balance++;
            }
            if (current[i]==')')
            {
                balance--;
            }
            //如果出现balance<0说明括号方向反了，
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

    }
}
