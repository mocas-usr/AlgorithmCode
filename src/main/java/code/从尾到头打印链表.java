package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/20 下午5:05
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-20 17:05
 */
public class 从尾到头打印链表 {
    //集合
    public int[] reversePrint(ListNode head) {

        if (head==null)
        {
            return new int[0];
        }
        ListNode cur=head;
        //保存node的val
        List<Integer> result=new LinkedList<>();
        //把所有的ndoe的值保存
        while (cur!=null)
        {
            result.add(cur.val);
            cur=cur.next;
        }
        int [] res=new int[result.size()];
        int index=0;
        //颠倒数组
        for (int i=result.size()-1;i>=0;i--)
        {
            res[index++]=result.get(i);
        }
        return res;


    }

    //栈
    public int[] reversePrint2(ListNode head)
    {
        if (head==null)
        {
            return new int[0];
        }

        //用栈存储
        Stack<Integer> stack=new Stack<>();

        ListNode cur=head;
        //数值入栈
        while (cur!=null)
        {
            stack.push(cur.val);
            cur=cur.next;
        }

        //结果数组
        int[] res=new int[stack.size()];
        int index=0;
        while (!stack.isEmpty())
        {
            res[index++]=stack.pop();
        }
        return res;
    }

      public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

}
