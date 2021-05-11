package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/7 下午8:45
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-07 20:45
 */
public class 两个链表的第一个公共节点 {

    //
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a1=headA;
        ListNode b1=headB;

        while (a1!=b1)
        {
            if (a1==null)
            {
                a1=headB;
            }else
            {
                a1=a1.next;
            }
            if (b1==null)
            {
                b1=headA;
            }
            else
            {
                b1=b1.next;
            }



        }
        return a1;


    }
}
