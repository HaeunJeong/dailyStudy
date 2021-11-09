import java.util.Arrays;

public class Main_1109_2 {
    public int solution(int[] numbers) {
        return 45-Arrays.stream(numbers).sum();
    }
}
