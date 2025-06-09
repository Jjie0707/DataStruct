package test1;

public class TEst {
    public int findKthNumber(int n, int k) {
        long current = 1;
        k--; // 因为current已经是第一个元素

        while (k > 0) {
            int steps = countSteps(current, n);
            if (steps <= k) {
                k -= steps;
                current++;
                // 说明以current开头的数字全部遍历完了也没有到第k个
            } else {
//                不用遍历完1开头的也能找到第k个，直接变成10开头
                current *= 10;
                k--;
            }
        }

        return (int) current;
    }

    private int countSteps(long current, int n) {
        int steps = 0;
        long first = current;
        long last = current;

        while (first <= n) {
            steps += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }

        return steps;
    }
}
