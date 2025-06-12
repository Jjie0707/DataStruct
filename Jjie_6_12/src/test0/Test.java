package test0;

public class Test {
    public static int maxDifference(String s, int k) {
        int n = s.length();
        int ret = -1;

        // 前缀和数组，sum[i][j] 表示前i个字符中字符j的出现次数
        int[][] sum = new int[n + 1][5];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 5; j++) {
                sum[i + 1][j] = sum[i][j];
            }
            sum[i + 1][c - '0']++;
        }

        // 遍历所有可能的字符对 (a, b)
        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                int[][] minS = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        minS[i][j] = Integer.MAX_VALUE;
                    }
                }
                minS[sum[0][a] % 2][sum[0][b] % 2] = sum[0][a] - sum[0][b];

                int left = 0;

                for (int right = 0; right < n; right++) {
                    // 维护窗口大小至少为 k
                    while (right - left + 1 >= k) {
                        int currentA = sum[right + 1][a];
                        int currentB = sum[right + 1][b];
                        int p = currentA % 2;
                        int q = currentB % 2;

                        int targetP = 1 - p;
                        int targetQ = q;

                        // 确保 sum[r][b] > sum[l][b] 且 sum[r][a] > sum[l][a]
                        if (minS[targetP][targetQ] != Integer.MAX_VALUE) {
                            int diff = (currentA - currentB) - minS[targetP][targetQ];
                            if (diff > ret) {
                                ret = diff;
                            }
                        }

                        // 更新 minS
                        int pLeft = sum[left][a] % 2;
                        int qLeft = sum[left][b] % 2;
                        if (sum[left][a] - sum[left][b] < minS[pLeft][qLeft]) {
                            minS[pLeft][qLeft] = sum[left][a] - sum[left][b];
                        }

                        left++;
                    }

                    // 更新 minS
                    int pRight = sum[right + 1][a] % 2;
                    int qRight = sum[right + 1][b] % 2;
                    if (sum[right + 1][a] - sum[right + 1][b] < minS[pRight][qRight]) {
                        minS[pRight][qRight] = sum[right + 1][a] - sum[right + 1][b];
                    }
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        String s="11222";
        int k=3;
        System.out.println(maxDifference(s,k));
    }
}