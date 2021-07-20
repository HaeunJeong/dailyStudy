public class Solution_07202 {

    public static void main(String[] ars) {
        int[] n = new int[]{1, 1, 1, 1, 1};
        System.out.println(solution(n, 3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, numbers[0], 0) + dfs(numbers, target, -numbers[0], 0);

        return answer;
    }

    public static int dfs(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length - 1) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int result = 0;
        result += dfs(numbers, target, sum + numbers[index + 1], index + 1);
        result += dfs(numbers, target, sum - numbers[index + 1], index + 1);
        return result;
    }

}
