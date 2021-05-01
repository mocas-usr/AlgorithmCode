package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/16 下午2:57
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Random;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-16 14:57
 */
public class 打乱数组 {

    class Solution {
        int[] arr;
        int[] orginal;
        Random random = new Random();

        public Solution(int[] nums) {
            arr = nums;
            orginal = nums.clone();

        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            arr = orginal;
            orginal = orginal.clone();
            return orginal;


        }

        /**
         * Returns a random shuffling of the array.
         */
        public void swap(int i,int j)
        {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

        //取中间一个随机数
        public int intRand(int min,int max)
        {
            //res一定《max
            int res=random.nextInt(max-min)+min;
            return res;
        }
        public int[] shuffle() {

            for (int i = 0; i < arr.length; i++) {
                swap(i,intRand(i,arr.length));

            }

            return arr;

        }
    }
}
