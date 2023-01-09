public class Solution2 {
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money/5500;
        answer[1] = (int) money%5500;
        return answer;
    }
}
