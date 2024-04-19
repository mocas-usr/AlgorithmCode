package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 19:05
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-14 19:05
 */
public class 蜂巢 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Scanner sc1 = new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();

        int num1 = Integer.valueOf(str1);
        int num2 = Integer.valueOf(str2);
        char[][] arr = new char[num1][num2];
        for(int i = 0; i < num1; i++){
            String str = sc.nextLine().trim();
            int index2 = 0;
            for(char ss: str.toCharArray()){
                if(ss != ' '){
                    arr[i][index2++] = ss;
                }
            }
        }
        System.out.println(getNum(arr));

    }
    public static int getNum(char[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        int ret = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 'C'){
                    ret++;
                    pollution(arr, i, j);
                }
            }
        }
        return ret;
    }
    public static void pollution(char[][] arr, int i, int j){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 'C'){
            return;
        }
        arr[i][j] = '#';
        pollution(arr,i+1,j);
        pollution(arr,i-1,j);
        pollution(arr,i,j+1);
        pollution(arr,i,j-1);
        pollution(arr,i-1,j+1);
        pollution(arr,i+1,j-1);
    }

}
