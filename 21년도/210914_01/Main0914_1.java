import java.util.*;
import java.util.stream.Stream;

public class Main0914_1 {

    public static void main(String[] args){
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;
        System.out.println(solution(N, stages));
    }

    //42889 실패율
    public static int[] solution(int N, int[] stages) {

        Map<Integer, Double> failRate = new HashMap<>();
        //스테이지에 도달한 플레이어 수 : player
        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 : loser

        Map<Integer, Integer> player = new HashMap<>();
        Map<Integer, Integer> loser = new HashMap<>();
        for(int stage: stages){
            loser.put(stage, loser.getOrDefault(stage, 0)+1);
            for(int i = 1; i<=stage; i++){
                player.put(i, player.getOrDefault(i, 0)+1);
            }
        }
        for(int i=1; i<=N; i++){
            failRate.put(i, (loser.getOrDefault(i, 0) * 1.0/player.getOrDefault(i,1)));
        }

        Stream<Map.Entry<Integer, Double>> sorted = failRate.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return sorted.map(c->c.getKey()).mapToInt(Integer::intValue).toArray();
    }


}
