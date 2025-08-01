package test0;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test test=new Test();
        String s = "letsleetcode";
        int k = 2;
        System.out.println(test.longestSubsequenceRepeatedK(s, k));
    }
    private   char[] s;

    public  String longestSubsequenceRepeatedK(String s, int k) {
        this.s = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : this.s) {
            cnt[c - 'a']++;
        }

        List<Character> cs = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            if (cnt[c - 'a'] >= k) {
                cs.add(c);
            }
        }
        Deque<String> q = new ArrayDeque<>();
        q.offer("");
        String ans = "";
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (char c : cs) {
                String nxt = cur + c;
                if (check(nxt, k)) {
                    if (nxt.length()>ans.length() ||
                            (nxt.length()==ans.length() && nxt.compareTo(ans)>0)) {
                        ans = nxt;
                    }
                    q.offer(nxt);
                }
            }
        }
        return ans;
    }

    private boolean check(String t, int k) {
        int i = 0;
        for (char c : s) {
            if (c == t.charAt(i)) {
                i++;
                if (i == t.length()) {
                    if (--k == 0) {
                        return true;
                    }
                    i = 0;
                }
            }
        }
        return false;
    }

}
