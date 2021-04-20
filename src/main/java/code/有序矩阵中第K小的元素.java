package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 下午7:14
 * @email: wangyuhang_mocas@163.com
 */

import java.util.PriorityQueue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-15 19:14
 */
public class 有序矩阵中第K小的元素 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(((o1, o2) -> (o2-o1)));

        for (int i=0;i<matrix.length;i++)
        {
            int[] nums=matrix[i];
            for (int j=0;j<nums.length;j++)
            {
                queue.add(nums[j]);
                if (k<queue.size())
                {
                    queue.poll();
                }
            }
        }
        return queue.poll();

    }
}
