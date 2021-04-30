package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 下午5:10
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 17:10
 */
public class 删除中间节点 {

    public void deleteNode(ListNode node) {

        ListNode next=node.next;
        node.val=next.val;
        node.next=next.next;

    }
}
