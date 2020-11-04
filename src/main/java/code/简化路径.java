package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/2 下午3:52
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-02 15:52
 */
public class 简化路径 {
    //栈
    public String simplifyPath(String path) {
        //分割字符串
        String[] s=path.split("/");

        Stack<String> stack=new Stack<>();//栈来表示
        for (int i=0;i<s.length;i++)
        {
            //
            if (!stack.isEmpty() &&s[i].equals(".."))
            {
                stack.pop();
            }
            //说明是//或者.
            else if (s[i].isEmpty() || s[i].equals('.'))
            {
                continue;
            }
            else if (!s[i].isEmpty() && !s[i].equals(".") && !s[i].equals(".."))
            {
                stack.push(s[i]);
            }
        }
        StringBuilder str=new StringBuilder();
        if (stack.isEmpty())
        {
            return "/";
        }
        //如果非空
        while (!stack.isEmpty())
        {
            str.insert(0,"/"+stack.pop());
        }
        return str.toString();

    }

    public String simplifyPath2(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(".") || split[i].equals("")){
                continue;
            }else if (split[i].equals("..")){
                if (stack.isEmpty()){
                    continue;
                }
                stack.pop();
            }else {
                stack.push(split[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,"/"+stack.pop());
        }
        return sb.length()==0?"/":sb.toString();
    }

    @Test
    public void test()
    {
        String s="/home//foo/";
        simplifyPath2(s);
    }
}
