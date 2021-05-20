package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/17 下午7:49
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-17 19:49
 */
public class 多次搜索 {
    class TrieNode {
        String end;
        TrieNode[] next = new TrieNode[26];
    }

    class Trie {
        TrieNode root;

        public Trie(String[] words) {
            root = new TrieNode();
            for (String word : words) {
                TrieNode node = root;
                for (char w : word.toCharArray()) {
                    int i = w - 'a';
                    if (node.next[i] == null) {
                        node.next[i] = new TrieNode();
                    }
                    node = node.next[i];
                }
                node.end = word;
            }

        }

        public List<String> search(String str) {
            TrieNode node = root;
            List<String> res = new ArrayList<>();
            for (char c : str.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    break;
                }
                node = node.next[i];
                if (node.end != null) {
                    res.add(node.end);
                }
            }
            return res;
        }
    }


    public int[][] multiSearch(String big, String[] smalls) {

        Trie trie = new Trie(smalls);
        Map<String, List<Integer>> hit = new HashMap<>();
        for (int i = 0; i < big.length(); i++) {
            List<String> matchs = trie.search(big.substring(i));
            for (String word : matchs) {
                if (!hit.containsKey(word)) {
                    hit.put(word, new ArrayList<>());
                }
                hit.get(word).add(i);
            }
        }
        int[][] res = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> list = hit.get(smalls[i]);
            if (list == null) {
                res[i] = new int[0];
                continue;
            }
            int size = list.size();
            res[i] = new int[size];
            for (int j = 0; j < size; j++) {
                res[i][j] = list.get(j);
            }
        }
        return res;

    }


    @Test
    public void test() {
        String big = "mississippi";
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        int[][] res = multiSearch(big, smalls);
        System.out.println(res);
    }
}
