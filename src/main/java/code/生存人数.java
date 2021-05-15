package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/14 下午4:25
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-14 16:25
 */
public class 生存人数 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] lives = new int[102];
        for (int birthyear : birth)
            lives[birthyear - 1900]++;
        for (int deathyear : death)
            lives[deathyear - 1900 + 1]--;

        int[] preSum = new int[102];
        preSum[0] = lives[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = lives[i] + preSum[i - 1];
        }

        int maxlives = -1;
        int minyear = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] > maxlives) {
                minyear = i + 1900;
                maxlives = preSum[i];
            }
        }
        return minyear;

    }

    @Test
    public void test()
    {
        int[] birth = {1900, 1901, 1950};
        int[] death = {1948, 1951, 2000};
        int res=maxAliveYear(birth, death);
        System.out.println(res);
    }


}
