package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 上午10:47
 * @email: wangyuhang_mocas@163.com
 */

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-18 10:47
 */
public class 链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode res  = new ListNode(0);
        ListNode cur  = res;
        while(l1!=null||l2!=null||tmp!=0){
            if(l1!=null){
                tmp+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                tmp+=l2.val;
                l2=l2.next;
            }
            cur.next = new ListNode(tmp%10);
            cur = cur.next;
            tmp  = tmp /10 ;
        }
        return res.next;

    }
}
