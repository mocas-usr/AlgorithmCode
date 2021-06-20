package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午10:31
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 10:31
 */
public class 跳台阶扩展问题 {
    public int jumpFloorII(int target) {
        if (target == 0) {
            return 1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII(target - 1);
        }

    }
}
