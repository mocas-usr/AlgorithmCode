package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午10:40
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 10:40
 */
public class 矩形覆盖 {
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target==1)
        {
            return 1;
        }
        if (target==2)
        {
            return 2;
        }
        return rectCover(target-1)+rectCover(target-2);
    }

}
