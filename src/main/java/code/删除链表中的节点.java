package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午7:31
 * @email: wangyuhang_mocas@163.com
 */

import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-12 19:31
 */
public class 删除链表中的节点 {

    public void deleteNode(ListNode node) {


        ListNode cur=node.next;
        ListNode next=cur.next;
        node.val=node.next.val;
        node.next=next;

    }

}
