import java.util.LinkedList;

public class Solution2 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            answer[i++] = list.get((int)value);
            list.remove((int)value);
            remain = remain % factorial;
        }

        return answer;
    }
}