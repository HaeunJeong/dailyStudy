import java.util.HashMap;
import java.util.Map;

public class Test0706_1 {


    public static void main(String[] args){
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};

        int[] result = solution(lottos, win_nums);
        System.out.println(String.format("%d, %d",result[0], result[1]));
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i:lottos){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i:win_nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int same = (int) map.keySet().stream().filter(k->map.getOrDefault(k, 0)==2 && k!=0).count();

        answer[0] = 7-(same+map.getOrDefault(0, 0)) >=6? 6: 7-(same+map.getOrDefault(0, 0));
        answer[1] = 7-same>=6 ? 6:7-same;

        return answer;
    }
}
