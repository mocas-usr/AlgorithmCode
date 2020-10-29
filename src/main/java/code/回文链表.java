package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/23 上午10:13
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-23 10:13
 */
public class 回文链表 {
    //将值复制到数组中后用双指针法
    public boolean isPalindrome(ListNode head) {
        if (head==null)
        {
            return true;
        }
        //利用list存储
       List<Integer> list=new ArrayList<>();

       ListNode cur=head;
       while (cur!=null)
       {
           list.add(cur.val);
           cur=cur.next;
       }

       int left=0;
       int right=list.size()-1;
       while (left<right)
       {
           if (!list.get(left).equals(list.get(right)))
           {
               return false;
           }
           else
           {
               left++;
               right--;
           }

       }
       return true;


    }

    //反转后半部分链表
    public boolean isPalindrome2(ListNode head)
    {
        //先寻找链表中点
        ListNode fast=head;
        ListNode slow=head;
        //fast走到终点，或者fast.next走到终点，slow走到中点了
        while (fast!=null &&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        //如果fast不是null，而fast.next是null，则为奇数个node，
        //slow在中点，要移动到中间靠右开始反转
        if (fast!=null)
        {
            //开始反转的点
            slow=slow.next;
        }
        slow=revserse(slow);
        //fast回到头部
        fast=head;
        //一直到结束
        while (slow!=null)
        {
            if (slow.val!=fast.val)
            {
                return false;
            }
            else
            {
                slow=slow.next;
                fast=fast.next;
            }
        }
        return true;
    }

    //反转链表
    public ListNode revserse(ListNode cur)
    {
        ListNode pre=null;
        while (cur!=null)
        {
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }


    //使用栈解决
    public boolean isPalindrome3(ListNode head)
    {
        //本质是按顺序比较val数值
        Stack<Integer> stack=new Stack<>();

        //将val压入栈
        ListNode cur=head;

        while (cur!=null)
        {
            stack.add(cur.val);//入栈
            cur=cur.next;
        }

        //入栈之后比较
        while (head!=null)
        {
            if (head.val!=stack.pop())
            {
                return false;
            }
            head=head.next;
        }
        return true;
    }



    @Test
    public void test()
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);

        node1.next=node2;
        node2.next=node3;
        boolean t=isPalindrome2(node1);
        System.out.println(t);
    }


}
