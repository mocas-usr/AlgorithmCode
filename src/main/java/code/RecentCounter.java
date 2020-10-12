package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/12 上午10:20
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-12 10:20
 */
/*写一个 RecentCounter 类来计算特定时间范围内最近的请求。

        请你实现 RecentCounter 类：

        RecentCounter() 初始化计数器，请求数为 0 。
        int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。

        保证每次对 ping 的调用都使用比之前更大的 t 值。*/


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

class test{

    public static void main(String[] args) {

    }


}
