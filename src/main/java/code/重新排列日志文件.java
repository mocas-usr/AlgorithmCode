package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/19 下午6:57
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-19 18:57
 */
public class 重新排列日志文件 {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDIgit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDIgit2) {
                int cmp=split1[1].compareTo(split2[1]);
                if (cmp!=0)
                {
                    return cmp;
                }else
                {
                    return split1[0].compareTo(split2[0]);
                }
            }
            //如果split1是数字字符，且split2是数字字符返回0，
            // 如果split1是数字字符，且split2是字母字符返回1，即split1>split2,从小到大排序，split2提前
            // 如果split1是字母字符，返回-1，
            if (isDigit1)
            {
                if (isDIgit2)
                {
                    return 0;
                }else
                {
                    return 1;
                }
            }else
            {
                return -1;
            }
        });
        return logs;
    }
}
