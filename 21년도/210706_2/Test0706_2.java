import java.util.Arrays;

public class Test0706_2 {

    public int solution(int[] d, int budget) {
        int count = 0;

        int[] sorted = Arrays.stream(d).sorted().toArray();
        for(int i: sorted){
            if(budget-i >= 0){
                budget -= i;
                count++;
            }
        }
        return count;
    }
}
