/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/12 上午10:28
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-12 10:28
 */
public class RecentCounter {
    Queue<Integer> q;
    public RecentCounter(){

        //初始化队列,队列中ping个数是0
        q=new LinkedList<Integer>();

    }

    public int ping(int t) {
        //每次ping，至少有1个，u=t
        q.add(t);
        while(q.peek()<t-3000)//如果超出此刻之前的3000，则移除
        {
            q.poll();
        }
        return q.size();

    }
}
