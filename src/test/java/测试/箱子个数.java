package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/31 19:45
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-31 19:45
 */
//[][[][][]2]3
public class 箱子个数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine()){

            //拆分字符串
            String str=sc.nextLine().trim();
            char[] s=str.toCharArray();
            Stack<Integer> stack=new Stack<>();
            //key代表位置，val代表对应位置为左括号，结尾的和
            Map<Integer,Integer> map=new HashMap<>();

            int res=0;
            int top=0;
            int temp=0;
            for (int i=0;i<s.length;i++)
            {
                if (s[i]=='[')
                {
                    stack.push(i);
                    map.put(i,map.getOrDefault(i,1));
                }else{

                    if (s[i]==']')
                    {
                       top=stack.pop();
                       temp=0;
                        for (int j=top;j<i;j++)
                        {
                            temp+=map.getOrDefault(j,0);
                            map.put(j,0);
                        }
                        map.put(top,temp);

                    }else {
                        int num=s[i]-'0';
                        temp=temp*num;
                        map.put(top,temp);
                    }
                }

            }
            for (int i=0;i<s.length;i++)
            {
                res+=map.getOrDefault(i,0);
            }
            System.out.println(res);

        }
    }
}
