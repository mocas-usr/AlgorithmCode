package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 上午10:00
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 10:00
 */
public class 链表相交 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode la=headA;
        ListNode lb=headB;
        //a+c+b=b+c+a
        while (la!=lb)
        {
            if (la!=null)
            {
                la=la.next;
            }else
            {
                la=headB;
            }
            if (lb!=null)
            {
                lb=lb.next;
            }
            else {
                lb=headA;
            }
        }
        return la;

    }
}
