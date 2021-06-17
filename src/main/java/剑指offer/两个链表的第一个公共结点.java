package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午8:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 20:27
 */
public class 两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode a = pHead1;
        ListNode b = pHead2;

        while (a !=b) {
            if (a==null)
            {
                a=pHead2;
            }else
            {
                a = a.next;
            }
            if (b==null)
            {
                b=pHead1;
            }else
            {
                b=b.next;

            }



        }
       return a;

    }

    @Test
    public void test()
    {
        ListNode p1=new ListNode(1);
        ListNode p2=new ListNode(2);
        ListNode p3=new ListNode(3);
        p1.next=p2;
        p2.next=p3;

        ListNode p4=new ListNode(4);
        ListNode p5=new ListNode(5);
        p4.next=p5;

        ListNode res=FindFirstCommonNode(p1, p4);
        System.out.println(res);
    }
}
