package code.前缀和;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/14 下午4:41
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-14 16:41
 */
public class 生存人数 {

    public int maxAliveYear(int[] birth, int[] death) {

        int[] lives = new int[102];

        for (int bir : birth) {
            //出生人数加1
            lives[bir - 1900]++;
        }

        for (int dea : death) {
            lives[dea - 1900 + 1]--;
        }

        int[] preSum = new int[102];
        int minYear = -1;
        int max = -1;
        int sum = 0;

        for (int i = 0; i < 102; i++) {
            sum += lives[i];
            if (sum > max) {
                minYear = i + 1900;
                max = sum;
            }

        }
        return minYear;

    }
}
