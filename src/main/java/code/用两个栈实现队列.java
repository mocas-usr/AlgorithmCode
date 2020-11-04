package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 下午2:49
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-04 14:49
 */
public class 用两个栈实现队列 {

    class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            //初始化
            s1=new Stack<>();
            s2=new Stack<>();
        }
        //入栈时，不进行处理
        public void appendTail(int value) {
            s2.push(value);//直接入s2

        }

        public int deleteHead() {
            //如果s1是空的
            if (s1.isEmpty())
            {
                if (s2.isEmpty())
                {
                    return -1;
                }
                while (!s2.isEmpty())
                {
                    s1.push(s2.pop());//把s2数据压入s1
                }
                return s1.pop();
            }
            else
            {
                return s1.pop();
            }


        }
    }
}
