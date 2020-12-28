package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/28 下午8:38
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-28 20:38
 */
public class 合并K个升序链表 {

    //哨兵节点
    ListNode head=new ListNode(-1);
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0)
        {
            return null;
        }
        if (lists.length==1)
        {
            return lists[0];
        }


        ListNode temp=lists[0];
        //两两合并
        for (int i=1;i<lists.length;i++)
        {
              temp=mergeKList(temp,lists[i]);
        }
        return head.next;

    }

    //先合并两个
    public ListNode mergeKList(ListNode node1, ListNode node2)
    {
        ListNode i=node1;
        ListNode j=node2;
        ListNode tmp=head;
        //合并
        while (i!=null && j!=null)
        {
            //把小的放入tmp
            if (i.val<j.val)
            {
                tmp.next=i;
                i=i.next;
            }else
            {
                tmp.next=j;
                j=j.next;
            }
            //移动指针
            tmp=tmp.next;
        }
        if (i==null )
        {
            while (j!=null)
            {
                tmp.next=j;
                j=j.next;
                //移动指针
                tmp=tmp.next;
            }
        }
        if (j==null)
        {
            while (i!=null)
            {
                tmp.next=i;
                i=i.next;
                //移动指针
                tmp=tmp.next;
            }
        }
        return head.next;
    }

    @Test
    public void test()
    {
        ListNode node1=new ListNode(1);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node4;
        node4.next=node5;


        ListNode node21=new ListNode(1);
        ListNode node23=new ListNode(3);
        ListNode node24=new ListNode(4);

        node21.next=node23;
        node23.next=node24;

        ListNode node32=new ListNode(2);
        ListNode node36=new ListNode(6);
        node32.next=node36;
        ListNode[] lists={node1,node21,node32};
        ListNode res=mergeKLists(lists);
        System.out.println(res);


    }


      public class ListNode {
      int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
