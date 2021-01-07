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
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-09 16:05
 */
public class 字符串的排列 {

    //回溯
    //全局变量结果集
    List<String> res=new LinkedList<>();
    //恢复现场的变量
    char[] chars;//保存abc结果
    public String[] permutation(String s) {
        //任意交换顺序
        chars=s.toCharArray();

        //起始路径
        dfs(0);
        //结果转换
        return res.toArray(new String[res.size()]);


    }

    //搜索
    public void dfs(int index)//index搜索位置
    {
        //终止位置,搜索到最后一个位置
        if (index==chars.length)
        {
            res.add(String.valueOf(chars));

            return;
        }

        //剪枝

        HashSet<Character> set=new HashSet<>();//为了去除给定原有字符的重复元素
        //for 选择列表
        //对于index元素，从此位置之后都可以选择
        for (int i=index;i<chars.length;i++)
        {
            //如果包含重复元素，就不要重复交换了
            if (set.contains(chars[i]))
            {
                continue;
            }
            set.add(chars[i]);
            //做选择
            swap(i,index);
            //下一路径处理
            dfs(index+1);
            //恢复现场
            swap(i,index);

        }
    }

    public void swap(int i,int j)
    {
        char ch=chars[i];
        chars[i]=chars[j];
        chars[j]=ch;
    }

    @Test
    public void test()
    {
        String s = "dkjphedy";
        permutation(s);
    }
}

