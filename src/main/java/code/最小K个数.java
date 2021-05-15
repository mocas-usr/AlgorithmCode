package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 下午3:21
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 15:21
 */
public class 最小K个数 {

    public int[] smallestK(int[] arr, int k) {

        int[] res = new int[k];

        quickSort(arr, 0, arr.length - 1, k);
        for (int i=0;i<k;i++)
        {
            res[i]=arr[i];
        }
        return res;
    }


    public void quickSort(int[] arr, int left, int right, int k) {
        if (left > right) {
            return;
        }

        int stand = partion(arr, left, right);
        if (stand > k) {
            quickSort(arr, left, stand - 1, k);
        } else if (stand < k) {
            quickSort(arr, stand + 1, right, k);
        } else {
            return;
        }
        return;
    }

    public int partion(int[] arr, int left, int right) {
        int index=left;
        int temp=arr[left];
        while (left<right)
        {
            while (left<right && arr[right]>=temp)
            {
                right--;
            }
            while (left<right && arr[left]<=temp)
            {
                left++;
            }
            if (left<right)
            {
                swap(arr,left,right);
            }

        }
        //left=right
        swap(arr,index,left);
        return left;
    }

    public void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
