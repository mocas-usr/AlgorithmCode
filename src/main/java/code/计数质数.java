package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午12:57
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-12 12:57
 */
public class 计数质数 {
    //纯暴力解法
    public int countPrimes2(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                res++;
            }

        }
        return res;
    }

    public boolean isPrime(int k) {
        for (int i = 2; i < k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }


    public int countPrimes(int n) {
        int res = 0;
        //true是代表是质数,false默认全部不是质数
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            //质数
            if (!isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    //
                    isPrime[j] = true;
                }
            }

        }

        for (int k = 2; k < n; k++) {
            if (!isPrime[k]) {
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int res=countPrimes(10);
        System.out.println(res);
    }

}
