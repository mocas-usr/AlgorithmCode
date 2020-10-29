package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/25 上午9:13
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-25 09:13
 */
public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pre=new ListNode(0);//模拟头部链表节点
        ListNode head=pre;//指针
        while (l1!=null && l2!=null)//两个都不等于null
        {
            if (l1.val<l2.val)
            {
             head.next=l1;
             l1=l1.next;//l1向后移动
            }else
            {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        //如果其中之一等于null，直接把剩余的接在后面
        if (l1==null)
        {
            head.next=l2;
        }else
        {
            head.next=l1;
        }
        return pre.next;//去除模拟节点后，完整链表


    }
}
