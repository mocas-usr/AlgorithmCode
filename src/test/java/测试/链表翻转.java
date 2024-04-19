package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/27 19:45
 * @email: wangyuhang_mocas@163.com
 */



import code.合并K个升序链表;
import org.junit.Test;

import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-27 19:45
 */
public class 链表翻转 {

    public ListNode reverse(ListNode head)
    {

        if (head==null)
        {
            return null;
        }
        ListNode pre=head;
        ListNode cur=head.next;

        while (cur!=null)
        {
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        head.next=null;
        return pre;
    }
    @Test
    public void test()
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        ListNode res=reverse(node1);
        ListNode cur=res;
        while (cur!=null)
        {
            System.out.println(cur.val);
            cur=cur.next;

        }
    }

    class ListNode{

        ListNode next=null;
        int val;
        ListNode(int val){
            this.val=val;
        }
    }
}
