package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 上午9:52
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-22 09:52
 */
public class 返回倒数第k个节点 {

    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        int t = k;
        //fast先走k步
        while (t > 0) {
            fast = fast.next;
            t--;
        }

        while (fast != null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }

}
