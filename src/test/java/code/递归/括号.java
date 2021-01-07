package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/4 20:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-04 20:04
 */
public class 括号 {
    //方法2，回溯
    //全局变量
    List<String> res= new LinkedList<>();//结果存放
    StringBuilder str;
    public List<String> generateParenthesis(int n) {
        str=new StringBuilder();//返回现场变量
        //左右两边的括号剩余数量
        int left=n;
        int right=n;
        //起始搜索路径
        hdfs(left,right);

        return res;


    }

    //搜索
    public void hdfs(int left,int right)
    {
        //终止条件
        if (left==0&&right==0)
        {
            res.add(str.toString());
            return;
        }
        //剪枝
        //如果
        if (left>right)
        {
            return;
        }

        //for 选择列表
        //两种选择
        //if其实变相剪枝
        if (left>0)
        {
            str.append("(");
            hdfs(left-1,right);
            //恢复现场
            str.deleteCharAt(str.length()-1);
        }
        if (right>0)
        {
            str.append(")");
            hdfs(left,right-1);
            //恢复现场
            str.deleteCharAt(str.length()-1);

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
